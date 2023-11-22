package com.kw.LinkIt.domain.auth.service;

import com.kw.LinkIt.domain.auth.dto.request.LoginDTO;
import com.kw.LinkIt.domain.auth.dto.request.SignUpDTO;
import com.kw.LinkIt.domain.auth.dto.response.TokenVO;

public interface AuthService {
    void signUp(SignUpDTO signUpDTO);
    TokenVO login(LoginDTO loginDTO);
//    void logout(Long userId);
}
