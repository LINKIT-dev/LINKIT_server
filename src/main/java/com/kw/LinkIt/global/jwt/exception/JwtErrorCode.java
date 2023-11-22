package com.kw.LinkIt.global.jwt.exception;

import com.kw.LinkIt.global.error.code.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum JwtErrorCode implements ErrorCode {
    INVALID_JWT_TOKEN(HttpStatus.UNAUTHORIZED, "J-001", "유효하지 않은 JWT 토큰입니다."),
    EXPIRED_JWT_TOKEN(HttpStatus.UNAUTHORIZED, "J-002", "만료된 JWT 토큰입니다."),
    UNSUPPORTED_JWT_TOKEN(HttpStatus.UNAUTHORIZED, "J-003", "지원하지 않는 JWT 토큰입니다.");

    private HttpStatus status;
    private String code;
    private String message;
}
