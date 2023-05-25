package ro.unibuc.info.libraries;
import org.mindrot.PasswordHasher;
import ro.unibuc.info.model.DigitalAsset;
import ro.unibuc.info.model.PhysicalAsset;
import ro.unibuc.info.model.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import java.util.Scanner;

public class UsersManager {
    private DataBaseManager db;
    private User loggedInUser;
    public UsersManager(DataBaseManager db){
        this.db = db;
        loggedInUser = new User();
    }
    public User getLoggedInUser() {
        return loggedInUser;
    }
    public void setLoggedInUsers(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }
    public void addUser(User user) {
        loggedInUser = user;
    }
    public boolean emailIsValid(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }
    public boolean passwordIsValid(String password) {
        return password.length() >= 6;
    }
    public void readUserDetails() {
        Scanner scanner = new Scanner(System.in);
        User user = new User();

        System.out.println("Enter name:");
        String name = scanner.nextLine();
        user.setName(name);

        System.out.println("Enter email:");
        String email = scanner.nextLine();
        if(!db.checkEmail(email)){
            System.out.println("Email already exists");
            return;
        }
        user.setEmail(email);

        System.out.println("Enter password:");
        String password = scanner.nextLine();
        user.setPassword(password);

        if(emailIsValid(user.getEmail())){
            if(passwordIsValid(password)){
                db.registerUser(user);
            }else{
                System.out.println("Password not strong enough. It should be at least 6 characters!");
            }
        }else{
            System.out.println(user.getEmail() + " is not valid");
        }
    }

    public boolean authenticate(String email, String password){
        String passwordHash = PasswordHasher.hashPassword(password);
        int id = db.checkPasswordWithEmail(email, password);
        if(id >= 0){
            String name = db.getNameByEmail(email);
            User u = new User(id,name,email);
            addUser(u);
            System.out.println("Hello "+name+"! You are now logged in");
            return true;
        }else{
            return false;
        }
    }
    public void logOut(){
        loggedInUser = new User();
    }
    public boolean createAuction(){
        return true;
    }
    public void showAuctions(){
        //db.getDigitalAssets();
    }
    public void showDigitalAssets(){
        //db.getDigitalAssets();
    }
    public boolean showPhysicalAssets(){
        return true;
    }
    public void registerDigitalAsset(){
        Scanner scanner = new Scanner(System.in);
        DigitalAsset digitalAsset = new DigitalAsset();

        System.out.println("name:");
        String name = scanner.nextLine();
        digitalAsset.setName(name);

        System.out.println("description:");
        String description = scanner.nextLine();
        digitalAsset.setDescription(description);

        digitalAsset.setRegisteredUserId(loggedInUser.getId());

        System.out.println("file format:");
        String fileFormat = scanner.nextLine();
        digitalAsset.setFileFormat(fileFormat);

        System.out.println("file size:");
        long fileSize = scanner.nextLong();
        digitalAsset.setFileSize(fileSize);
        scanner.nextLine();

        System.out.println("download link:");
        String downloadLink = scanner.nextLine();
        digitalAsset.setDownloadLink(downloadLink);

        System.out.println(digitalAsset);
        db.saveDigitalAsset(digitalAsset);
    }
    public void registerPhysicalAsset() {
        Scanner scanner = new Scanner(System.in);
        PhysicalAsset physicalAsset = new PhysicalAsset();

        System.out.println("Name:");
        String name = scanner.nextLine();
        physicalAsset.setName(name);

        System.out.println("Description:");
        String description = scanner.nextLine();
        physicalAsset.setDescription(description);

        physicalAsset.setRegisteredUserId(loggedInUser.getId());

        System.out.println("Producer:");
        String producer = scanner.nextLine();
        physicalAsset.setProducer(producer);

        System.out.println(physicalAsset);
        db.savePhysicalAsset(physicalAsset);
    }
}
