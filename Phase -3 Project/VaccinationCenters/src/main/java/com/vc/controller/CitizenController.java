package com.vc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.vc.entity.Citizen;
import com.vc.entity.VaccinationCenter;
import com.vc.service.CitizenService;
import com.vc.service.VaccinationCenterService;

import java.util.List;

@Controller
public class CitizenController {

    @Autowired
    private CitizenService citizenService;

    @Autowired
    private VaccinationCenterService vaccinationCenterService;

    @RequestMapping(value ="/citizens", method = RequestMethod.GET)
    public String viewCitizens(Model model) {
        List<Citizen> citizens = citizenService.getAllCitizens();
        model.addAttribute("citizens", citizens);
        return "viewCitizens";
    }

    @RequestMapping(value = "/adding", method = RequestMethod.GET)
    public String showAddingForm(Model model) {
        model.addAttribute("citizen", new Citizen());
        List<VaccinationCenter> vaccinationCenters = vaccinationCenterService.findAllVaccinationCenters();
        model.addAttribute("vaccinationCenters", vaccinationCenters);
        return "addCitizen";
    }

    @RequestMapping(value = "/adding", method = RequestMethod.POST)
    public String addCitizen(@ModelAttribute Citizen citizen) {
        citizenService.addCitizen(citizen);
        return "redirect:/citizens";
    }

    @RequestMapping(value = "citizens/editing/{id}", method = RequestMethod.GET)
    public String showEditingForm(@PathVariable Long id, Model model) {
        Citizen citizen = citizenService.getCitizenById(id);
        model.addAttribute("citizen", citizen);
        List<VaccinationCenter> vaccinationCenters = vaccinationCenterService.findAllVaccinationCenters();
        model.addAttribute("vaccinationCenters", vaccinationCenters);
        return "editCitizen";
    }

    @RequestMapping(value = "citizens/editing", method = RequestMethod.POST)
    public String editCitizen(@ModelAttribute Citizen citizen) {
        citizenService.updateCitizen(citizen);
        return "redirect:/citizens";
    }

    @RequestMapping(value = "/deleting/{id}", method = RequestMethod.GET)
    public String deleteCitizen(@PathVariable Long id) {
        citizenService.deleteCitizen(id);
        return "redirect:/citizens";
    }

    @RequestMapping(value = "/map/{citizenId}", method = RequestMethod.POST)
    public String mapCitizenToVaccinationCenter(
            @PathVariable Long citizenId,
            @RequestParam Long vaccinationCenterId) {
        VaccinationCenter vaccinationCenter = vaccinationCenterService.getVaccinationCenterById(vaccinationCenterId);
        citizenService.mapCitizenToVaccinationCenter(citizenId, vaccinationCenter);
        return "redirect:/admin/citizens";
    }
    
    @RequestMapping(value = "citizens/{id}", method = RequestMethod.GET)
    public String getCitizenById(@PathVariable Long id, Model model) {
        Citizen citizen = citizenService.getCitizenById(id);

        if (citizen == null) {
            return "error";
        }

        model.addAttribute("citizen", citizen);
        return "viewCitizenById"; 
    }
    
    @RequestMapping(value = "/vaccinationCenterAndCity", method = RequestMethod.GET)
    public String getCitizensByVaccinationCenterAndCity(
            @RequestParam Long vaccinationCenterId,
            @RequestParam String city,
            Model model) {
        List<Citizen> citizens = citizenService.getCitizensByVaccinationCenterAndCity(vaccinationCenterId, city);
        model.addAttribute("citizens", citizens);
        return "viewCitizens"; 
    }
}
