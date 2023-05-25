package ro.unibuc.info.libraries;

import org.mindrot.PasswordHasher;
import ro.unibuc.info.model.DigitalAsset;
import ro.unibuc.info.model.PhysicalAsset;
import ro.unibuc.info.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DataBaseManager {
    private String url;
    private final String username;
    private final String password;
    private Connection connection;

    public DataBaseManager(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void connect() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to: " + url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Disconnected from: " + this.url);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private String sanitize(String name) {
        return name.replaceAll("[^a-zA-Z0-9_]", "");
    }
    public void CreateAuctionDatabase() {
        // Not created or checked with prepared statements
        // Important! Do not modify so it takes parameters
        //            that execute any query in DB
        String dbName = "auction";
        boolean databaseExists = false;

        try {
            // Check if "auction" database exists
            String checkDatabaseQuery = "SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME = '" + dbName + "'";
            try (Statement checkStmt = connection.createStatement()) {
                try (ResultSet resultSet = checkStmt.executeQuery(checkDatabaseQuery)) {
                    if (resultSet.next()) {
                        databaseExists = true;
                    }
                }
            }

            // If "auction" database exists
            if (!databaseExists) {
                dbName = sanitize(dbName);
                String createDatabaseQuery = "CREATE DATABASE " + dbName;
                try (Statement createStmt = connection.createStatement()) {
                    createStmt.executeUpdate(createDatabaseQuery);
                    System.out.println("Database " + dbName + " created successfully");
                }
            }

            // Use the "auction" database
            disconnect();
            url += "/" + dbName;
            connect();

            // Check if "users" table exists
            String checkTableQuery = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = '" + dbName + "' AND TABLE_NAME = 'users'";
            try (Statement checkStmt = connection.createStatement()) {
                try (ResultSet resultSet = checkStmt.executeQuery(checkTableQuery)) {
                    if (resultSet.next()) {
                        System.out.println("Table 'users' exists");
                    } else {
                        // Create "users" table if it doesn't exist
                        String createTableQuery = "CREATE TABLE users ("
                                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                                + "name VARCHAR(255) NOT NULL,"
                                + "email VARCHAR(255) NOT NULL,"
                                + "password_hash VARCHAR(255) NOT NULL,"
                                + "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
                                + ")";

                        try (Statement createStmt = connection.createStatement()) {
                            createStmt.executeUpdate(createTableQuery);
                            System.out.println("Table 'users' created successfully");
                        }
                    }
                }
            }

            // Check if "auctions" table exists
            checkTableQuery = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = '" + dbName + "' AND TABLE_NAME = 'auctions'";
            try (Statement checkStmt = connection.createStatement()) {
                try (ResultSet resultSet = checkStmt.executeQuery(checkTableQuery)) {
                    if (resultSet.next()) {
                        System.out.println("Table 'auctions' exists");
                    } else {
                        // Create "users" table if it doesn't exist
                        String createTableQuery = "CREATE TABLE auctions ("
                                + "    id INT AUTO_INCREMENT PRIMARY KEY,"
                                + "    start_date DATETIME,"
                                + "    end_date DATETIME,"
                                + "    fixed_price DECIMAL(10, 2)"
                                + ")";

                        try (Statement createStmt = connection.createStatement()) {
                            createStmt.executeUpdate(createTableQuery);
                            System.out.println("Table 'auctions' created successfully");
                        }
                    }
                }
            }

            // Check if "bids" table exists
            checkTableQuery = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = '" + dbName + "' AND TABLE_NAME = 'bids'";
            try (Statement checkStmt = connection.createStatement()) {
                try (ResultSet resultSet = checkStmt.executeQuery(checkTableQuery)) {
                    if (resultSet.next()) {
                        System.out.println("Table 'bids' exists");
                    } else {
                        // Create "users" table if it doesn't exist
                        String createTableQuery = "CREATE TABLE bids ("
                                + "    id INT AUTO_INCREMENT PRIMARY KEY,"
                                + "    auction_id INT,"
                                + "    bid_amount DECIMAL(10, 2),"
                                + "    FOREIGN KEY (auction_id) REFERENCES auctions(id)"
                                + ")";

                        try (Statement createStmt = connection.createStatement()) {
                            createStmt.executeUpdate(createTableQuery);
                            System.out.println("Table 'bids' created successfully");
                        }
                    }
                }
            }

            // Check if "digital_assets" table exists
            checkTableQuery = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = '" + dbName + "' AND TABLE_NAME = 'digital_assets'";
            try (Statement checkStmt = connection.createStatement()) {
                try (ResultSet resultSet = checkStmt.executeQuery(checkTableQuery)) {
                    if (resultSet.next()) {
                        System.out.println("Table 'digital_assets' exists");
                    } else {
                        // Create "users" table if it doesn't exist
                        String createTableQuery = "CREATE TABLE digital_assets ("
                                + "    id INT AUTO_INCREMENT PRIMARY KEY,"
                                + "    auction_id INT,"
                                + "    name VARCHAR(255), "
                                + "    description TEXT, "
                                + "    registered_user_id INT, "
                                + "    file_format VARCHAR(50), "
                                + "    file_size BIGINT, "
                                + "    download_link VARCHAR(255), "
                                + "    FOREIGN KEY (auction_id) REFERENCES auctions(id) "
                                + ")";

                        try (Statement createStmt = connection.createStatement()) {
                            createStmt.executeUpdate(createTableQuery);
                            System.out.println("Table 'digital_assets' created successfully");
                        }
                    }
                }
            }

            // Check if "physical_assets" table exists
            checkTableQuery = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = '" + dbName + "' AND TABLE_NAME = 'physical_assets'";
            try (Statement checkStmt = connection.createStatement()) {
                try (ResultSet resultSet = checkStmt.executeQuery(checkTableQuery)) {
                    if (resultSet.next()) {
                        System.out.println("Table 'physical_assets' exists");
                    } else {
                        // Create "users" table if it doesn't exist
                        String createTableQuery = "CREATE TABLE physical_assets ("
                                + "    id INT AUTO_INCREMENT PRIMARY KEY,"
                                + "    auction_id INT,"
                                + "    name VARCHAR(255), "
                                + "    producer VARCHAR(255), "
                                + "    description TEXT, "
                                + "    registered_user_id INT, "
                                + "    FOREIGN KEY (auction_id) REFERENCES auctions(id) "
                                + ")";

                        try (Statement createStmt = connection.createStatement()) {
                            createStmt.executeUpdate(createTableQuery);
                            System.out.println("Table 'physical_assets' created successfully");
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean checkEmail(String email) {
        String query = "SELECT COUNT(*) FROM users WHERE email = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    if(count==0){
                        return true;
                    }
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public void registerUser(User user) {
        if(checkEmail(user.getEmail())==false){
            System.out.println("Email already exists");
            return;
        }
        try {
            String query = "INSERT INTO users (name, email, password_hash) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPasswordHash());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("User registered successfully!");
            } else {
                System.out.println("Failed to register user.");
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int checkPasswordWithEmail(String email, String password){
        /*
         It should have two parameters: email and passwordHash.
         The method must return the id of the register in the table users
         Where the email field is equal to the one in the parameter lists
         if the register has an equal hash in the password_hash field
         */
            String query = "SELECT id, password_hash FROM users WHERE email = ?";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, email);


                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        boolean verify = PasswordHasher.verifyPassword(password, resultSet.getString("password_hash"));
                        if(verify){
                            return resultSet.getInt("id");
                        }else{
                            return -1;
                        }
                    }
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }

            return -1; // Return -1 if no matching record is found

    }
    public String getNameByEmail(String email){
        String query = "SELECT name FROM users WHERE email = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString("name");
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    public void saveDigitalAsset(DigitalAsset digitalAsset) {
        try {
            String query = "INSERT INTO digital_assets (name, description, registered_user_id, file_format, file_size, download_link) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, digitalAsset.getName());
            statement.setString(2, digitalAsset.getDescription());
            statement.setInt(3, digitalAsset.getRegisteredUserId());
            statement.setString(4, digitalAsset.getFileFormat());
            statement.setLong(5, digitalAsset.getFileSize());
            statement.setString(6, digitalAsset.getDownloadLink());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Digital asset saved successfully!");
            } else {
                System.out.println("Failed to save digital asset.");
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void savePhysicalAsset(PhysicalAsset physicalAsset) {
        try {
            String query = "INSERT INTO physical_assets (name, description, registered_user_id, producer) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, physicalAsset.getName());
            statement.setString(2, physicalAsset.getDescription());
            statement.setInt(3, physicalAsset.getRegisteredUserId());
            statement.setString(4, physicalAsset.getProducer());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Physical asset saved successfully!");
            } else {
                System.out.println("Failed to save physical asset.");
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<PhysicalAsset> getPhysicalAssets(int userId) {
        List<PhysicalAsset> physicalAssets = new ArrayList<>();

        try {
            String query = "SELECT id, name, description, registered_user_id, producer FROM physical_assets WHERE registered_user_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, userId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                int registeredUserId = resultSet.getInt("registered_user_id");
                String producer = resultSet.getString("producer");

                PhysicalAsset physicalAsset = new PhysicalAsset(id, name, description, registeredUserId, producer);
                physicalAssets.add(physicalAsset);
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return physicalAssets;
    }

    public List<DigitalAsset> getDigitalAssets(int userId) {
        List<DigitalAsset> digitalAssets = new ArrayList<>();

        try {
            String query = "SELECT id, name, description, registered_user_id, file_path FROM digital_assets WHERE registered_user_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, userId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                int registeredUserId = resultSet.getInt("registered_user_id");
                String filePath = resultSet.getString("file_path");

                DigitalAsset digitalAsset = new DigitalAsset(id, name, description, registeredUserId, filePath);
                digitalAssets.add(digitalAsset);
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return digitalAssets;
    }

    public boolean createAuction(){
        return false;
    }
}