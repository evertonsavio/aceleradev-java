package com.challenge.repository;

import com.challenge.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    //JPQL
    List<Company> findDistinctByCandidates_Id_Acceleration_Id(Long accelerationId);
    List<Company> findDistinctByCandidates_Id_User_Id(Long accelerationId);

    @Query("SELECT distinct comp FROM Company comp JOIN comp.candidates candi WHERE candi.id.acceleration.id = ?1")
    List<Company> findAllByAccelerationId(Long accelerationId);
    @Query("SELECT comp FROM Company comp JOIN comp.candidates candi WHERE comp.id.user.id = ?1")
    List<Company> findAllByUserId(Long userId);

}
