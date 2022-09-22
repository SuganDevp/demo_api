package com.bjp.api.services.service;

import com.bjp.api.dto.PaginationRequest;
import com.bjp.api.models.Voter;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.lang.NonNull;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Configuration
public interface VoterService {

    Voter voterSaveAndUpdate(Voter voter);

    Optional<Voter> findVoterById(String voterId);

    List<Voter> findAllVoter();

    Page<Voter> findAllVoter(PaginationRequest request);

    void deleteVoterById(String voterId);

    void updateVoterProfile(@NonNull String voterId, @NonNull MultipartFile file);

}
