package kr.co.manty.slashcommandweb.ui.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class InteractiveRequest {
    private String actionValue;
    private User user;
    
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class User{
        private String email;
    }
}
