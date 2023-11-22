package com.kw.LinkIt.domain.userTeam.dto.response;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public record TeamVO(String name, String profileImg, List<String> memberProfileImgs, List<String> top3Hashtags, Integer totalHashtagCount) {
    // TODO: mock 데이터 추후 삭제
    public static List<TeamVO> mock() {
        return new ArrayList<>(Arrays.asList(
                new TeamVO("project_1",
                "https://mock-img.s3.ap-northeast-2.amazonaws.com/a949b88a-2284-4873-b91c-bc15cdc3ce42+(1).jpg",
                new ArrayList<>(Arrays.asList("https://mock-img.s3.ap-northeast-2.amazonaws.com/a949b88a-2284-4873-b91c-bc15cdc3ce42+(1).jpg","https://mock-img.s3.ap-northeast-2.amazonaws.com/a949b88a-2284-4873-b91c-bc15cdc3ce42+(1).jpg")),
                new ArrayList<>(Arrays.asList("#figma", "#flutter", "#front-end")),
                        5),

                new TeamVO("project_2",
                "https://mock-img.s3.ap-northeast-2.amazonaws.com/a949b88a-2284-4873-b91c-bc15cdc3ce42+(1).jpg",
                new ArrayList<>(Arrays.asList("https://mock-img.s3.ap-northeast-2.amazonaws.com/a949b88a-2284-4873-b91c-bc15cdc3ce42+(1).jpg","https://mock-img.s3.ap-northeast-2.amazonaws.com/a949b88a-2284-4873-b91c-bc15cdc3ce42+(1).jpg")),
                new ArrayList<>(Arrays.asList("#spring", "#back-end")),
                        2)
        ));
    }
}
