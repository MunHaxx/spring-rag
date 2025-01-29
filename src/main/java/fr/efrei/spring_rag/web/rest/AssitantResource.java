package fr.efrei.spring_rag.web.rest;

import fr.efrei.spring_rag.service.AssistantAiService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssitantResource {
    private final AssistantAiService assistantAiService;

    AssitantResource(AssistantAiService assistantAiService) {
        this.assistantAiService = assistantAiService;
    }

    @PostMapping("/assistants/chat")
    public String chat(@RequestBody String query) {
        return assistantAiService.chat(query);
    }
}
