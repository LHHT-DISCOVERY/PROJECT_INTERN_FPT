package com.example.managerment_player_footbal.controller.playerController;


import com.example.managerment_player_footbal.model.*;
import com.example.managerment_player_footbal.model.account.Account;
import com.example.managerment_player_footbal.model.reponse.ScheduleResponse;
import com.example.managerment_player_footbal.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class PlayerController {
    private final IPlayerService playerService;
    private final ICoachService coachService;
    private final IClassesService classService;
    private final IScheduleService scheduleService;
    private final ISubjectService subjectService;

    private final ICoachRatingService coachRatingService;
    private final IAccountService accountService;

    @Autowired
    IAccountService iAccountService ;

    public PlayerController(IPlayerService playerService, ICoachService coachService, IClassesService classService, IScheduleService scheduleService, ISubjectService subjectService, ICoachRatingService coachRatingService, IAccountService accountService) {
        this.playerService = playerService;
        this.coachService = coachService;
        this.classService = classService;
        this.scheduleService = scheduleService;
        this.subjectService = subjectService;
        this.coachRatingService = coachRatingService;
        this.accountService = accountService;
    }

    @GetMapping()
    public String home(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Account account = iAccountService.findByAccountName(username);
        Player playerEntity = playerService.findByPlayerUserName(account.getAccountName());
        Classes classEntity = classService.findAllByIdClass(playerEntity.getClasses().getClassId());
        /* Tính % hoàn thành khóa học */
        long start = classEntity.getStartDate().getTime();
        long end = classEntity.getEndDate().getTime();
        long present = System.currentTimeMillis() - start;
        double percent = (double) present * 100 / (end - start);
        /* Tính chỉ số bmi */
//        List<MedicalReportEntity> medicalReportEntities = medicalReportService.getByPlayerId(playerEntity.getPlayerId());
//        int index = medicalReportEntities.size() - 1;
//        double bmi = (double) medicalReportEntities.get(index).getWeight() /
//                (((double) medicalReportEntities.get(index).getHeight() / 100 ) *
//                        ((double) medicalReportEntities.get(index).getHeight() / 100 ));
        Coach coachEntity = coachService.findById(classEntity.getCoach().getCoachId());
        /* Lấy các thành viên Class */
        List<Player> playerEntities = playerService.findAllByIdClass(playerEntity.getClasses().getClassId());
        Date date = new Date();
        java.sql.Date now = new java.sql.Date(date.getTime());
        List<ScheduleResponse> schedules = scheduleService.getByDate(now);
        List<SubjectEntity> subjects = subjectService.getAll();
        model.addAttribute("player", playerEntity);
        model.addAttribute("coach_name", coachEntity.getNameCoach());
        model.addAttribute("schedules", schedules);
        model.addAttribute("subjects", subjects);
        model.addAttribute("percent", (double) Math.round(percent * 100) / 100);
//        model.addAttribute("bmi",(double)Math.round(bmi * 100) / 100);
//        model.addAttribute("medical_report",medicalReportEntities.get(index));
        model.addAttribute("members", playerEntities);
        model.addAttribute("name_class", classEntity.getClassName());
        return "user/home";
    }

    @GetMapping("/evaluate")
    public String evaluate(Model model) {
        Player playerEntity = playerService.getByID(1);
        Classes classEntity = classService.findAllByIdClass(playerEntity.getClasses().getClassId());
        /* Lấy HLV */
        Coach coachEntity = coachService.findById(classEntity.getCoach().getCoachId());
        /* Kiểm tra xem học viên đã đánh giá HLV chưa */
        CoachRatingEntity coachRatingEntity =
                coachRatingService.getByClassIdAndPlayerId(playerEntity.getClasses().getClassId(), playerEntity.getPlayerId());
        CoachRatingEntity coachRating = new CoachRatingEntity();
        coachRating.setPlayerEntity(playerEntity);
        coachRating.setClasses(playerEntity.getClasses());
        coachRating.setCoachEntity(playerEntity.getClasses().getCoach());
        if (coachRatingEntity.getRatingId() == 0) {
            model.addAttribute("coach_rating", coachRating);
        } else {
            model.addAttribute("coach_rating", coachRatingEntity);
        }
        model.addAttribute("complete", System.currentTimeMillis() >= playerEntity.getClasses().getEndDate().getTime());
        model.addAttribute("coachEntity", coachEntity);
        model.addAttribute("player", playerEntity);
        model.addAttribute("coaches", coachService.findAll());
        model.addAttribute("evaluate_number", new Integer[]{1, 2, 3, 4, 5});
        model.addAttribute("class", classEntity);
        return "user/evaluate";
    }

    @PostMapping(value = "/evaluate/save")
    public String save(@ModelAttribute("coach_rating") CoachRatingEntity coachRatingRequest, RedirectAttributes ra) {
        CoachRatingEntity coachRatingEntity = coachRatingService.save(coachRatingRequest);
        ra.addFlashAttribute("success", true);
        return "redirect:/user/evaluate";
    }

    @GetMapping("/profile")
    public String profile(Model model) {
        Player playerEntity = playerService.getByID(1);
        List<Classes> classEntities = classService.findAll();
        model.addAttribute("player", playerEntity);
        model.addAttribute("classes", classEntities);
        return "user/profile";
    }

    @PostMapping("/profile/account/save")
    public String save(@ModelAttribute("player") Player playerEntity, RedirectAttributes ra) {
        Account accountEntity = accountService.createOrUpdate(playerEntity.getAccount());
        ra.addFlashAttribute("success", true);
        return "redirect:/user/profile";
    }
}
