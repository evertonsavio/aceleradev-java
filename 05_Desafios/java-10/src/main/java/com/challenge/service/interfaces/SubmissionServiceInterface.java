package com.challenge.service.interfaces;

import com.challenge.entity.Submission;

import java.util.List;
import java.util.Optional;

public interface SubmissionServiceInterface extends ServiceInterface<Submission> {

    Optional<Float> findHigherScoreByChallengeId(Long challengeId);

    List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId);

}
