package com.vc.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vc.entity.Admin;
import com.vc.repository.AdminRepository;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public void registerAdmin(Admin admin) {
        adminRepository.save(admin);
    }

    public boolean isAdminExists(String username) {
        return adminRepository.findByUsername(username).isPresent();
    }

    public boolean isValidAdmin(String username, String password) {
        Optional<Admin> adminOptional = adminRepository.findByUsername(username);
        return adminOptional.isPresent() && adminOptional.get().getPassword().equals(password);
    }
}