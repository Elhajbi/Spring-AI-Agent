package ma.enset.bdccai.controllers;

import ma.enset.bdccai.outputs.Movie;
import ma.enset.bdccai.outputs.MovieList;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AIAgentStructuredController {
    private final ChatClient chatClient;

    public AIAgentStructuredController(ChatClient.Builder chatClient) {
        this.chatClient = chatClient
                .defaultAdvisors(new SimpleLoggerAdvisor())
                .build();
    }
    @GetMapping("/askAgent")
    public MovieList askLLK(String query){
        String systemMessage = """
                Vous etes un spécialite dans le doamine du cinéma
                Répond à la question de l'utilisateur à ce propos
                """
                ;
        return chatClient.prompt()
                .system(systemMessage)
                .user(query).call().entity(MovieList.class);
    }
}
