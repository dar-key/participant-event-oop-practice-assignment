package controllers;

import models.Event;
import models.Participant;
import models.Webinar;
import models.Workshop;
import repositories.EventRepository;
import repositories.ParticipantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ParticipantRepository participantRepository;

    @GetMapping
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @PostMapping("/workshop")
    public Event createWorkshop(@RequestBody Workshop workshop) {
        return eventRepository.save(workshop);
    }

    @PostMapping("/webinar")
    public Event createWebinar(@RequestBody Webinar webinar) {
        return eventRepository.save(webinar);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable int id) {
        eventRepository.deleteById(id);
    }

    @PostMapping("/{eventId}/register/{participantId}")
    public Event registerParticipant(@PathVariable int eventId, @PathVariable int participantId) {

        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found"));

        Participant participant = participantRepository.findById(participantId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Participant not found"));

        // Check capacity
        if (event.getParticipants().size() >= event.getMaxCapacity()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Event is full");
        }

        event.addParticipant(participant);

        return eventRepository.save(event);
    }
}
