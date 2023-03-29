package com.example.managerment_player_footbal.api;

import com.example.managerment_player_footbal.model.Player;
import com.example.managerment_player_footbal.model.request.PlayerRequest;
import com.example.managerment_player_footbal.service.IPlayerService;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class PlayerApiController {
    private final IPlayerService playerService;

    public PlayerApiController(IPlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Player> add(PlayerRequest playerRequest){
        return ResponseEntity.ok(playerService.save(playerRequest));
    }

    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Player> update(PlayerRequest playerRequest){
        return ResponseEntity.ok(playerService.save(playerRequest));
    }
}
