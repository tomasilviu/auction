package ro.unibuc.info.model;

public class Product {
    private int id;
    private String name;
    private String description;
    private int registeredUserId;
    public Product(){

    }

    public Product(int id, String name, String description, int registeredUserId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.registeredUserId = registeredUserId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRegisteredUserId() {
        return registeredUserId;
    }

    public void setRegisteredUserId(int registeredUserId) {
        this.registeredUserId = registeredUserId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name=").append(name);
        sb.append(", description").append(description);
        sb.append(", registeredUserId").append(registeredUserId);
        sb.append('}');
        return sb.toString();
    }
}