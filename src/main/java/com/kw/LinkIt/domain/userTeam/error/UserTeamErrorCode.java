package com.kw.LinkIt.domain.userTeam.error;

import com.kw.LinkIt.global.error.code.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum UserTeamErrorCode implements ErrorCode {

    IS_NOT_LEADER(HttpStatus.BAD_REQUEST, "UT-001", "팀 리더만 팀원을 추가할 수 있습니다."),
    ALREADY_IN_TEAM(HttpStatus.BAD_REQUEST, "UT-002", "이미 해당 팀에 참여중인 유저입니다.");

    private HttpStatus status;
    private String code;
    private String message;
}
