package com.bjp.api.controllers;

import com.bjp.api.models.Area;
import com.bjp.api.services.service.AreaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

import static com.bjp.api.utils.commonUtils.Payload.response;
import static java.lang.String.format;
import static java.net.URI.create;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.*;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
@RequestMapping("/api/area")
public class AreaController {
    private final AreaService areaService;

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createArea(@RequestBody @NonNull Area area, @NonNull HttpServletRequest request) {
        try {
            return ok(response(areaService.areaSaveAndUpdate(area), "Create area successful", 200));
        } catch (Exception ex) {
            return badRequest().body(response(new HashMap<>(), ex.getMessage(), 500));
        }
    }

    @GetMapping(path = "/{areaName}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> findAreaByName(@PathVariable("areaName") String areaName) {
        try {
            return ok(response(areaService.findAreaByName(areaName).orElseGet(Area::new), "Find area successful", 200));
        } catch (Exception ex) {
            return badRequest().body(response(new HashMap<>(), ex.getMessage(), 500));
        }
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> findAllArea() {
        try {
            return ok(response(areaService.findAllArea(), "find all area successful", 200));
        } catch (Exception ex) {
            return badRequest().body(response(new HashMap<>(), ex.getMessage(), 500));
        }
    }

    @PutMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateArea(@RequestBody @NonNull Area area) {
        try {
            return ok(response(areaService.areaSaveAndUpdate(area), "Update area successful", 200));
        } catch (Exception ex) {
            return badRequest().body(response(new HashMap<>(), ex.getMessage(), 500));
        }
    }

    @DeleteMapping(path = "/{areaId}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteAreaById(@PathVariable("areaId") @NonNull String areaId) {
        try {
            areaService.deleteArea(areaId);
            return ok(response(new HashMap<>(), format("Delete area: %s", areaId), 200));
        } catch (Exception ex) {
            return badRequest().body(response(new HashMap<>(), ex.getMessage(), 500));
        }
    }

}
