package com.bjp.api.services.serviceImpl;

import com.bjp.api.dto.PaginationRequest;
import com.bjp.api.models.Area;
import com.bjp.api.repository.AreaRepository;
import com.bjp.api.services.service.AreaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.bjp.api.utils.commonUtils.UniqueIdGenerator.getPrimaryId;
import static java.time.ZoneOffset.UTC;
import static java.time.ZonedDateTime.now;
import static org.springframework.data.domain.PageRequest.of;
import static org.springframework.data.domain.Sort.Direction.ASC;

@Service
@AllArgsConstructor
@Slf4j
public class AreaServiceImpl implements AreaService {

    private final AreaRepository areaRepository;

    @Override
    public Area areaSaveAndUpdate(@NonNull Area area) {
        try {
            return areaRepository.save(area);
        } catch (Exception ex) {
            ex.getStackTrace();
            log.error("Area name already exist");
            throw new RuntimeException("Area name already exist");
        }
    }

    @Override
    public Optional<Area> findAreaById(@NonNull String areaId) {
        try {
            return areaRepository.findById(areaId);
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public Optional<Area> findAreaByName(@NonNull String areaName) {
        try {
            return areaRepository.findByAreaName(areaName);
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public List<Area> findAllArea() {
        try {
            return areaRepository.findAll();
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
    }
    @Override
    public void deleteArea(@NonNull String areaId) {
        try {
            areaRepository.deleteById(areaId);
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public Page<Area> findAllArea(@NonNull PaginationRequest request) {
        if (request.getSort() == null) {
            request.setSort(ASC);
        }
        return areaRepository.findAll(of(request.getPageSize(), request.getDataSize(), request.getSort()));
    }
}
