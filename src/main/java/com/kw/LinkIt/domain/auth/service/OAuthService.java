package com.kw.LinkIt.domain.auth.service;

import com.kw.LinkIt.domain.auth.dto.request.OAuthTokenDTO;
import com.kw.LinkIt.domain.auth.dto.response.TokenVO;

public interface OAuthService {
    public TokenVO oAuthLogin(OAuthTokenDTO OAuthTokenDTO);
}
