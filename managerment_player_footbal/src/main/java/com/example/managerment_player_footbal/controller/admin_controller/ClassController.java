package com.example.managerment_player_footbal.controller.admin_controller;

import com.example.managerment_player_footbal.model.Classes;
import com.example.managerment_player_footbal.service.IClassesService;
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
public class ClassController {

    @Autowired
    private IClassesService iClassesService;

    @Autowired
    private ICoachService iCoachService;

    @GetMapping("/createClass")
    public String showFormCreateClass(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        model.addAttribute("userName", username);
        model.addAttribute("class", new Classes());
        model.addAttribute("listCoach", iCoachService.findAll());
        return "admin/createClass";
    }


    @GetMapping("/listClass")
    public String showListClass(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        List<Classes> classesList = iClassesService.findAll();
        model.addAttribute("userName", username);
        model.addAttribute("listClass", classesList);
        return "admin/listClass";
    }


    @PostMapping("/saveClass")
    public String doSaveClass(@Valid @ModelAttribute("class") Classes classes, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("listCoach", iCoachService.findAll());
            return "admin/createClass";
        }
        iClassesService.save(classes);
        redirectAttributes.addFlashAttribute("massage", "Thêm mới thành công");
        return "redirect:/admin/listClass";
    }

    @GetMapping("/updateClass/{id}")
    public String showFormUpdate(@PathVariable int id, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        model.addAttribute("userName", username);
        model.addAttribute("class", iClassesService.findAllByIdClass(id));
        model.addAttribute("listCoach", iCoachService.findAll());
        return "admin/updateClass";
    }


    @PostMapping("/updateClass")
    public String doUpdate(@ModelAttribute("class") Classes classes, RedirectAttributes redirectAttributes) {
        iClassesService.save(classes);
        redirectAttributes.addFlashAttribute("messageUpdate", "Cập nhật thành công");
        return "redirect:/admin/listClass";
    }

    @PostMapping("/deleteClass")
    public String delete(@RequestParam("idClass") int id) {
        iClassesService.deleteById(id);
        return "redirect:/admin/listClass";
    }

}
