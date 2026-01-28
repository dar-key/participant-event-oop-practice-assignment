package models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("WEBINAR")
public class Webinar extends Event {
    private String platformUrl;

    public Webinar() {}

    public Webinar(String title, int maxCapacity, LocalDateTime startTime, String platformUrl) {
        super(title, maxCapacity, startTime);
        this.platformUrl = platformUrl;
    }

    public String getPlatformUrl() { return platformUrl; }
    public void setPlatformUrl(String platformUrl) { this.platformUrl = platformUrl; }
}
