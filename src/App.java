import java.time.LocalTime;
import java.util.List;

import models.Event;
import models.EventManager;
import models.Participant;
import models.Webinar;
import models.Workshop;

public class App {
    public static void main(String[] args) {
        EventManager manager = new EventManager();

        // Participants
        Participant p1 = new Participant("Alice", "alice@example.com");
        Participant p2 = new Participant("Bob", "bob@example.com");
        Participant p3 = new Participant("Charlie", "charlie@example.com");

        // Creating events
        Event evt1 = new Workshop("Java Basics", 2, LocalTime.of(10, 0), "Room 101");
        Event evt2 = new Webinar("Advanced OOP", 5, LocalTime.of(14, 30), "https://google.meet.com/123");
        Event evt3 = new Workshop("Morning Yoga", 10, LocalTime.of(07, 0), "Gym A");

        manager.addEvent(evt1);
        manager.addEvent(evt2);
        manager.addEvent(evt3);

        // Registering Participants
        System.out.println("--- Registration Phase ---");
        manager.registerParticipant(evt1, p1);
        manager.registerParticipant(evt1, p2);
        manager.registerParticipant(evt1, p3); // Should fail (capacity 2)

        manager.registerParticipant(evt2, p2);

        // Testing duplicate check (equals method)
        manager.registerParticipant(evt2, new Participant("Bob", "bob@example.com"));

        // Print Unsorted
        manager.printAllEvents();

        // Sorting
        manager.sortEventsByTime();
        manager.printAllEvents();

        // Filtering
        System.out.println("\nFiltering available...");
        List<Event> openEvents = manager.filterAvailableEvents();
        for (Event e : openEvents) {
            System.out.println("Available: " + e);
        }
    }
}
