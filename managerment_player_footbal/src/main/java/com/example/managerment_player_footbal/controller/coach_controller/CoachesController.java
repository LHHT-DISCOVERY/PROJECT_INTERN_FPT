package com.example.managerment_player_footbal.controller.coach_controller;


import com.example.managerment_player_footbal.model.Player;
import com.example.managerment_player_footbal.model.PlayerRating;
import com.example.managerment_player_footbal.service.IAccountService;
import com.example.managerment_player_footbal.service.IClassesService;
import com.example.managerment_player_footbal.service.IPlayerRating;
import com.example.managerment_player_footbal.service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("coach")
public class CoachesController {
    @Autowired
    IAccountService iAccountService ;

    @Autowired
    IClassesService   iClassesService ;

    @Autowired
    private IPlayerService  iPlayerService ;

    @Autowired
    private IPlayerRating iPlayerRating;

    @GetMapping("/listClass")
    @PreAuthorize("hasRole('ROLE_COACH')")
    public String  showListClass(Model model ){
        model.addAttribute("classList" , iClassesService.findAll());
        return "coach/listClass";
    }

    @GetMapping("/historyRating/{id}")
    public String showListHistory(@PathVariable int id, Model model) {
        model.addAttribute("historyLists", iPlayerRating.getPlayerRating(id));
        return "coach/historyRating";
    };

    @GetMapping("/memberClass/{id}")
    public String showListMember(@PathVariable int id , Model model ) {
        model.addAttribute("playerList" , iPlayerService.findAllByIdClass((id)));
        return "coach/memberClass"; }

    @GetMapping("/ratingStudent/{id}")
    public String showRatingStudent(@PathVariable int id, Model model) {
        model.addAttribute("playerList", iPlayerService.getByClassId((id)));
        Player player = iPlayerService.getById(id);
        PlayerRating playerRating = iPlayerRating.getByCoachIdAndPlayerId(player.getPlayerId(), player.getClasses().getCoach().getCoachId());
        if (playerRating.getID_Rating() == 0) {
            playerRating.setPlayer(player);
            playerRating.setCoach(player.getClasses().getCoach());
        }
        model.addAttribute("rating", playerRating);
        return "coach/ratingStudent";
    }

    @PostMapping("/save")
    public String saveList( @ModelAttribute("playerList")PlayerRating player , RedirectAttributes redirectAttributes) {
        PlayerRating rating = iPlayerRating.save(player);
        Player players = iPlayerService.getById(rating.getPlayer().getPlayerId());
        redirectAttributes.addFlashAttribute("message", "Submit thành công");

        return "redirect:/coach/memberClass/"+players.getClasses().getClassId();
    };
}
