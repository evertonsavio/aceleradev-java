package com.challenge.service.impl;

import com.challenge.dto.SubmissionDTO;
import com.challenge.entity.Submission;
import com.challenge.mappers.SubmissionMapper;
import com.challenge.repository.SubmissionRepository;
import com.challenge.service.interfaces.SubmissionServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SubmissionService implements SubmissionServiceInterface {

    private SubmissionRepository repository;

    @Override
    public List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId) {
        return repository.findByChallengeIdAndAccelerationId(challengeId, accelerationId);
    }

    public List<Submission> findAll(){
        return repository.findAll();
    }

    public List<SubmissionDTO> mapearSubmissionDTO(List<Submission> submissions){
        return SubmissionMapper.INSTANCE.map(submissions);
    }

}
