package com.vc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vc.entity.VaccinationCenter;
import com.vc.repository.VaccinationCenterRepository;

import java.util.List;

@Service
public class VaccinationCenterService {

    @Autowired
    private VaccinationCenterRepository vaccinationCenterRepository;

    public List<VaccinationCenter> findAllVaccinationCenters() {
        return vaccinationCenterRepository.findAll();
    }

    public VaccinationCenter getVaccinationCenterById(Long id) {
        return vaccinationCenterRepository.findById(id).orElse(null);
    }

    public void addVaccinationCenter(VaccinationCenter vaccinationCenter) {
        vaccinationCenterRepository.save(vaccinationCenter);
    }

    public void editVaccinationCenter(VaccinationCenter vaccinationCenter) {
        vaccinationCenterRepository.save(vaccinationCenter);
    }

    public void deleteVaccinationCenter(Long id) {
        vaccinationCenterRepository.deleteById(id);
    }
}
