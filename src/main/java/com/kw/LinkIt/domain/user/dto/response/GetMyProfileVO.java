package com.kw.LinkIt.domain.user.dto.response;

public record GetMyProfileVO(String username, String email, String profileImg) {

    // TODO: mock 데이터 추후 삭제
    public static GetMyProfileVO mock() {
        return new GetMyProfileVO(
                "kuromi",
                "kuromi0359@naver.com",
                "https://mock-img.s3.ap-northeast-2.amazonaws.com/a949b88a-2284-4873-b91c-bc15cdc3ce42+(1).jpg"
        );
    }
}
