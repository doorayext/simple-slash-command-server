package kr.co.manty.slashcommandweb;

import kr.co.manty.slashcommandweb.ui.api.ResponseType;
import kr.co.manty.slashcommandweb.ui.api.SlashCommandRequest;
import kr.co.manty.slashcommandweb.ui.api.SlashCommandResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@SpringBootApplication
public class SlashCommandWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SlashCommandWebApplication.class, args);
    }
    
    @PostMapping("/slash/hi")
    public SlashCommandResponse hi(SlashCommandRequest request) {
        log.info( request.toString() );
        return SlashCommandResponse.builder()
                                   .text("Hello World!!")
                                   .responseType(ResponseType.IN_CHANNEL)
                                   .build();
    }

    

    

}
