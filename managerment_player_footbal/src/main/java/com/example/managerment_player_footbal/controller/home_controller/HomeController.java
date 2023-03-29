package com.example.managerment_player_footbal.controller.home_controller;

import com.example.managerment_player_footbal.model.Coach;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/mapping")
    public String url(Authentication authen) {
        UserDetails ud = (UserDetails) authen.getPrincipal();
        boolean isAdmin = false;
        boolean isUser = false;
        boolean isCoach = false;
        boolean isDoctor = false;
        for (GrantedAuthority auth : ud.getAuthorities()) {
            if ("ROLE_ADMIN".equalsIgnoreCase((auth.getAuthority()))) {
                isAdmin = true;
            } else if ("ROLE_USER".equalsIgnoreCase((auth.getAuthority()))) {
                isUser = true;
            } else if ("ROLE_COACH".equalsIgnoreCase((auth.getAuthority()))) {
                isCoach = true;
            } else if ("ROLE_DOCTOR".equalsIgnoreCase((auth.getAuthority()))) {
                isDoctor = true;
            }
        }

        if (isAdmin) {
            return "redirect:/admin";
        } else if (isUser) {
            return "redirect:/user";
        } else if (isCoach) {
            return "redirect:/coach";
        } else if (isDoctor) {
            return "redirect:/doctor";
        }
        return "redirect:/";
    }


    @GetMapping("coach")
    public String coach_index() {
        return "coach/indexCoach";
    }

    @GetMapping("doctor")
    public String doctor_index() {
        return "doctor";
    }

    @GetMapping("/admin")
    public String admin_index(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        model.addAttribute("userName", username);
        return "admin/index";
    }


    @GetMapping("/deny")
    public String deny() {
        return "deny";
    }

    @GetMapping("login")
    public String showLogin() {
        return "login";
    }
}
