package com.example.managerment_player_footbal.controller.doctor_controller.PlayerHealthReport;

import com.example.managerment_player_footbal.model.Classes;
import com.example.managerment_player_footbal.model.Player;
import com.example.managerment_player_footbal.model.account.Account;
import com.example.managerment_player_footbal.model.medical.Doctor.Doctor;
import com.example.managerment_player_footbal.model.medical.PlayerHealthReport.PlayerHealthReport;
import com.example.managerment_player_footbal.repository.classes_repository.IClassesRepository;
import com.example.managerment_player_footbal.repository.classes_repository.IPlayerRepository;
import com.example.managerment_player_footbal.repository.medical_repository.Doctor.DoctorRepository;
import com.example.managerment_player_footbal.repository.medical_repository.PlayerHealthRepository.PlayerHealthReportRepository;
import com.example.managerment_player_footbal.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/doctor/healthreport")
public class PlayerHealthReportController {
    private final PlayerHealthReportRepository playerHealthReportRepository;
    private final IPlayerRepository playerRepository;
    private final DoctorRepository doctorRepository;
    private final IClassesRepository classRepository;

    @Autowired
    private IAccountService iAccountService;

    PlayerHealthReportController(PlayerHealthReportRepository playerHealthReportRepository,
                                 IPlayerRepository playerRepository, DoctorRepository doctorRepository, IClassesRepository classRepository) {
        this.playerHealthReportRepository = playerHealthReportRepository;
        this.playerRepository = playerRepository;
        this.doctorRepository = doctorRepository;
        this.classRepository = classRepository;
    }

    @GetMapping("/{id}")
    public String reportPlayerHealth(@PathVariable int id, Model model) {

        BindingResult result = (BindingResult) model.getAttribute("errors");
        if (result != null) {
            List<String> errorStrings = new ArrayList<String>();
            for (FieldError error : result.getFieldErrors()) {
                errorStrings.add(error.getDefaultMessage());
            }
            model.addAttribute("errorStrings", errorStrings);
        }

        Player player = playerRepository.getById(id);
        Doctor doctor = doctorRepository.getById(1);

        PlayerHealthReport report = new PlayerHealthReport();
        report.setPlayer(player);
        report.setDoctor(doctor);

        model.addAttribute("report", report);

        return "doctor/PlayerHealthReport/PlayerHealthReport";
    }

    @PostMapping("/report")
    public String playerHealthReport(@Valid @ModelAttribute PlayerHealthReport report, Errors errors,
                                     RedirectAttributes redirectAttributes) {

        if (errors.hasErrors()) {
            redirectAttributes.addFlashAttribute("errors", errors);
            redirectAttributes.addFlashAttribute("report", report);
            return "redirect:/doctor/healthreport/" + report.getPlayer().getPlayerId();
        }

        playerHealthReportRepository.save(report);
        String redirect = "redirect:/doctor/healthreport/history/" + Long.toString(report.getPlayer().getPlayerId());
        return redirect;
    }

    @GetMapping("/history/{id}")
    public String playerHealthReportHistory(@PathVariable int id, Model model) {
        Player player = playerRepository.getById(id);
        List<PlayerHealthReport> reports = playerHealthReportRepository.findAllByPlayerId(id);
        model.addAttribute("reports", reports);
        model.addAttribute("player", player);
        return "doctor/PlayerHealthReport/HealthReportHistory";
    }

    @GetMapping("/class/{id}")
    public String getStudentList(@PathVariable int id, Model model) {
        List<Player> players = playerRepository.getByClassId(id);
        model.addAttribute("players", players);

        return "doctor/PlayerHealthReport/StudentList";
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
        return "doctor/PlayerHealthReport/HealthReportClassList";
    }
}