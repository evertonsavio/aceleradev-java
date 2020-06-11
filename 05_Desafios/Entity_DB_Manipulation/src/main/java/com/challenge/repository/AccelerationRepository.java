package com.challenge.repository;

import com.challenge.entity.Acceleration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface AccelerationRepository extends JpaRepository<Acceleration, Long>{
    Acceleration findAccelerationByName(@Param("name") String name);

    @Query(value = "select acceleration.* from acceleration join candidate on acceleration.id = candidate.acceleration_id\n" +
            "join company on candidate.company_id = company.id\n" +
            "where company.id = :companyId", nativeQuery = true)
    List<Acceleration> findByCompanyId(@Param("companyId") Long companyId);
}
