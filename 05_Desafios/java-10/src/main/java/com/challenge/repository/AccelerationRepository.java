package com.challenge.repository;

import com.challenge.entity.Acceleration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AccelerationRepository extends JpaRepository<Acceleration, Long> {

    Optional<Acceleration> findByName(Long name);

    //JPQL
    List<Acceleration> findByCandidates_ID_Company_Id(Long companyId);

    @Query("SELECT a FROM Acceleration a JOIN a.candidates cd WHERE cd.id.company.id = ?1")
    List<Acceleration> findByCompanyId(Long companyId);

}
