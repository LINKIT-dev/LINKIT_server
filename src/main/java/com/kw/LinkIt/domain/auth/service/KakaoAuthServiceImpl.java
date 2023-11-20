package com.kw.LinkIt.domain.auth.service;

import com.kw.LinkIt.domain.auth.dto.kakao.KakaoInfo;
import com.kw.LinkIt.domain.auth.dto.request.OAuthTokenReq;
import com.kw.LinkIt.domain.auth.dto.response.TokenRes;
import com.kw.LinkIt.domain.auth.feign.KakaoFeignClient;
import com.kw.LinkIt.global.error.code.ErrorCode;
import com.kw.LinkIt.global.error.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Service
@RequiredArgsConstructor
public class KakaoAuthServiceImpl implements OAuthService {

    private final KakaoFeignClient kakaoFeignClient;
//    private final UserRepository userRepository;

    @Override
    @Transactional
    public TokenRes oAuthLogin(OAuthTokenReq oAuthTokenReq) {
        String accessToken = oAuthTokenReq.getAccessToken();

        KakaoInfo kakaoInfo = getKakaoUserInfo(accessToken);

        String kakaoId = kakaoInfo.getId().toString();
        String nickname = kakaoInfo.getKakaoAccount().getProfile().getNickname();
        String email = kakaoInfo.getKakaoAccount().getEmail();
        // TODO: userRepository 만든 후 구현
//        User user = userRepository.findByOauthIdAndLoginType(kakaoId, LoginType.KAKAO).orElse(null);

//        if (user == null) {
//            String randomUID = generateRandomUID();
//            user = userRepository.save()
//            빌더 패턴 구현
//        }
        return TokenRes.builder()
                .accessToken(jwtTokenProvider.createAccessToken(user.getId()))_;
    }

    private KakaoInfo getKakaoUserInfo(String accessToken) {
        try {
            return kakaoFeignClient.getInfo("bearer " + accessToken);
        } catch (Exception e) {
            log.error("error while getting kakao user info: ", e);
            // TODO : 추후 AuthException으로 교체 예정
//            throw new BusinessException(ErrorCode.INVALID_KAKAO_TOKEN);
        }
    }
}
