package com.vc.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vc.entity.Citizen;

public interface CitizenRepository extends JpaRepository<Citizen, Long> {
    
	List<Citizen> findByVaccinationCenterId(Long vaccinationCenterId);
	
	@Query("SELECT c FROM Citizen c JOIN FETCH c.vaccinationCenter vc WHERE vc.id = :vaccinationCenterId AND c.city = :city")
    List<Citizen> findByVaccinationCenterAndCity(@Param("vaccinationCenterId") Long vaccinationCenterId, @Param("city") String city);
}
