package kr.co.manty.slashcommandweb.ui.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Slf4j
@RestController
public class Base64Controller {
    @PostMapping("/slash/base64e")
    public SlashCommandResponse encode(@RequestBody SlashCommandRequest request) {
        log.info( request.toString() );
        
        return SlashCommandResponse.builder()
                                   .text(String.format("%s ==> %s", request.getText(),Base64.getEncoder().encodeToString(request.getText().getBytes())))
                                   .responseType(ResponseType.IN_CHANNEL)
                                   .build();
    }

    @PostMapping("/slash/base64d")
    public SlashCommandResponse decode(@RequestBody SlashCommandRequest request) {
        log.info( request.toString() );

        return SlashCommandResponse.builder()
                                   .text(String.format("%s ==> %s", request.getText(), new String(Base64.getDecoder().decode(request.getText()), StandardCharsets.UTF_8)))
                                   .responseType(ResponseType.IN_CHANNEL)
                                   .build();
    }
}
