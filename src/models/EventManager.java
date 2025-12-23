package models;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class EventManager {

    private List<Event> events;

    public EventManager() {
        this.events = new ArrayList<>();
    }

    public Event createEvent(String title, int maxCapacity, LocalTime startTime) {
        Event event = new Event(title, maxCapacity, startTime);
        events.add(event);
        return event;
    }

    public boolean registerParticipant(Event event, Participant participant) {
        if (!events.contains(event)) {
            System.out.println("Event not managed by this EventManager.");
            return false;
        }
        return event.addParticipant(participant);
    }

    public Event findEventByTitle(String title) {
        for (Event event : events) {
            if (event.getTitle().equalsIgnoreCase(title)) {
                return event;
            }
        }
        return null;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void printAllEvents() {
        if (events.isEmpty()) {
            System.out.println("No events available.");
            return;
        }

        for (Event event : events) {
            System.out.println(event);
        }
    }
}
