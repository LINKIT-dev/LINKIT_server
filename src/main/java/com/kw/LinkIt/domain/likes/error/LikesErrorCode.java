package com.kw.LinkIt.domain.likes.error;

import com.kw.LinkIt.global.error.code.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum LikesErrorCode implements ErrorCode {
    LIKES_ALREADY_PRESSED(HttpStatus.BAD_REQUEST, "Likes-001", "이미 좋아요를 누른 링크입니다.");

    private HttpStatus status;
    private String code;
    private String message;
}
