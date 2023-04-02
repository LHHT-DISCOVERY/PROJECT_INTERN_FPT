package com.example.managerment_player_footbal.api;

import com.example.managerment_player_footbal.model.CoachRatingEntity;
import com.example.managerment_player_footbal.service.ICoachRatingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/coach/rating")
public class CoachRatingAPIController {
    private final ICoachRatingService coachRatingService;

    public CoachRatingAPIController(ICoachRatingService coachRatingService) {
        this.coachRatingService = coachRatingService;
    }
    @GetMapping("/{classId}/{playerId}")
    public ResponseEntity<CoachRatingEntity> get
            (@PathVariable("classId") String classId,@PathVariable("playerId") String playerId){
        return ResponseEntity.ok(coachRatingService.getByClassIdAndPlayerId(Integer.parseInt(classId),Integer.parseInt(playerId)));
    }
}
