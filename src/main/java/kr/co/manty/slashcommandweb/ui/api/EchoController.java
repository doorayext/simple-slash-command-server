package kr.co.manty.slashcommandweb.ui.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class EchoController {
    @PostMapping("/slash/echo")
    public SlashCommandResponse hi(@RequestBody SlashCommandRequest request) {
        log.info( request.toString() );
        return SlashCommandResponse.builder()
                                   .text(request.getText())
                                   .responseType(ResponseType.IN_CHANNEL)
                                   .build();
    }
}
