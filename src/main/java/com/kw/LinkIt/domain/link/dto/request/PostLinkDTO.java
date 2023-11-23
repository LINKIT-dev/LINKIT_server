package com.kw.LinkIt.domain.link.dto.request;

import com.kw.LinkIt.domain.link.entity.Link;
import com.kw.LinkIt.domain.team.entity.Team;
import com.kw.LinkIt.domain.user.entity.User;
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

    public Link toEntity(User user, Team team) {
        return Link.builder()
                    .url(this.url)
                    .title(this.title)
                    .content(this.content)
                    .previewImg(this.previewImgUrl)
                    .user(user)
                    .team(team)
                .build();
    }
}
