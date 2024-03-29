package kr.co.manty.slashcommandweb.ui.api;

import lombok.Data;

@Data
public class SlashCommandRequest {
    private String tenantId;
    private String tenantDomain;
    private String channelId;
    private String channelName;
    private String userId;
    private String command;
    private String text;
    private String responseUrl;
    private String appToken;
    private String triggerId;
}
