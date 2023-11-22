package com.kw.LinkIt.domain.team.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
public class CreateTeamDTO {
    @NotBlank
    private String name;

    private MultipartFile profileImg;

    @NotNull
    private Integer capacity;
}
