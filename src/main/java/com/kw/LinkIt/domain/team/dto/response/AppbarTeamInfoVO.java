package com.kw.LinkIt.domain.team.dto.response;

public record AppbarTeamInfoVO(String teamName, String profileImg) {
    public static AppbarTeamInfoVO mock() {
        return new AppbarTeamInfoVO("OSS Project", "https://i.ibb.co/V9rV08m/logo-003.jpg");
    }
}