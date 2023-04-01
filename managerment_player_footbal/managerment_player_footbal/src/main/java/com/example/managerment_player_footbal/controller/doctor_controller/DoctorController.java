package com.example.managerment_player_footbal.controller.doctor_controller;

import com.example.managerment_player_footbal.model.account.Account;
import com.example.managerment_player_footbal.model.medical.Doctor.Doctor;
import com.example.managerment_player_footbal.repository.medical_repository.Doctor.DoctorRepository;
import com.example.managerment_player_footbal.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private IAccountService iAccountService;
    private final DoctorRepository doctorRepository;

    DoctorController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @GetMapping("/doctors")
    public String findDoctors(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Account account = iAccountService.findByAccountName(username);
        Doctor doctor = doctorRepository.findDoctorByUser(account);
        model.addAttribute("doctorName", doctor.getName());
        List<Doctor> doctors = doctorRepository.findAll();
        model.addAttribute("doctors", doctors);
        return "doctor/DoctorList";
    }


    @GetMapping("/{id}")
    public String getDoc(@PathVariable int id, Model model) {
        Doctor doctor = doctorRepository.getById(id);
        model.addAttribute("doctor", doctor);
        return "doctor/DoctorProfile";
    }

    @GetMapping()
    public String getHomePage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Account account = iAccountService.findByAccountName(username);
        Doctor doctor = doctorRepository.findDoctorByUser(account);
        model.addAttribute("doctorName", doctor.getName());
        return "doctor/DoctorHomepage";
    }
}