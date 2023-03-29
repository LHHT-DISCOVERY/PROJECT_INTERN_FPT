package com.example.managerment_player_footbal.api;

import com.example.managerment_player_footbal.model.Coach;
import com.example.managerment_player_footbal.service.ICoachService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/coach")
public class CoachApiController {

    private final ICoachService coachService;

    public CoachApiController(ICoachService coachService) {
        this.coachService = coachService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coach> get(@PathVariable String id){
        return ResponseEntity.ok(coachService.findById(Integer.parseInt(id)));
    }
}
