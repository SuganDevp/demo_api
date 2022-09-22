package com.bjp.api.controllers;

import com.bjp.api.models.Wing;
import com.bjp.api.services.service.WingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

import static com.bjp.api.utils.commonUtils.Payload.response;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/wing")
public class WingController {

    private final WingService wingService;

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createWing(@RequestBody @NonNull Wing wing) {
        try {
            return ok(response(wingService.saveAndUpdate(wing), "create wing successful", 200));
        } catch (Exception ex) {
            return badRequest().body(response(new HashMap<>(), ex.getMessage(), 500));
        }
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> findAllWing() {
        try {
            return ok(response(wingService.findAllWing(), "fetch all wing successful", 200));
        } catch (Exception ex) {
            return badRequest().body(response(new HashMap<>(), ex.getMessage(), 500));
        }
    }

    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> findWing(@PathVariable("id") @NonNull String id) {
        try {
            return ok(response(wingService.findWingById(id).orElseGet(Wing::new), "Find wing successful", 200));
        } catch (Exception ex) {
            return badRequest().body(response(new HashMap<>(), ex.getMessage(), 500));
        }
    }

    @PutMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateWing(@RequestBody @NonNull Wing wing) {
        try {
            return ok(response(wingService.saveAndUpdate(wing), "update wing successful", 200));
        } catch (Exception ex) {
            return badRequest().body(response(new HashMap<>(), ex.getMessage(), 500));
        }
    }

    @DeleteMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteWing(@PathVariable @NonNull String id) {
        try {
            wingService.deleteWingById(id);
            return ok(response(new HashMap<>(), "delete wing successful", 200));
        } catch (Exception ex) {
            return badRequest().body(response(new HashMap<>(), ex.getMessage(), 500));
        }
    }
}
