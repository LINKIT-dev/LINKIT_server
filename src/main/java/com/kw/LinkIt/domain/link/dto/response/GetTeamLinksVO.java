package com.kw.LinkIt.domain.link.dto.response;

import java.util.List;

public record GetTeamLinksVO(String teamName, List<LinkVO> links, Integer totalLinkCount) {
    // TODO: mock 데이터 추후 삭제
    public static GetTeamLinksVO mock() {
        return new GetTeamLinksVO("OSS Project", LinkVO.mock(), 4);
    }
}
