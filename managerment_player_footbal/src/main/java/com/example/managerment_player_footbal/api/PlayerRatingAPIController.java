package com.example.managerment_player_footbal.api;

import com.example.managerment_player_footbal.model.Player;
import com.example.managerment_player_footbal.model.PlayerRating;
import com.example.managerment_player_footbal.model.account.Account;
import com.example.managerment_player_footbal.service.IPlayerRatingService;

import com.example.managerment_player_footbal.service.IPlayerService;
import com.example.managerment_player_footbal.service.impl.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user/rating")
public class PlayerRatingAPIController {
    @Autowired
    AccountService  iAccountService ;
    @Autowired
    IPlayerService iPlayerService ;

    private final IPlayerRatingService playerRatingService;

    public PlayerRatingAPIController(IPlayerRatingService playerRatingService) {
        this.playerRatingService = playerRatingService;
    }
    @GetMapping
    public ResponseEntity<PlayerRating> get(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Account account = iAccountService.findByAccountName(username);
        Player playerEntity = iPlayerService.findByPlayerUserName(account.getAccountName());
        return ResponseEntity.ok(playerRatingService.getByPlayerId(playerEntity.getPlayerId()));
    }
}
