package com.kw.LinkIt.domain.auth.controller;

import com.kw.LinkIt.domain.auth.dto.request.LoginDTO;
import com.kw.LinkIt.domain.auth.dto.request.SignUpDTO;
import com.kw.LinkIt.domain.auth.dto.response.TokenVO;
import com.kw.LinkIt.domain.auth.service.AuthServiceImpl;
import com.kw.LinkIt.domain.user.entity.User;
import com.kw.LinkIt.global.common.response.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthServiceImpl authService;

    @Operation(summary = "유저 회원가입", description = "신규 유저를 등록합니다.")
    @PostMapping("/sign-up")
    public ResponseEntity<String> signUp(@RequestBody @Valid SignUpDTO signUpDTO) {
        authService.signUp(signUpDTO);
        return BaseResponse.ok("회원가입 완료");
    }

    @Operation(summary = "유저 로그인", description = "로그인 성공 시, AccessToken을 반환합니다.")
    @PostMapping("/login")
    public ResponseEntity<TokenVO> login(@RequestBody LoginDTO loginDTO) {
        System.out.println("---- loginReq uid : " + loginDTO.getUid());

        TokenVO token = authService.login(loginDTO);
        return BaseResponse.ok(token);
    }

    @Operation(summary = "유저 로그아웃", description = "로그아웃 요청 시, 별다른 처리 없이 성공 메세지를 반환합니다.")
    @GetMapping("/logout")
    public ResponseEntity<String> logout(@AuthenticationPrincipal User user) {
        return BaseResponse.ok("로그아웃 성공");
    }
}
