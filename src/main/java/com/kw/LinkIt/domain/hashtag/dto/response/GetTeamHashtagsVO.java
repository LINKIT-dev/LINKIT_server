package com.kw.LinkIt.domain.hashtag.dto.response;

import java.util.List;

public record GetTeamHashtagsVO(List<HashtagVO> hashtags) {
    // TODO: mock 데이터 추후 삭제
    public static GetTeamHashtagsVO mock() {
        return new GetTeamHashtagsVO(HashtagVO.mock());
    }
}
