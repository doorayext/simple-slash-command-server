package kr.co.manty.slashcommandweb.ui.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.MimeUtility;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Slf4j
@RestController
public class QuotedPrintableController {
    @PostMapping("/slash/qpe")
    public SlashCommandResponse encode(@RequestBody SlashCommandRequest request) throws UnsupportedEncodingException {
        log.info( request.toString() );
        
        return SlashCommandResponse.builder()
                                   .text(String.format("%s ==> %s", request.getText(),MimeUtility.encodeText(request.getText(),"UTF-8", "Q")))
                                   .responseType(ResponseType.IN_CHANNEL)
                                   .build();
    }

    @PostMapping("/slash/qpd")
    public SlashCommandResponse decode(@RequestBody SlashCommandRequest request) throws UnsupportedEncodingException {
        log.info( request.toString() );

        return SlashCommandResponse.builder()
                                   .text(String.format("%s ==> %s", request.getText(), MimeUtility.decodeText(request.getText())))
                                   .responseType(ResponseType.IN_CHANNEL)
                                   .build();
    }
}
