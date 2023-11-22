package com.kw.LinkIt.global.jwt.exception;

import com.kw.LinkIt.global.error.code.ErrorCode;
import com.kw.LinkIt.global.error.exception.BusinessException;
import lombok.Getter;

@Getter
public class CustomJwtException extends BusinessException {
    public CustomJwtException(ErrorCode errorCode) {
        super(errorCode);
    }
}
