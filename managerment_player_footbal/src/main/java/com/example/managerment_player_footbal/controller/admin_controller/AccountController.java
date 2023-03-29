package com.example.managerment_player_footbal.controller.admin_controller;

import com.example.managerment_player_footbal.DTO.AccountForm;
import com.example.managerment_player_footbal.model.Coach;
import com.example.managerment_player_footbal.model.account.Account;
import com.example.managerment_player_footbal.model.account.AccountRole;
import com.example.managerment_player_footbal.model.account.Role;
import com.example.managerment_player_footbal.service.IAccountRoleService;
import com.example.managerment_player_footbal.service.IAccountService;
import com.example.managerment_player_footbal.service.ICoachService;
import com.example.managerment_player_footbal.service.IRoleService;
import com.example.managerment_player_footbal.service.impl.AccountService;
import com.example.managerment_player_footbal.validate.AccountValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AccountController {
    @Autowired
    IAccountService iAccountService;

    @Autowired
    ICoachService iCoachService;

    @Autowired
    IRoleService iRoleService;

    @Autowired
    IAccountRoleService iAccountRoleService;

    @Autowired
    private AccountService accountService;

    @GetMapping("/indexAccount")
    public String showIndexAccount(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        model.addAttribute("userName", username);
        model.addAttribute("accountForm", new AccountForm());
        model.addAttribute("accountRole", new AccountRole());
        model.addAttribute("roleList", iRoleService.findAll());
        return "admin/createAcountCoach";
    }

    @PostMapping("/saveAccountCach")
    public String saveAccount(@Valid @ModelAttribute("accountForm") AccountForm accountForm, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Account account = new Account();
        account.setAccountName(accountForm.getAccountName());
        account.setPassword(passwordEncoder.encode(accountForm.getPassword()));
        Account userName = (iAccountService.findByAccountName(accountForm.getAccountName()));
        AccountValidate accountValidate = new AccountValidate();
        accountValidate.validate(accountForm, bindingResult);
        if (userName == null && !bindingResult.hasErrors()) {
            model.addAttribute("roleList", iRoleService.findAll());
            iAccountService.createOrUpdate(account);
            Role role = iRoleService.get(accountForm.getRoleId());

            AccountRole accountRole = new AccountRole();
            accountRole.setAccount(account);
            accountRole.setRole(role);
            iAccountRoleService.save(accountRole);


            accountForm.setAccount(accountService.findByAccountName(account.getAccountName()));

            Coach coach = new Coach(accountForm.getGender(), accountForm.getNameCoach(), accountForm.getAvatar(),
                    accountForm.getBirthday(), accountForm.getPhone(), accountForm.getEmail(), accountForm.getAddress(),
                    accountForm.getAccount());
            iCoachService.createOrUpdateCoach(coach);
            redirectAttributes.addFlashAttribute("message", "Thêm Mới Thành Công");
            return "redirect:/admin/listCoach";
        } else {
            model.addAttribute("roleList", iRoleService.findAll());
            if (userName != null) {
                model.addAttribute("roleList", iRoleService.findAll());
                model.addAttribute("messageErrorUserName", "UserName bạn vừa nhập đã tồn tại . Vui lòng nhập User Name khác");
                return "admin/createAcountCoach";
            }
            return "admin/createAcountCoach";
        }
    }

}
