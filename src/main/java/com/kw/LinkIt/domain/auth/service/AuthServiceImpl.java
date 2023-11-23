package com.kw.LinkIt.domain.auth.service;

import com.kw.LinkIt.domain.auth.dto.request.LoginDTO;
import com.kw.LinkIt.domain.auth.dto.request.SignUpDTO;
import com.kw.LinkIt.domain.auth.dto.response.TokenVO;
import com.kw.LinkIt.domain.auth.exception.AuthErrorCode;
import com.kw.LinkIt.domain.user.entity.User;
import com.kw.LinkIt.domain.user.repository.UserRepository;
import com.kw.LinkIt.global.error.exception.BusinessException;
import com.kw.LinkIt.global.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthServiceImpl implements AuthService {

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public void signUp(SignUpDTO signUpDTO) {
        userRepository.save(User.builder()
                .uid(signUpDTO.getUid())
                .password(passwordEncoder.encode(signUpDTO.getPassword()))
                .build());
    }


    @Override
    public TokenVO login(LoginDTO loginDTO) {
        User user = userRepository.findByUid(loginDTO.getUid())
                .orElseThrow(() -> new BusinessException(AuthErrorCode.WRONG_ID));
        if (!passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
            throw new BusinessException(AuthErrorCode.WRONG_PW);
        }

        return new TokenVO(
                jwtTokenProvider.createAccessToken(user.getId()),
                jwtTokenProvider.createRefreshToken(user.getId())
        );
    }

}
