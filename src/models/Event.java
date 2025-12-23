package models;

import java.time.LocalTime;
import models.Participant;
import java.util.List;
import java.util.ArrayList;

public class Event {

    private String title;
    private int maxCapacity;
    private LocalTime startTime;
    private List<Participant> enrolledParticipants;

    public Event(String title, int maxCapacity, LocalTime startTime) {
        this.title = title;
        this.maxCapacity = maxCapacity;
        this.startTime = startTime;
        this.enrolledParticipants = new ArrayList<>();
    }

    public boolean addParticipant(Participant participant) {
        if (this.enrolledParticipants.size() >= this.maxCapacity) {
            System.out.println("Sorry, event is full!");
            return false;
        }

        if (enrolledParticipants.contains(participant)) {
            System.out.println(participant.getName() + " is already registered.");
            return false;
        }

        this.enrolledParticipants.add(participant);
        return true;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public List<Participant> getEnrolledParticipants() {
        return List.copyOf(this.enrolledParticipants);
    }

    public String toString() {
        String res = this.title + ". Start time: " + this.startTime + ". Participants:\n";
        for (int i = 0; i < this.enrolledParticipants.size(); i++) {
            res += this.enrolledParticipants.get(i).toString() + "\n";
        }
        return res;
    }

}
