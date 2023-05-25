package ro.unibuc.info.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PhysicalAsset extends Product {
    private String producer;

    public PhysicalAsset(int id, String name, String description, int registeredUserId, String producer, LocalDateTime creationDate) {
        super(id, name, description, registeredUserId);
        this.producer = producer;
    }

    public PhysicalAsset() {

    }

    public PhysicalAsset(int id, String name, String description, int registeredUserId, String producer) {
        super(id, name, description, registeredUserId);
        this.producer = producer;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }



    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PhysicalAsset{");
        sb.append("id='").append(getId()).append('\'');
        sb.append(", name=").append(getName());
        sb.append(", description=").append(getDescription());
        sb.append(", registeredUserId=").append(getRegisteredUserId());
        sb.append(", producer=").append(producer);
        sb.append('}');
        return sb.toString();
    }
}