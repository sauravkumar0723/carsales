package com.project.carsales.controller;

import com.project.carsales.service.AiQueryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
public class AIController {

    private final AiQueryService aiService;

    public AIController(AiQueryService aiService) {
        this.aiService = aiService;
    }


    @PostMapping("/ask")
    public ResponseEntity<String> ask(@RequestBody String question) {
        return ResponseEntity.ok(aiService.process(question));
    }
}
