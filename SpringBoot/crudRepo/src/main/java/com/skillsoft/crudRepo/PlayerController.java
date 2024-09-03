package com.skillsoft.crudRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@RequestMapping(path="/")
public class PlayerController {
    private final  PlayerService playerService;
    @Autowired
    public PlayerController(PlayerService playerService){
        this.playerService = playerService;
    }
    @GetMapping(path="/player/{name}")
    public ResponseEntity<List<Player>> getPlayerByName(@PathVariable String name) {
        return ResponseEntity.ok(playerService.getPlayerByName(name));
    }
}