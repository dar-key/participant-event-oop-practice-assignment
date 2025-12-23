import java.time.LocalTime;

import models.Event;
import models.EventManager;
import models.Participant;

public class App {
    public static void main(String[] args) {
        EventManager eventManager = new EventManager();
        Event event1 = eventManager.createEvent("Important Event", 2, null);
        Participant part1 = new Participant("Bob", "bob155@work.com");

        eventManager.registerParticipant(event1, part1);
        eventManager.printAllEvents();

        part1.setEmail("r.bob@work.com");
        eventManager.printAllEvents();

        Participant part2 = new Participant("John", "a.john@mail.com");
        eventManager.registerParticipant(event1, part2);
        eventManager.printAllEvents();

        eventManager.registerParticipant(event1, part2); // John is already registered.
        if (!event1.setMaxCapacity(1)) {
            System.out.println("Error: capacity too small");
        }

        Event event2 = eventManager.createEvent("Very Important Event", 1, LocalTime.of(15, 0, 0));
        eventManager.registerParticipant(event2, new Participant("Walter", "white@work.com"));
        eventManager.registerParticipant(event2, part2);

        eventManager.printAllEvents();
        eventManager.findEventByTitle("Very Important Event");
    }
}
