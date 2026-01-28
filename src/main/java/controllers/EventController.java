package controllers;

import models.Event;
import models.Webinar;
import models.Workshop;
import services.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @PostMapping("/workshop")
    public Event createWorkshop(@RequestBody Workshop workshop) {
        return eventService.saveEvent(workshop);
    }

    @PostMapping("/webinar")
    public Event createWebinar(@RequestBody Webinar webinar) {
        return eventService.saveEvent(webinar);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable int id) {
        eventService.deleteEvent(id);
    }

    @PostMapping("/{eventId}/register/{participantId}")
    public Event registerParticipant(@PathVariable int eventId, @PathVariable int participantId) {
        return eventService.registerParticipantToEvent(eventId, participantId);
    }
}
