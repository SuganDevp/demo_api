package com.bjp.api.services.service;

import com.bjp.api.dto.PaginationRequest;
import com.bjp.api.models.Area;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

@Configuration
public interface AreaService {

    Area areaSaveAndUpdate(Area area);

    Optional<Area> findAreaById(String areaId);

    Optional<Area> findAreaByName(String areaName);

    List<Area> findAllArea();

    void deleteArea(String areaId);

    Page<Area> findAllArea(PaginationRequest request);

}
