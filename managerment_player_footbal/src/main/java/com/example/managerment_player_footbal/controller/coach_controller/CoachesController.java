package com.example.managerment_player_footbal.controller.coach_controller;


import com.example.managerment_player_footbal.service.CooachService.IAccountService;
import com.example.managerment_player_footbal.service.CooachService.IClassesService;
import com.example.managerment_player_footbal.service.CooachService.ICoachService;
import com.example.managerment_player_footbal.service.CooachService.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("coach")
public class CoachesController {
    @Autowired
    IAccountService iAccountService ;

    @Autowired
    IClassesService   iClassesService ;

    @Autowired
    private IPlayerService  iPlayerService ;

    @GetMapping("/listClass")
    @PreAuthorize("hasRole('ROLE_COACH')")
    public String  showListClass(Model model ){

        model.addAttribute("classList" , iClassesService.findAll());
        return "coach/listClass";
    }

    @GetMapping("/memberClass/{id}")
    public String showListMember(@PathVariable int id , Model model ) {
        model.addAttribute("playerList" , iPlayerService.findAllByIdClass((id)));
        return "coach/memberClass"; }

}
