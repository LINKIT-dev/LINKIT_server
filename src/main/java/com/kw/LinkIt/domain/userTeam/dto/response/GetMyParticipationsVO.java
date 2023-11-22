package com.kw.LinkIt.domain.userTeam.dto.response;

import java.util.List;

public record GetMyParticipationsVO(List<TeamVO> teams, Integer totalTeamCount) {
    // TODO: mock 데이터 추후 삭제
    public static GetMyParticipationsVO mock() {
        return new GetMyParticipationsVO(
               TeamVO.mock(),
                2
        );
    }
}
