package com.kw.LinkIt.domain.auth.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignUpDTO {
    @NotBlank(message = "아이디를 입력해주세요.")
    private String uid;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String password;
}
