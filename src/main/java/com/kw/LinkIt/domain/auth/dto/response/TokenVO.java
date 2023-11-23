package com.kw.LinkIt.domain.auth.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;



public record TokenVO(String accessToken, String refreshToken) { }
