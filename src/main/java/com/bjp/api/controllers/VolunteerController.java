package com.bjp.api.controllers;

import com.bjp.api.models.Volunteer;
import com.bjp.api.services.service.VolunteerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

import static com.bjp.api.utils.commonUtils.Payload.response;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;
import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/volunteer")
public class VolunteerController {

    private final VolunteerService volunteerService;

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createVolunteer(@RequestBody Volunteer volunteer) {
        try {
            return ok(response(volunteerService.saveAndUpdate(volunteer), "create volunteer successful", 200));
        } catch (Exception ex) {
            return badRequest().body(response(new HashMap<>(), ex.getMessage(), 500));
        }
    }

    @PutMapping(path = "/upload/{volunteerId}", consumes = MULTIPART_FORM_DATA_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> upload(@PathVariable("volunteerId") @NonNull String volunteerId,
            @RequestParam("image") @NonNull MultipartFile file) {
        try {
            volunteerService.updateVolunteerProfile(volunteerId, file);
            return ok(response(new HashMap<>(), "Profile updated", 200));
        } catch (Exception ex) {
            return badRequest().body(response(new HashMap<>(), ex.getMessage(), 500));
        }
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> findAllVolunteer() {
        try {
            return ok(response(volunteerService.findAllVolunteer(), "fetch all volunteer successful", 200));
        } catch (Exception ex) {
            return badRequest().body(response(new HashMap<>(), ex.getMessage(), 500));
        }
    }

    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> findVolunteerById(@PathVariable("id") @NonNull String id) {
        try {
            return ok(response(volunteerService.findVolunteerById(id).orElseGet(Volunteer::new),
                    "find volunteer successful", 200));
        } catch (Exception ex) {
            return badRequest().body(response(new HashMap<>(), ex.getMessage(), 500));
        }
    }

    @PutMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateVolunteer(@RequestBody @NonNull Volunteer volunteer) {
        try {
            return ok(response(volunteerService.saveAndUpdate(volunteer), "update volunteer successful", 200));
        } catch (Exception ex) {
            return badRequest().body(response(new HashMap<>(), ex.getMessage(), 500));
        }
    }

    @DeleteMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteVolunteer(@PathVariable("id") @NonNull String id) {
        try {
            volunteerService.deleteVolunteerById(id);
            return ok(response(new HashMap<>(), "delete volunteer successful", 200));
        } catch (Exception ex) {
            return badRequest().body(response(new HashMap<>(), ex.getMessage(), 500));
        }
    }
}
