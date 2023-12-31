package com.kw.LinkIt.domain.hashtag.controller;

import com.kw.LinkIt.domain.hashtag.dto.request.DeleteHashtagDTO;
import com.kw.LinkIt.domain.hashtag.dto.request.PostHashtagDTO;
import com.kw.LinkIt.domain.hashtag.dto.response.HashtagVO;
import com.kw.LinkIt.domain.hashtag.service.HashtagService;
import com.kw.LinkIt.domain.user.entity.User;
import com.kw.LinkIt.global.common.response.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Hashtag")
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/hashtag")
public class HashtagController {

    private final HashtagService hashtagService;

    @Operation(summary = "[팀 페이지] 해당 팀에 등록된 모든 해시태그 조회")
    @GetMapping("/team-hashtags/{teamId}")
    public ResponseEntity<List<String>> getTeamHashtags(@Parameter(description = "특정 팀에 등록되어 있는 모든 해시태그 조회")
                                                       @PathVariable("teamId") Long teamId) {
        List<String> hashtagNames = hashtagService.findAllHashtagNamesOfTeam(teamId);
        return BaseResponse.ok(hashtagNames);
    }

    @Operation(summary = "[팀 페이지] 유저가 속한 모든 팀의 모든 해시태그 조회")
    @GetMapping("/all-hashtags")
    public ResponseEntity<List<String>> getAllHashtags(@AuthenticationPrincipal User user) {
        List<String> hashtagNames = hashtagService.findAllHashtagNames(user);
        return BaseResponse.ok(hashtagNames);
    }

    @Operation(summary = "[링크 등록 모달] 특정 팀에 새로운 해시태그 생성", description = "'링크 등록' 시 유저가 기존에 존재하던 해시태그 외 새로운 해시태그를 생성했을 경우, 해당 api 로 요청하여 새 해시태그를 등록한다. " +
            "<br> 반환값: 새로 생성된 해시태그 고유 id")
    @PostMapping("")
    public ResponseEntity<Long> postHashtag( @RequestBody @Valid PostHashtagDTO postHashtagDTO) {
        HashtagVO newHashtag = hashtagService.postHashtagByTeam(postHashtagDTO);
        return BaseResponse.ok(newHashtag.hashtagId());
    }

    @Operation(summary = "특정 해시태그를 삭제", description = "'해시태그 고유 id' 를 전송해, 특정 해시태그를 삭제한다.")
    @DeleteMapping("/{hashtagId}")
    public ResponseEntity<String> deleteHashtag(@PathVariable("hashtagId") Long hashtagId) {
        hashtagService.deleteHashtag(new DeleteHashtagDTO(hashtagId));
        return BaseResponse.ok("해시태그 삭제 성공");
    }
}
