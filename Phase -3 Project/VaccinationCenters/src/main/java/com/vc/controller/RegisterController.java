package com.vc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vc.entity.Admin;
import com.vc.service.AdminService;

@Controller
public class RegisterController {
    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage(Model model) {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerAdmin(@RequestParam String username, @RequestParam String password, Model model) {
        if (adminService.isAdminExists(username)) {
            model.addAttribute("error", "Username is already taken");
            return "register";
        }

        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setPassword(password);
        adminService.registerAdmin(admin);

        // Redirect to login after registration
        return "redirect:/login";
    }
}