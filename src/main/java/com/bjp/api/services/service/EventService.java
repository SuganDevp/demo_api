package com.bjp.api.services.service;

import com.bjp.api.dto.PaginationRequest;
import com.bjp.api.models.Event;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

@Configuration
public interface EventService {

    Event eventSaveAndUpdate(Event event);

    List<Event> findAllEvent();

    Page<Event> findAllEvent(PaginationRequest request);

    Optional<Event> findEventById(String eventId);

    void deleteEventById(String eventId);
}
