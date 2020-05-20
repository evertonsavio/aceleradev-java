package com.challenge.repository;

import com.challenge.entity.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChallengeRepository extends JpaRepository<Challenge, Long> {

    //JPQL
    List<Challenge> findByAccelerations_Candidates_Id_Acceleration_IdAndAccelerations_Candidates_Id_User_Id(Long accelerationId,Long userId);

    @Query("SELECT challe FROM Challenge challe JOIN challe.accelerations accel JOIN accel.candidates candi WHERE accel.id = ?1 AND candi.id.user.id = ?2")
    List<Challenge> findAllByAccelerationIdAndUserId(Long accelerationId, Long userId);

}
