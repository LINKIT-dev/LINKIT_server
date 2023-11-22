package com.kw.LinkIt.domain.link.dto.response;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public record LinkVO(UserVO userVO, String title, String content, String linkPreviewImg, Integer liked) {
    // TODO: mock 데이터 추후 삭제
    public static List<LinkVO> mock() {
        return new ArrayList<>(Arrays.asList(
                new LinkVO(new UserVO("Taeyun", "https://i.ibb.co/V9rV08m/logo-003.jpg"),
                        "[Flutter] pub get이 안될때",
                        "Deep dive into Flutter state management solutions.",
                        "https://jinsiri.tistory.com/579",
                        0),

                new LinkVO(new UserVO("Eunjin", "https://i.ibb.co/V9rV08m/logo-003.jpg"),
                        "小さくて大事な ♡´･ᴗ･`♡",
                        "타이어보다 싸다 ! 내 일상 무료공개 !",
                        "https://blog.naver.com/ibsuny3214",
                        0),

                new LinkVO(new UserVO("Seungho", "https://i.ibb.co/V9rV08m/logo-003.jpg"),
                        "Flutter - Build apps for any screen",
                        "Flutter transforms the entire app development process. Build, test, and deploy beautiful mobile, web, desktop, and embedded apps from a single codebase.",
                        "//flutter.dev/",
                        0),

                new LinkVO(new UserVO("Jimin", "https://i.ibb.co/V9rV08m/logo-003.jpg"),
                        "그루터기 학습멘토링 같이에듀",
                        "그루터기 학습멘토링 같이에듀는 사각지대에 놓여있는 청소년의 학습결손을 보완하고, 교육격차를 해소하여 건강한 성장을 지원합니다.",
                        "https://withedu.or.kr",
                        0)
        ));
    }
}
