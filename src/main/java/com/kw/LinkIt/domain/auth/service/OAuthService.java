package com.kw.LinkIt.domain.auth.service;

import com.kw.LinkIt.domain.auth.dto.request.OAuthTokenReq;
import com.kw.LinkIt.domain.auth.dto.response.TokenRes;

public interface OAuthService {
    public TokenRes oAuthLogin(OAuthTokenReq OAuthTokenReq);
}
