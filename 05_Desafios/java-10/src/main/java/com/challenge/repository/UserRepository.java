package com.challenge.repository;

import com.challenge.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    //JPQL
    List<User> findByCandidates_Id_Acceleration_Name(String name);
    List<User> findByCandidates_Id_Company_Id(Long companyId);

    @Query("SELECT user FROM User user JOIN user.candidates candi JOIN candi.id.acceleration accel WHERE accel.name = ?1")
    List<User> findAllByAccelerationName(String name);

    @Query("SELECT user FROM User user JOIN user.candidates candi WHERE candi.id.company.id = ?1")
    List<User> findAllByCompanyId(Long id);

}
