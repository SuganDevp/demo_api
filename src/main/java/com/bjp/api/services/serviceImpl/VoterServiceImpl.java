package com.bjp.api.services.serviceImpl;

import com.bjp.api.dto.PaginationRequest;
import com.bjp.api.models.Voter;
import com.bjp.api.repository.VoterRepository;
import com.bjp.api.services.service.VoterService;
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
@AllArgsConstructor
@Slf4j
public class VoterServiceImpl implements VoterService {
    private final VoterRepository voterRepository;

    @Override
    public Voter voterSaveAndUpdate(@NonNull Voter voter) {
        try {
            return voterRepository.save(voter);
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public void updateVoterProfile(@NonNull String voterId, @NonNull MultipartFile file) {
        try {
            final Voter voter = voterRepository.findById(voterId).orElseGet(Voter::new);
            if (voter.getVoterId() == null || voter.getVoterId().isEmpty()) {
                log.error("Voter not found");
                throw new NullPointerException("Voter not found");
            }
            voter.setVoterImage(file.getBytes());
            final Voter updateVoter = this.voterSaveAndUpdate(voter);
            if (updateVoter.getVoterId() == null || updateVoter.getVoterId().isEmpty()) {
                log.error("Voter updater failed");
                throw new NullPointerException("Voter updater failed");
            }
        } catch (Exception ex) {
            ex.getStackTrace();
            log.error(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public Optional<Voter> findVoterById(@NonNull String voterId) {
        try {
            return voterRepository.findById(voterId);
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public List<Voter> findAllVoter() {
        try {
            return voterRepository.findAll();
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public Page<Voter> findAllVoter(@NonNull PaginationRequest request) {
        try {
            return voterRepository.findAll(of(request.getPageSize(), request.getDataSize(), request.getSort()));
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
    }


    @Override
    public void deleteVoterById(String voterId) {
        try {
            voterRepository.deleteById(voterId);
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
    }
}
