package com.kw.LinkIt.domain.auth.service;

import com.kw.LinkIt.domain.auth.dto.request.LoginDTO;
import com.kw.LinkIt.domain.auth.dto.request.SignUpDTO;
import com.kw.LinkIt.domain.auth.dto.response.TokenVO;

public interface AuthService {

//    TODO : 회원가입 구현 시 적용
    void signUp(SignUpDTO signUpDTO);
    TokenVO login(LoginDTO loginDTO);
//    void logout(Long userId);
}
