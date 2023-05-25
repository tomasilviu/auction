package ro.unibuc.info.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Bid {
    private int id;
    private String name;
    private double value;
    private LocalDateTime timeStamp;

    public Bid(String name, double value, LocalDateTime timestamp) {
        this.name = name;
        this.value = value;
        this.timeStamp = timestamp;
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

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    // Set the timeStamp to the current server time
    public void setTimeStampNow() {
        timeStamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Bid{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name=").append(name);
        sb.append(", value=").append(value);
        sb.append(", timeStamp=").append(timeStamp.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        // ISO_LOCAL_DATE_TIME format: yyyy-MM-dd'T'HH:mm:ss.SSS
        sb.append('}');
        return sb.toString();
    }
}