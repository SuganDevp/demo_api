package com.bjp.api.services.serviceImpl;

import com.bjp.api.dto.PaginationRequest;
import com.bjp.api.models.Event;
import com.bjp.api.repository.EventRepository;
import com.bjp.api.services.service.EventService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.PageRequest.of;

@Service
@Slf4j
@AllArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    @Override
    public Event eventSaveAndUpdate(@NonNull Event event) {
        try {
            return eventRepository.save(event);
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public List<Event> findAllEvent() {
        try {
            return eventRepository.findAll();
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public Page<Event> findAllEvent(@NonNull PaginationRequest request) {
        try {
            return eventRepository.findAll(of(request.getPageSize(), request.getDataSize(), request.getSort()));
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public Optional<Event> findEventById(@NonNull String eventId) {
        try {
            return eventRepository.findById(eventId);
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public void deleteEventById(@NonNull String eventId) {
        try {
            eventRepository.deleteById(eventId);
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
    }
}
