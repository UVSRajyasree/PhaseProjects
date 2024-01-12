package com.vc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vc.service.AdminService;

@Controller
public class LoginController {
    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        if (adminService.isValidAdmin(username, password)) {
            // Redirect to admin portal
            return "redirect:/admin";
        } else {
            model.addAttribute("error", "Invalid credentials");
            return "login";
        }
    }
}
