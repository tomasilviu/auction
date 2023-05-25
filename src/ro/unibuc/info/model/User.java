package ro.unibuc.info.model;
import org.mindrot.PasswordHasher;

public class User {
    private int id;
    private String name;
    private String email;
    private String passwordHash;
    public User(){

    }
    public User(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.passwordHash = PasswordHasher.hashPassword(password);
    }
    public User(int id, String name, String email) {
        this.name = name;
        this.email = email;
        this.id = id;
    }
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.passwordHash = PasswordHasher.hashPassword(password);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPasswordHash() {
        return passwordHash;
    }
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
    public void setPassword(String password) {
        this.passwordHash = PasswordHasher.hashPassword(password);
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name=").append(name);
        sb.append(", email").append(email);
        sb.append('}');
        return sb.toString();
    }
}