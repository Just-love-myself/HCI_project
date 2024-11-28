package com.example.HumanInterface.controller;

import com.example.HumanInterface.dto.GameResultRequestDTO;
import com.example.HumanInterface.service.GameService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/games")
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/{memberId}/results")
//    @CrossOrigin(origins = "https://memory-game-him.netlify.app")
    @CrossOrigin(origins = {"https://memory-game-him.netlify.app", "http://localhost:3000"})
    public ResponseEntity<String> uploadResult(@PathVariable Long memberId, @RequestBody @Valid GameResultRequestDTO request) {
        // store the member's result of the game
        try {
            gameService.saveGameResult(memberId, request);
            return ResponseEntity.ok("Game result saved successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to save game result: " + e.getMessage());
        }
    }
}
