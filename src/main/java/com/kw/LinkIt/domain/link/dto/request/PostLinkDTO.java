package com.kw.LinkIt.domain.link.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PostLinkDTO {
    @NotBlank
    private String url;

    @NotBlank
    private String title;

    private String content;

    private String previewImgUrl;

    @NotNull
    private Long teamId;

    private List<String> hashtagNames;
}
