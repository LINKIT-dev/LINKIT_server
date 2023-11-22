package com.kw.LinkIt.domain.likes.controller;

import com.kw.LinkIt.global.common.response.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Likes")
@RestController
@RequiredArgsConstructor
@RequestMapping("/likes")
public class LikesController {

    @Operation(summary = "링크에 좋아요 누르기")
    @PostMapping("/{linkId}")
    public ResponseEntity<String> postLike(@PathVariable("linkId") Long linkId) {
        return BaseResponse.ok("좋아요 누르기 완료");
    }

    @Operation(summary = "링크에 좋아요 취소")
    @DeleteMapping("/{linkId}")
    public ResponseEntity<String> deleteLike(@PathVariable("linkId") Long linkId) {
        return BaseResponse.ok("좋아요 취소 완료");
    }
}
