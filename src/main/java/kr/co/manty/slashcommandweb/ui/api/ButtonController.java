package kr.co.manty.slashcommandweb.ui.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@RestController
public class ButtonController {
    
    private AtomicInteger count = new AtomicInteger(1);

    @RequestMapping("/slash/button/interactive")
    public SlashCommandResponse interactive(@RequestBody InteractiveRequest request) {
        log.info(request.toString());
        return buildSlashCommandResponse(String.format("Button Message (%d) - latest: %s", count.incrementAndGet(), request.getUser().getEmail()),true);
    }

    @PostMapping("/slash/button")
    public SlashCommandResponse button(@RequestBody SlashCommandRequest request) {
        log.info( request.toString() );
        return buildSlashCommandResponse(String.format("Button Message (%d)", count.incrementAndGet()), false);
    }

    private SlashCommandResponse buildSlashCommandResponse(String text, Boolean replace) {
        return SlashCommandResponse.builder()
                                   .text(text)
                                   .replaceOriginal(replace)
                                   .responseType(ResponseType.IN_CHANNEL)
                                   .attachments(
                                       Arrays.asList(
                                           SlashCommandResponse.Attachment
                                               .builder()
                                               .callbackId("send-1111")
                                               .actions(
                                                   Arrays.asList(
                                                       SlashCommandResponse
                                                           .Action
                                                           .builder()
                                                           .name("send")
                                                           .type("button")
                                                           .text("Send")
                                                           .value("posting")
                                                           .style("primary")
                                                           .build(),
                                                       SlashCommandResponse
                                                           .Action
                                                           .builder()
                                                           .name("send")
                                                           .type("button")
                                                           .text("Cancel")
                                                           .value("cancel")
                                                           .build()
                                                   )
                                               )
                                               .build()
                                       )
                                   )
                                   .build();
    }
}
