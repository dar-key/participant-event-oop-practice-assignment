package models;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EventManager {

    private List<Event> events;

    // init
    public EventManager() {
        this.events = new ArrayList<>();
    }

    // Methods
    public void addEvent(Event event) { // polymorphism (accepts any child of Event)
        this.events.add(event);
    }

    public boolean registerParticipant(Event event, Participant participant) {
        if (!events.contains(event)) {
            System.out.println("Failed: Event is not managed by this EventManager.");
            return false;
        }
        return event.addParticipant(participant);
    }

    public void sortEventsByTime() {
        Collections.sort(events);
        System.out.println("\nEvents Sorted by Time!");
    }

    public void sortEventsByTitle() {
        events.sort(Comparator.comparing(Event::getTitle));
        System.out.println("\nEvents Sorted by Title!");
    }

    public List<Event> filterAvailableEvents() {
        List<Event> available = new ArrayList<>();
        for (Event e : events) {
            if (e.getEnrolledParticipants().size() < e.getMaxCapacity()) {
                available.add(e);
            }
        }
        return available;
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
        return List.copyOf(this.events);
    }

    public void printAllEvents() {
        if (events.isEmpty()) {
            System.out.println("No events.");
            return;
        }

        System.out.println("\nAll events:");
        for (Event event : events) {
            System.out.println(event);
        }
    }
}
