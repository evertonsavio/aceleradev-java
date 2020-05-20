package com.challenge.service.interfaces;

import com.challenge.entity.Acceleration;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AccelerationServiceInterface extends ServiceInterface<Acceleration> {

    Optional<Acceleration> findByName(Long name);

    //JPQL
    List<Acceleration> findByCandidates_Id_Company_Id(Long companyId);

    @Query("SELECT Accel FROM Acceleration Accel JOIN Accel.candidates candi WHERE candi.id.company.id = ?1")
    List<Acceleration> findByCompanyId(Long companyId);

}
