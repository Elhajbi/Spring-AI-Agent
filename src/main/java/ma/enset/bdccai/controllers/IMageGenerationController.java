package ma.enset.bdccai.controllers;

import org.springframework.ai.image.ImageOptions;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IMageGenerationController {
    private final OpenAiImageModel openAiImageModel;

    public IMageGenerationController(OpenAiImageModel openAiImageModel) {
        this.openAiImageModel = openAiImageModel;
    }
    @GetMapping("/generateImage")
    public String generateImage(String prompt) {
        ImageOptions imageOptions = OpenAiImageOptions.builder()
                .quality("hd")
                .model("dall-e-3")
                .build();
        ImagePrompt imagePrompt = new ImagePrompt(prompt, imageOptions);
        return openAiImageModel.call(imagePrompt).getResult().getOutput().getUrl(); }
    }
        /*
    }http://localhost:8899/generateImage?prompt=un%20chien%20dans%20uu%20montagne*/

