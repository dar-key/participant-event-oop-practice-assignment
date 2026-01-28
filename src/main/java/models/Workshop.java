package models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("WORKSHOP")
public class Workshop extends Event {
    private String location;

    public Workshop() {}

    public Workshop(String title, int maxCapacity, LocalDateTime startTime, String location) {
        super(title, maxCapacity, startTime);
        this.location = location;
    }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}
