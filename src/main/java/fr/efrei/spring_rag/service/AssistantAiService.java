package fr.efrei.spring_rag.service;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface AssistantAiService {

    @SystemMessage(fromResource = "/prompts/system.st")
    String chat(String userMessage);
}
