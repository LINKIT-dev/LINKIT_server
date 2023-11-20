package com.kw.LinkIt.domain.auth.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OAuthTokenReq {
    private String accessToken;
}
