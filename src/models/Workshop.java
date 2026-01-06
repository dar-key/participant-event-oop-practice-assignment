package models;

import java.time.LocalTime;

public class Workshop extends Event {

    private String location;

    // init
    public Workshop(String title, int maxCapacity, LocalTime startTime, String location) {
        super(title, maxCapacity, startTime);
        this.location = location;
    }

    @Override
    public String getEventType() {
        return "In-persion workshop";
    }

    @Override
    public String toString() {
        return super.toString() + " | Loc: " + location;
    }

}
