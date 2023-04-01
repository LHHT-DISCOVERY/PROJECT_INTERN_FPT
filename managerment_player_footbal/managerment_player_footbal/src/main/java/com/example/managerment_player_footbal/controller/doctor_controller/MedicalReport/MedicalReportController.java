package com.example.managerment_player_footbal.controller.doctor_controller.MedicalReport;

import com.example.managerment_player_footbal.model.Classes;
import com.example.managerment_player_footbal.model.Player;
import com.example.managerment_player_footbal.model.account.Account;
import com.example.managerment_player_footbal.model.medical.Doctor.Doctor;
import com.example.managerment_player_footbal.model.medical.MedicalReport.MedicalReport;
import com.example.managerment_player_footbal.repository.classes_repository.IClassesRepository;
import com.example.managerment_player_footbal.repository.classes_repository.IPlayerRepository;
import com.example.managerment_player_footbal.repository.medical_repository.Doctor.DoctorRepository;
import com.example.managerment_player_footbal.repository.medical_repository.MedicalReport.MedicalReportRepository;
import com.example.managerment_player_footbal.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/doctor/medicalreport")
public class MedicalReportController {
    @Autowired
    private MedicalReportRepository medicalReportRepository;

    @Autowired
    private IPlayerRepository playerRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private IAccountService iAccountService;

    @Autowired
    private IClassesRepository classRepository;

    @GetMapping("/{id}")
    public String reportPlayerHealth(@PathVariable int id, Model model) {
        Player player = playerRepository.getById(id);
        Doctor doctor = doctorRepository.getById(1);

        MedicalReport report = new MedicalReport();
        report.setPlayer(player);
        report.setDoctor(doctor);

        model.addAttribute("report", report);
        return "doctor/MedicalReport/SaveMedicalReport";
    }

    @PostMapping("/report")
    public String playerHealthReport(@ModelAttribute MedicalReport report) {
        medicalReportRepository.save(report);
        String redirect = "redirect:/doctor/medicalreport/history/" + Long.toString(report.getPlayer().getPlayerId());
        return redirect;
    }

    @GetMapping("/history/{id}")
    public String playerHealthReportHistory(@PathVariable int id, Model model) {
        Player player = playerRepository.getById(id);
        List<MedicalReport> reports = medicalReportRepository.findAllByPlayerId(id);
        model.addAttribute("reports", reports);
        model.addAttribute("player", player);
        return "doctor/MedicalReport/MedicalReportHistory";
    }

    @GetMapping("/classes")
    public String getClasses(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Account account = iAccountService.findByAccountName(username);
        Doctor doctor = doctorRepository.findDoctorByUser(account);
        model.addAttribute("doctorName", doctor.getName());
        List<Classes> classrooms = classRepository.findAll();
        model.addAttribute("classrooms", classrooms);
        return "doctor/MedicalReport/MedicalReportClasses";
    }

    @GetMapping("/class/{id}")
    public String getStudentList(@PathVariable int id, Model model) {
        List<Player> players = playerRepository.getByClassId(id);
        model.addAttribute("players", players);
        return "doctor/MedicalReport/MedicalReportPlayerList";
    }
}
