package com.example.managerment_player_footbal.controller.admin_controller;

import com.example.managerment_player_footbal.model.Coach;
import com.example.managerment_player_footbal.service.IAccountRoleService;
import com.example.managerment_player_footbal.service.IAccountService;
import com.example.managerment_player_footbal.service.ICoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class CoachController {

    @Autowired
    IAccountRoleService iAccountRoleService;
    @Autowired
    ICoachService iCoachService;

    @Autowired
    IAccountService iAccountService;


    public CoachController(IAccountRoleService iAccountRoleService, ICoachService iCoachService, IAccountService iAccountService) {
        this.iAccountRoleService = iAccountRoleService;
        this.iCoachService = iCoachService;
        this.iAccountService = iAccountService;
    }

    @GetMapping("/listCoach")
    public String showListCoach(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        model.addAttribute("userName", username);
        List<Coach> coachList = iCoachService.findAll();
        model.addAttribute("coachList", coachList);
        return "admin/listCoach";
    }


    @GetMapping("/updateCoach/{id}")
    public String showFormUpdate( @PathVariable int id, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Coach coach= iCoachService.findById(id);
        model.addAttribute("userName", username);
        model.addAttribute("coach", coach);
        model.addAttribute("accountList", iAccountService.findAll());
        return "admin/updateCoach";
    }

    @PostMapping("/update")
    public String doUpdate(@Valid @ModelAttribute("coach") Coach coach, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()){
            return "admin/updateCoach";
        }
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
