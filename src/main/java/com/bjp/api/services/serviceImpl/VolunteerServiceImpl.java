package com.bjp.api.services.serviceImpl;

import com.bjp.api.dto.PaginationRequest;
import com.bjp.api.models.Volunteer;
import com.bjp.api.repository.VolunteerRepository;
import com.bjp.api.services.service.VolunteerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

import static com.bjp.api.utils.commonUtils.Payload.byteToBase64;
import static org.springframework.data.domain.PageRequest.of;

@Service
@Slf4j
@AllArgsConstructor
public class VolunteerServiceImpl implements VolunteerService {

    private final VolunteerRepository volunteerRepository;

    @Override
    public Volunteer saveAndUpdate(@NonNull Volunteer volunteer) {
        try {
            return volunteerRepository.save(volunteer);
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public void updateVolunteerProfile(@NonNull String volunteerId, @NonNull MultipartFile file) {
        try {
            final Volunteer findVolunteer = this.findVolunteerById(volunteerId).orElseGet(Volunteer::new);
            if (findVolunteer.getVolunteerId() == null || findVolunteer.getVolunteerId().isEmpty()) {
                log.error("Volunteer not found");
                throw new NullPointerException("Volunteer not found");
            }
            findVolunteer.setVolunteerImage(file.getBytes());
            this.volunteerRepository.save(findVolunteer);
        } catch (Exception ex) {
            ex.getStackTrace();
            log.error(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public Optional<Volunteer> findVolunteerById(@NonNull String volunteerId) {
        try {
            return volunteerRepository.findById(volunteerId);
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public List<Volunteer> findAllVolunteer() {
        try {
            return volunteerRepository.findAll();
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public Page<Volunteer> findAllVolunteer(@NonNull PaginationRequest request) {
        try {
            return volunteerRepository.findAll(of(request.getPageSize(), request.getDataSize(), request.getSort()));
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
    }


    @Override
    public void deleteVolunteerById(@NonNull String volunteerId) {
        try {
            volunteerRepository.deleteById(volunteerId);
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }

    }
}
