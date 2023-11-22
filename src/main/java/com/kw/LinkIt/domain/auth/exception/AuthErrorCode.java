package com.kw.LinkIt.domain.auth.exception;

import com.kw.LinkIt.global.error.code.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum AuthErrorCode implements ErrorCode {

        INVALID_KAKAO_TOKEN(HttpStatus.UNAUTHORIZED,"A-001","카카오 인증 오류가 발생하였습니다."),
        WRONG_ID(HttpStatus.NOT_FOUND, "A-002", "올바르지 않은 ID입니다."),
        WRONG_PW(HttpStatus.NOT_FOUND, "A-003", "올바르지 않은 PW입니다.");
        private HttpStatus status;
        private String code;
        private String message;
}
