package com.kw.LinkIt.global.jwt;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Indexed;

@Getter
public class RefreshToken {
    @Id
    private String refreshToken;
    private final Long userId;

    public RefreshToken(final String refreshToken, final Long userId) {
        this.refreshToken = refreshToken;
        this.userId = userId;
    }
}
