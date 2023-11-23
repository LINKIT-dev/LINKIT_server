package com.kw.LinkIt.domain.link.error;

import com.kw.LinkIt.global.error.code.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum LinkErrorCode implements ErrorCode {
    INVALID_LINK_OWNERSHIP(HttpStatus.BAD_REQUEST, "L-001", "자신이 등록한 링크만 삭제할 수 있습니다.");

    private HttpStatus status;
    private String code;
    private String message;
}
