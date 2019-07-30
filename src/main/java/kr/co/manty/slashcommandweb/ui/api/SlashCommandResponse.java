package kr.co.manty.slashcommandweb.ui.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SlashCommandResponse {
    private Boolean replaceOriginal;
    private Boolean deleteOriginal;
    private String text;
    private ResponseType responseType;
    private List<Attachment> attachments;

    @Data
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Attachment{
        private String callbackId;
        private List<Action> actions;
    }
    
    @Data
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Action {
        private String name;
        private String type;
        private String text;
        private String value;
        private String style;
    }
}
