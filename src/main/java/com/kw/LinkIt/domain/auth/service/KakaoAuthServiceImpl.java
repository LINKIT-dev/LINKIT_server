package com.kw.LinkIt.domain.auth.service;

//@Slf4j
//@Service
//@RequiredArgsConstructor
//public class KakaoAuthServiceImpl implements OAuthService {
//
//    private final KakaoFeignClient kakaoFeignClient;
////    private final UserRepository userRepository;
//
////    @Override
////    @Transactional
////    public TokenRes oAuthLogin(OAuthTokenReq oAuthTokenReq) {
////        String accessToken = oAuthTokenReq.getAccessToken();
////
////        KakaoInfo kakaoInfo = getKakaoUserInfo(accessToken);
////
////        String kakaoId = kakaoInfo.getId().toString();
////        String nickname = kakaoInfo.getKakaoAccount().getProfile().getNickname();
////        String email = kakaoInfo.getKakaoAccount().getEmail();
////
////        User user = userRepository.findByOauthIdAndLoginType(kakaoId, LoginType.KAKAO).orElse(null);
////
//////        if (user == null) {
//////            String randomUID = generateRandomUID();
//////            user = userRepository.save()
//////            빌더 패턴 구현
//////        }
//////        return TokenRes.builder()
//////                .accessToken(jwtTokenProvider.createAccessToken(user.getId()));
////    }
//
//    private KakaoInfo getKakaoUserInfo(String accessToken) {
//        try {
//            return kakaoFeignClient.getInfo("bearer " + accessToken);
//        } catch (Exception e) {
//            log.error("error while getting kakao user info: ", e);
//
//            throw new BusinessException(AuthErrorCode.INVALID_KAKAO_TOKEN);
//        }
//    }
//}
