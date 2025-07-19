package ma.enset.bdccai.controllers;
import ma.enset.bdccai.outputs.CinModel;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class MultiModalController {
    private final ChatClient chatClient;
    @Value("classpath:/images/CIN.png")
    private Resource image;
    @Value("classpath:/images/IMG.jpg")
    private Resource image2;

    public MultiModalController(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build();
    }
    @GetMapping("/describe")
    public CinModel describeImage(){
         return chatClient.prompt()
                 .system("Donner un description de l'image fournie")
                 .user(u ->
                         u.text("Décrire cette image")
                                 .media(MediaType.IMAGE_JPEG,image)
                 ).call()
                 .entity(CinModel.class);
    }
    @PostMapping(value = "/askImage",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String askImage(@RequestParam(name = "file ") MultipartFile file , String question) throws IOException {
        byte[] bytes = file.getBytes();
        return chatClient.prompt()
                .system("Répond à la question de l'utilisateur à propos de l'image manusrite fournie")
                .user(u ->
                        u.text(question)
                                .media(MediaType.IMAGE_JPEG ,new ByteArrayResource(bytes))
                ).call()
                .content();
    }
}
