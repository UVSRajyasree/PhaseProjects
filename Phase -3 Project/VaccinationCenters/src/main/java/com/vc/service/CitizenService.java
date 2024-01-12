package com.vc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vc.entity.Citizen;
import com.vc.entity.VaccinationCenter;
import com.vc.repository.CitizenRepository;

import java.util.List;

@Service
public class CitizenService {

    @Autowired
    private CitizenRepository citizenRepository;

    public List<Citizen> getAllCitizens() {
        return citizenRepository.findAll();
    }

    public Citizen getCitizenById(Long id) {
        return citizenRepository.findById(id).orElse(null);
    }

    public void addCitizen(Citizen citizen) {
        // Check if the citizen is already mapped to a vaccination center
        if (citizen.getVaccinationCenter() != null) {
            throw new RuntimeException("Citizen is already mapped to a vaccination center.");
        }

        citizenRepository.save(citizen);
        
    }

    public void updateCitizen(Citizen citizen) {
        // Check if the citizen is already mapped to a vaccination center
        if (citizen.getVaccinationCenter() != null) {
            throw new RuntimeException("Citizen is already mapped to a vaccination center.");
        }

        citizenRepository.save(citizen);
    }

    public void deleteCitizen(Long id) {
        citizenRepository.deleteById(id);
    }

    public void mapCitizenToVaccinationCenter(Long citizenId, VaccinationCenter vaccinationCenter) {
        Citizen citizen = citizenRepository.findById(citizenId).orElse(null);

        // Check if the citizen exists
        if (citizen == null) {
            throw new RuntimeException("Citizen not found.");
        }

        // Check if the citizen is already mapped to a vaccination center
        if (citizen.getVaccinationCenter() != null) {
            throw new RuntimeException("Citizen is already mapped to a vaccination center.");
        }

        citizen.setVaccinationCenter(vaccinationCenter);
        citizenRepository.save(citizen);
    }
    
    public List<Citizen> getCitizensByVaccinationCenterId(Long vaccinationCenterId) {
        return citizenRepository.findByVaccinationCenterId(vaccinationCenterId);
    }
    
    public List<Citizen> getCitizensByVaccinationCenterAndCity(Long vaccinationCenterId, String city) {
        return citizenRepository.findByVaccinationCenterAndCity(vaccinationCenterId, city);
    }
}
