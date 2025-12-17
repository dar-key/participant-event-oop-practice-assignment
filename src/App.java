import java.time.LocalTime;

import models.Event;
import models.Participant;

public class App {
    public static void main(String[] args) {
        Event event1 = new Event("Meetup In Office 1", 3, LocalTime.of(12, 30, 0));

        Participant part1 = new Participant("Bob", "bob155@work.com");

        event1.addParticipant(part1);

        System.out.println(event1);

        part1.setEmail("r.bob@work.com");

        System.out.println(event1);

        Participant part2 = new Participant("John", "a.john@mail.com");
        event1.addParticipant(part2);

        System.out.println(event1);

        event1.addParticipant(part2);
        event1.setMaxCapacity(2);
        event1.addParticipant(new Participant("Walter", "white@work.com"));

        Event event2 = new Event("Important Event", 1, LocalTime.of(15, 0, 0));
        event2.addParticipant(part2);
        System.out.println(event2);
    }
}
