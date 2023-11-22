package com.kw.LinkIt.domain.user.controller;

import com.kw.LinkIt.domain.user.dto.response.GetMyProfileVO;
import com.kw.LinkIt.global.common.response.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "User")
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    @Operation(summary = "[메인 페이지] 유저 프로필 조회")
    @GetMapping("/my/profile")
    public ResponseEntity<GetMyProfileVO> getMyProfile() {
        return BaseResponse.ok(GetMyProfileVO.mock());
    }
}
