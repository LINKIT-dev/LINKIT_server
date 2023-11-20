package com.kw.LinkIt.global.error.response;

import com.kw.LinkIt.global.error.code.CommonErrorCode;
import jakarta.validation.ConstraintViolation;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ErrorResponse {

    private HttpStatus status;
    private String code;
    private String message;
    private List<CustomFieldError> errors;

    private ErrorResponse(final CommonErrorCode commonErrorCode) {
        this.status = commonErrorCode.getStatus();
        this.code = commonErrorCode.getCode();
        this.message = commonErrorCode.getMessage();
        this.errors = new ArrayList<>();
    }

    private ErrorResponse(final CommonErrorCode commonErrorCode, final List<CustomFieldError> errors) {
        this.status = commonErrorCode.getStatus();
        this.code = commonErrorCode.getCode();
        this.message = commonErrorCode.getMessage();
        this.errors = errors;
    }

    public static ErrorResponse of(final CommonErrorCode commonErrorCode, final BindingResult bindingResult) {
        return new ErrorResponse(commonErrorCode, CustomFieldError.of(bindingResult));
    }

    public static ErrorResponse of(final CommonErrorCode commonErrorCode, final Set<ConstraintViolation<?>> constraintViolations) {
        return new ErrorResponse(commonErrorCode, CustomFieldError.of(constraintViolations));
    }

    public static ErrorResponse of(final CommonErrorCode commonErrorCode, final String missingParameterName) {
        return new ErrorResponse(commonErrorCode, CustomFieldError.of(missingParameterName, "", "parameter must required"));
    }

    public static ErrorResponse of(final CommonErrorCode commonErrorCode) {
        return new ErrorResponse(commonErrorCode);
    }

    public static ErrorResponse of(final CommonErrorCode code, final List<CustomFieldError> errors) {
        return new ErrorResponse(code, errors);
    }

    public static ErrorResponse of(MethodArgumentTypeMismatchException e) {
        final String value = e.getValue() == null ? "" : e.getValue().toString();
        final List<CustomFieldError> errors = CustomFieldError.of(e.getName(), value, e.getErrorCode());
        return new ErrorResponse(CommonErrorCode.INVALID_INPUT_VALUE, errors);
    }


    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class CustomFieldError {
        private String field;
        private String value;
        private String reason;

        public CustomFieldError(String field, String value, String reason) {
            this.field = field;
            this.value = value;
            this.reason = reason;
        }

        public static List<CustomFieldError> of(final String field, final String value, final String reason) {
            List<CustomFieldError> customFieldErrors = new ArrayList<>();
            customFieldErrors.add(new CustomFieldError(field, value, reason));
            return customFieldErrors;
        }

        public static List<CustomFieldError> of(final BindingResult bindingResult) {
            final List<org.springframework.validation.FieldError> fieldErrors = bindingResult.getFieldErrors();
            return fieldErrors.stream()
                    .map(error -> new CustomFieldError(
                            error.getField(),
                            error.getRejectedValue() == null ? "" : error.getRejectedValue().toString(),
                            error.getDefaultMessage()
                    ))
                    .collect(Collectors.toList());
        }

        public static List<CustomFieldError> of(final Set<ConstraintViolation<?>> constraintViolations) {
            List<ConstraintViolation<?>> lists = new ArrayList<>(constraintViolations);
            return lists.stream()
                    .map(error -> new CustomFieldError(
                            error.getPropertyPath().toString(),
                            "",
                            error.getMessageTemplate()
                    ))
                    .collect(Collectors.toList());
        }
    }
}
