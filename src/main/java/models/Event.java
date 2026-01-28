package models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "event_type", discriminatorType = DiscriminatorType.STRING)
@Table(name = "events")
public abstract class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @NotBlank(message = "Title cannot be empty")
    private String title;

    @Min(value = 1, message = "Capacity must be at least 1")
    private int maxCapacity;

    @NotNull(message = "Start time is required")
    private LocalDateTime startTime;

    public Event() {
    }

    // init
    public Event(String title, int maxCapacity, LocalDateTime startTime) {
        this.title = title;
        this.maxCapacity = maxCapacity;
        this.startTime = startTime;
    }

    @ManyToMany
    @JoinTable(name = "event_enrollments", joinColumns = @JoinColumn(name = "event_id"), inverseJoinColumns = @JoinColumn(name = "participant_id"))
    private List<Participant> participants = new ArrayList<>();

    public List<Participant> getParticipants() {
        return participants;
    }

    public void addParticipant(Participant participant) {
        this.participants.add(participant);
        participant.getEvents().add(this);
    }

    // Encapsulation
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

}
