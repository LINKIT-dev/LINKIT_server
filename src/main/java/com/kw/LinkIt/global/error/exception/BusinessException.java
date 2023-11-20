package com.kw.LinkIt.global.error.exception;

import com.kw.LinkIt.global.error.code.CommonErrorCode;
import com.kw.LinkIt.global.error.response.ErrorResponse;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class BusinessException extends RuntimeException {

    private CommonErrorCode commonErrorCode;
    private List<ErrorResponse.CustomFieldError> errors = new ArrayList<>();

    public BusinessException(CommonErrorCode commonErrorCode, String message) {
        super(message);
        this.commonErrorCode = commonErrorCode;
    }

    public BusinessException(CommonErrorCode commonErrorCode) {
        super(commonErrorCode.getMessage());
        this.commonErrorCode = commonErrorCode;
    }

    public BusinessException(CommonErrorCode commonErrorCode, List<ErrorResponse.CustomFieldError> errors) {
        super(commonErrorCode.getMessage());
        this.commonErrorCode = commonErrorCode;
        this.errors = errors;
    }
}
