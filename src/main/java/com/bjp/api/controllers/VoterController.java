package com.bjp.api.controllers;

import com.bjp.api.models.Voter;
import com.bjp.api.services.service.VoterService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
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
@RequestMapping(path = "/api/voter")
public class VoterController {

    private final VoterService voterService;

    @PostMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createVoter(@RequestBody Voter voter) {
        try {
            return ok(response(voterService.voterSaveAndUpdate(voter), "Create voter successful", 200));
        } catch (Exception ex) {
            return badRequest().body(response(new HashMap<>(), ex.getMessage(), 500));
        }
    }

    @PutMapping(path = "/upload/{voterId}", consumes = MULTIPART_FORM_DATA_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> upload(@PathVariable("voterId") @NonNull String voterId,
            @RequestParam("image") @NonNull MultipartFile file) {
        try {
            voterService.updateVoterProfile(voterId, file);
            return ok(response(new HashMap<>(), "Profile updated", 200));
        } catch (Exception ex) {
            return badRequest().body(response(new HashMap<>(), ex.getMessage(), 500));
        }
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> findAllVoter() {
        try {
            return ok(response(voterService.findAllVoter(), "fetch all voter successful", 200));
        } catch (Exception ex) {
            return badRequest().body(response(new HashMap<>(), ex.getMessage(), 500));
        }
    }

    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createVoter(@PathVariable("id") @NonNull String id) {
        try {
            return ok(response(voterService.findVoterById(id).orElseGet(Voter::new), "find voter successful", 200));
        } catch (Exception ex) {
            return badRequest().body(response(new HashMap<>(), ex.getMessage(), 500));
        }
    }

    @PutMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateVoter(@RequestBody @NonNull Voter voter) {
        try {
            return ok(response(voterService.voterSaveAndUpdate(voter), "update voter successful", 200));
        } catch (Exception ex) {
            return badRequest().body(response(new HashMap<>(), ex.getMessage(), 500));
        }
    }

    @DeleteMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteVoter(@PathVariable @NonNull String id) {
        try {
            voterService.deleteVoterById(id);
            return ok(response(new HashMap<>(), "delete voter successful", 200));
        } catch (Exception ex) {
            return badRequest().body(response(new HashMap<>(), ex.getMessage(), 500));
        }
    }
}
