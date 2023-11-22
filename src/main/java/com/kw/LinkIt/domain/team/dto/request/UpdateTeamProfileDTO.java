package com.kw.LinkIt.domain.team.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateTeamProfileDTO {
    @NotBlank
    private String name;

    private String profileImg;

    @NotNull
    private Integer capacity;
}
