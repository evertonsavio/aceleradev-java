package com.challenge.repository;

import com.challenge.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {

    //JPQL
    Optional<Submission> findFirstScoreById_Challenge_IdOrderByScoreDesc(Long challengeId);

    @Query("SELECT MAX(submi.score) FROM Submission submi WHERE submi.id.challenge.id = ?1")
    Optional<Float> findHigherScoreByChallengeId(Long challengeId);
    @Query("SELECT submi FROM Submission submi JOIN submi.id.challenge chall JOIN chall.accelerations accel WHERE accel.id = ?1 AND accel.id = ?2")
    List<Submission> findAllByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId);

}
