package com.kw.LinkIt.domain.hashtag.dto.response;

import com.kw.LinkIt.domain.hashtag.entity.Hashtag;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public record HashtagVO(Long hashtagId, String hashtagName) {

    public static HashtagVO of(Hashtag entity) {
        return new HashtagVO(
                entity.getId(),
                entity.getName()
        );
    }



}
