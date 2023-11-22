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
    // TODO: mock 데이터 추후 삭제
    public static List<HashtagVO> mock() {
        return new ArrayList<>(Arrays.asList(
                new HashtagVO(Long.valueOf(1), "flutter"),
                new HashtagVO(Long.valueOf(2), "state management"),
                new HashtagVO(Long.valueOf(3), "blog"),
                new HashtagVO(Long.valueOf(4), "daily"),
                new HashtagVO(Long.valueOf(5), "enjin"),
                new HashtagVO(Long.valueOf(6), "apps"),
                new HashtagVO(Long.valueOf(7), "dev"),
                new HashtagVO(Long.valueOf(8), "같이에듀"),
                new HashtagVO(Long.valueOf(9), "학습멘토링")
        ));
    }


}
