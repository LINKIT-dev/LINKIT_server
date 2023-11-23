package com.kw.LinkIt.domain.userTeam.controller;

import com.kw.LinkIt.domain.user.entity.User;
import com.kw.LinkIt.domain.userTeam.dto.response.GetMyParticipationsVO;
import com.kw.LinkIt.domain.userTeam.service.UserTeamService;
import com.kw.LinkIt.global.common.response.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "User_Team")
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/user-team")
public class UserTeamController {

    private final UserTeamService userTeamService;

    @Operation(summary = "[메인 페이지] 유저가 속한 팀 리스트 조회")
    @GetMapping("/my/participations")
    public ResponseEntity<GetMyParticipationsVO> getMyParticipations(@AuthenticationPrincipal User user) {
        GetMyParticipationsVO getMyParticipationsVO = userTeamService.getMyParticipations(user);
        return BaseResponse.ok(getMyParticipationsVO);
    }

    @Operation(summary = "팀원 추가", description = "팀장이 팀에 팀원을 추가합니다. (팀장이 아닐 경우, 오류메시지를 반환합니다.)")
    @PostMapping("/members/{teamId}")
    public ResponseEntity<String> addTeamMembers(@PathVariable("teamId") Long teamId, @RequestParam @NotBlank String nickname) {
        return BaseResponse.ok("팀원 추가 완료");
    }
}
