package com.kw.LinkIt.domain.link.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateLinkDTO {
    @NotBlank
    private String url;

    @NotBlank
    private String title;

    private String content;

    private String previewImgUrl;
}
