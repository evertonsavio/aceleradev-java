package com.challenge.repository;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CandidateRepository  extends JpaRepository<Candidate, CandidateId> {

    //JPQL
    List<Candidate> findById_Company_Id(Long companyId);
    List<Candidate> findById_Acceleration_Id(Long accelerationId);

    @Query("FROM Candidate candi WHERE candi.id.user.id = ?1 AND candi.id.company.id = ?2 AND candi.id.acceleration.id = ?3")
    Optional<Candidate> findById(Long userId, Long companyId, Long accelerationId);

    @Query("SELECT candi FROM Candidate candi WHERE candi.id.company.id = ?1")
    List<Candidate> findAllByCompanyId(Long companyId);

    @Query("SELECT candi FROM Candidate candi WHERE candi.id.acceleration.id = ?1")
    List<Candidate> findAllByAccelerationId(Long accelerationId);


}
