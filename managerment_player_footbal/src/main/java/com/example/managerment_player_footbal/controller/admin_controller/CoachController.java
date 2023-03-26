package com.example.managerment_player_footbal.controller.admin_controller;

import com.example.managerment_player_footbal.model.Coach;
import com.example.managerment_player_footbal.service.CooachService.IAccountService;
import com.example.managerment_player_footbal.service.CooachService.ICoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class CoachController {
    @Autowired
    ICoachService iCoachService;

    @Autowired
    IAccountService iAccountService;


    @GetMapping("/listCoach")
    public String showListCoach(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        model.addAttribute("userName", username);
        List<Coach> coachList = iCoachService.findAll();
        model.addAttribute("coachList", coachList);
        return "admin/listCoach";
    }

    @GetMapping("/createCoach")
    public String showFormCreate(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        model.addAttribute("userName", username);
        model.addAttribute("coach", new Coach());
        model.addAttribute("accountList", iAccountService.findAll());
        return "admin/createCoach";
    }


    @PostMapping("/save")
    public String doCreate(@ModelAttribute("coach") Coach coach, RedirectAttributes redirectAttributes) {
        iCoachService.createOrUpdateCoach(coach);
        redirectAttributes.addFlashAttribute("message", "Thêm Mới Thành Công");
        return "redirect:/admin/listCoach";
    }

    @GetMapping("/updateCoach/{id}")
    public String showFormUpdate(@PathVariable int id, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        model.addAttribute("userName", username);
        model.addAttribute("coach", iCoachService.findById(id));
        model.addAttribute("accountList", iAccountService.findAll());
        return "admin/updateCoach";
    }

    @PostMapping("/update")
    public String doUpdate(@ModelAttribute("coach") Coach coach, RedirectAttributes redirectAttributes) {
        iCoachService.createOrUpdateCoach(coach);
        redirectAttributes.addFlashAttribute("messageUpdate", "Cập nhật thành công");
        return "redirect:/admin/listCoach";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("idCoach") int id) {
        iCoachService.deleteById(id);
        return "redirect:/admin/listCoach";
    }
}
