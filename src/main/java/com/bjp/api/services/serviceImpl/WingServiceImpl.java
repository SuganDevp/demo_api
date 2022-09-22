package com.bjp.api.services.serviceImpl;

import com.bjp.api.dto.PaginationRequest;
import com.bjp.api.models.Wing;
import com.bjp.api.repository.WingRepository;
import com.bjp.api.services.service.WingService;
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
public class WingServiceImpl implements WingService {
    private final WingRepository wingRepository;

    @Override
    public Wing saveAndUpdate(@NonNull Wing wing) {
        try {
            return wingRepository.save(wing);
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public Optional<Wing> findWingById(@NonNull String wingId) {
        try {
            return wingRepository.findById(wingId);
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public List<Wing> findAllWing() {
        try {
            return wingRepository.findAll();
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public Page<Wing> findAllWing(@NonNull PaginationRequest request) {
        try {
            return wingRepository.findAll(of(request.getPageSize(), request.getDataSize(), request.getSort()));
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
    }
    @Override
    public void deleteWingById(@NonNull String wingId) {
        try {
            wingRepository.deleteById(wingId);
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
    }
}
