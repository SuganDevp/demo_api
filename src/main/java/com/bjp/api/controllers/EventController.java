package com.bjp.api.controllers;

import com.bjp.api.models.Event;
import com.bjp.api.services.service.EventService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

import static com.bjp.api.utils.commonUtils.Payload.response;
import static java.lang.String.format;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/event")
public class EventController {
    private final EventService eventService;

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createEvent(@RequestBody @NonNull Event event) {
        try {
            return ok(response(eventService.eventSaveAndUpdate(event), "Create event successful", 200));
        } catch (Exception ex) {
            return badRequest().body(response(event, ex.getMessage(), 500));
        }
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> findAllEvent() {
        try {
            return ok(response(eventService.findAllEvent(), "fetch all event successful", 200));
        } catch (Exception ex) {
            return badRequest().body(response(new HashMap<>(), ex.getMessage(), 500));
        }
    }

    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> findEventById(@PathVariable("id") @NonNull String eventId) {
        try {
            return ok(
                    response(eventService.findEventById(eventId).orElseGet(Event::new), "find event successful", 200));
        } catch (Exception ex) {
            return badRequest().body(response(new HashMap<>(), ex.getMessage(), 500));
        }
    }

    @PutMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateEvent(@RequestBody @NonNull Event event) {
        try {
            return ok(response(eventService.eventSaveAndUpdate(event), "update event successful", 200));
        } catch (Exception ex) {
            return badRequest().body(response(new HashMap<>(), ex.getMessage(), 500));
        }
    }

    @DeleteMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteEvent(@PathVariable("id") String eventId) {
        try {
            eventService.deleteEventById(eventId);
            return ok(response(new HashMap<>(), format("Delete event: %s successful", eventId), 200));
        } catch (Exception ex) {
            return badRequest().body(response(new HashMap<>(), ex.getMessage(), 500));
        }
    }

}
