package com.vc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.vc.entity.VaccinationCenter;
import com.vc.service.VaccinationCenterService;

import com.vc.entity.Citizen;
import com.vc.service.CitizenService;

import java.util.List;

@Controller
public class VaccinationCenterController {

    @Autowired
    private VaccinationCenterService vaccinationCenterService;
    
    @Autowired
    private CitizenService citizenService;

    @RequestMapping(value = "/vaccinationCenters", method = RequestMethod.GET)
    public String viewVaccinationCenters(Model model) {
        List<VaccinationCenter> vaccinationCenters = vaccinationCenterService.findAllVaccinationCenters();
        model.addAttribute("vaccinationCenters", vaccinationCenters);
        return "viewVaccinationCenters";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAddForm(Model model) {
        model.addAttribute("vaccinationCenter", new VaccinationCenter());
        return "addVaccinationCenter";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addVaccinationCenter(@ModelAttribute VaccinationCenter vaccinationCenter) {
        vaccinationCenterService.addVaccinationCenter(vaccinationCenter);
        return "/add";
    }

    @RequestMapping(value = "/vaccinationCenter/edit/{id}", method = RequestMethod.GET)
    public String showEditForm(@PathVariable Long id, Model model) {
        VaccinationCenter vaccinationCenter = vaccinationCenterService.getVaccinationCenterById(id);
        model.addAttribute("vaccinationCenter", vaccinationCenter);
        return "editVaccinationCenter";
    }

    @RequestMapping(value = "/vaccinationCenters/edit/", method = RequestMethod.POST)
    public String editVaccinationCenter(@ModelAttribute VaccinationCenter vaccinationCenter) {
        vaccinationCenterService.editVaccinationCenter(vaccinationCenter);
        return "/vaccinationCenter/edit/";
    }

    @RequestMapping(value = "vaccinationCenters/delete/{id}", method = RequestMethod.GET)
    public String deleteVaccinationCenter(@PathVariable Long id) {
        vaccinationCenterService.deleteVaccinationCenter(id);
        return "/delete";
    }
    
    @RequestMapping(value = "vaccinationCenters/{id}", method = RequestMethod.GET)
    public String getVaccinationCenterById(@PathVariable Long id, Model model) {
        VaccinationCenter vaccinationCenter = vaccinationCenterService.getVaccinationCenterById(id);

        if (vaccinationCenter == null) {
            return "error";
        }

        model.addAttribute("vaccinationCenter", vaccinationCenter);
        return "viewVaccinationCenterById"; 
    }
    
    @RequestMapping(value = "vaccinationCenters1/{id}", method = RequestMethod.GET)
    public String getVaccinationCenterDetails(@PathVariable Long id, Model model) {
        VaccinationCenter vaccinationCenter = vaccinationCenterService.getVaccinationCenterById(id);
        List<Citizen> citizensInVaccinationCenter = citizenService.getCitizensByVaccinationCenterId(id);

        model.addAttribute("vaccinationCenter", vaccinationCenter);
        model.addAttribute("citizensInVaccinationCenter", citizensInVaccinationCenter);

        return "vaccinationCenterDetails";
    }
}
