package com.kw.LinkIt.domain.team.controller;

import com.kw.LinkIt.domain.team.dto.request.CreateTeamDTO;
import com.kw.LinkIt.domain.team.dto.request.UpdateTeamProfileDTO;
import com.kw.LinkIt.domain.team.dto.response.AppbarTeamInfoVO;
import com.kw.LinkIt.global.common.response.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Team")
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/team")
public class TeamController {

    @Operation(summary = "팀 생성")
    @PostMapping
    public ResponseEntity<String> createTeam(@ModelAttribute @Valid CreateTeamDTO createTeamDTO) {
        return BaseResponse.ok("팀 생성 완료");
    }

    @Operation(summary = "팀 프로필 수정")
    @PutMapping("/{teamId}")
    public ResponseEntity<String> updateTeamProfile(@PathVariable("teamId") Long teamId, @ModelAttribute @Valid UpdateTeamProfileDTO updateTeamProfileDTO) {
        return BaseResponse.ok("팀 프로필 수정 완료");
    }

    @Operation(summary = "appbar 에 표시해줄 팀 정보 반환")
    @GetMapping("/app-bar/{teamId}")
    public ResponseEntity<AppbarTeamInfoVO> getAppbarTeamInfo(@PathVariable("teamId") Long teamId) {
        return BaseResponse.ok(AppbarTeamInfoVO.mock());
    }
}
