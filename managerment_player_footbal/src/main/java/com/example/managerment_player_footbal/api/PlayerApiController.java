package com.example.managerment_player_footbal.api;

import com.example.managerment_player_footbal.model.Player;
import com.example.managerment_player_footbal.model.request.PlayerRequest;
import com.example.managerment_player_footbal.service.IPlayerService;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        Player player = playerService.save(playerRequest) ;
        return ResponseEntity.ok(playerService.save(playerRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> get(@PathVariable String id){
        Player player = playerService.getByID(Integer.parseInt(id));
        return ResponseEntity.ok(player);
    }
}
