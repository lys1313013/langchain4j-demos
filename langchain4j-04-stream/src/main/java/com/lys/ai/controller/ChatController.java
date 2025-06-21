package com.lys.ai.controller;

import com.lys.ai.service.Assistant;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * 类功能描述
 *
 * @author Lys
 * @date 2025/06/21 16:03
 */
@RestController
@AllArgsConstructor
public class ChatController {
    private final Assistant assistant;

    @GetMapping("/chat")
    public Flux<String> chat(@RequestParam("message") String message) {
        return assistant.chat(message);
    }
}
