package com.bjp.api.services.service;

import com.bjp.api.dto.PaginationRequest;
import com.bjp.api.models.Volunteer;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Configuration
public interface VolunteerService {

    Volunteer saveAndUpdate(Volunteer volunteer);

    Optional<Volunteer> findVolunteerById(String volunteerId);

    List<Volunteer> findAllVolunteer();

    Page<Volunteer> findAllVolunteer(PaginationRequest request);

    void deleteVolunteerById(String volunteerId);

    void updateVolunteerProfile(String volunteerId,MultipartFile file);
}
