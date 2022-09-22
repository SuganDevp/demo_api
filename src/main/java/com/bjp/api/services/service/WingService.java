package com.bjp.api.services.service;

import com.bjp.api.dto.PaginationRequest;
import com.bjp.api.models.Wing;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

@Configuration
public interface WingService {

    Wing saveAndUpdate(Wing wing);

    Optional<Wing> findWingById(String wingId);

    List<Wing> findAllWing();

    Page<Wing> findAllWing(PaginationRequest request);
    void deleteWingById(String wingId);
}
