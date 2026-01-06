package models;

import java.time.LocalTime;
import models.Participant;
import java.util.List;
import java.util.Objects;
import java.util.ArrayList;

public abstract class Event implements Comparable<Event> { // abstract class

    private String title;
    private int maxCapacity;
    private LocalTime startTime;
    private List<Participant> enrolledParticipants;

    // init
    public Event(String title, int maxCapacity, LocalTime startTime) {
        this.title = title;
        this.maxCapacity = maxCapacity;
        this.startTime = startTime;
        this.enrolledParticipants = new ArrayList<>();
    }

    // Methods
    public boolean addParticipant(Participant participant) {
        if (this.enrolledParticipants.size() >= this.maxCapacity) {
            System.out.println("Failed: " + title + " is full.");
            return false;
        }

        if (enrolledParticipants.contains(participant)) {
            System.out.println("Failed: " + participant.getName() + " is already registered in " + title);
            return false;
        }

        this.enrolledParticipants.add(participant);
        return true;
    }

    // Encapsulation
    public String getTitle() {
        return title;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public boolean setMaxCapacity(int maxCapacity) {
        if (maxCapacity < this.enrolledParticipants.size()) {
            return false;
        }
        this.maxCapacity = maxCapacity;
        return true;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public List<Participant> getEnrolledParticipants() {
        return List.copyOf(this.enrolledParticipants);
    }

    @Override
    public int compareTo(Event other) {
        return this.startTime.compareTo(other.startTime);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Event event = (Event) o;
        return Objects.equals(title, event.title) &&
                Objects.equals(startTime, event.startTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, startTime);
    }

    @Override
    public String toString() {
        return String.format("Event: %s | Start Time: %s | Slots: %d/%d", title, startTime,
                enrolledParticipants.size(), maxCapacity);
    }

    // Abstraction
    public abstract String getEventType();

}
