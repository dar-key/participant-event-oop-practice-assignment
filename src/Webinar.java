import java.time.LocalTime;

import models.Event;

public class Webinar extends Event {

    private String platformUrl;

    // init
    public Webinar(String title, int maxCapacity, LocalTime startTime, String platformUrl) {
        super(title, maxCapacity, startTime);
        this.platformUrl = platformUrl;
    }

    @Override
    public String getEventType() {
        return "Online Webinar";
    }

    @Override
    public String toString() {
        return super.toString() + " | Link: " + platformUrl;
    }

}
