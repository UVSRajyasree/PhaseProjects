package com.vc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vc.entity.VaccinationCenter;

public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenter, Long> {
    
}
