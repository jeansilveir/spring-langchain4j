package com.jeansilveir.Langchain4j;

import dev.langchain4j.service.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/assistant")
public class AssistantController {

    private final AssistantAIService assistantAIService;

    public AssistantController(AssistantAIService assistantAIService) {
        this.assistantAIService = assistantAIService;
    }

    @PostMapping()
    public String askAssistant(@RequestBody String userMessage) {
        Result<String> result = assistantAIService.handleRequest(userMessage);
        return result.content();
    }
}
