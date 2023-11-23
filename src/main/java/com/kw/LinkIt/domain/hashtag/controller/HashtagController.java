package com.kw.LinkIt.domain.hashtag.controller;

import com.kw.LinkIt.domain.hashtag.dto.request.PostHashtagDTO;
import com.kw.LinkIt.domain.hashtag.dto.response.GetTeamHashtagsVO;
import com.kw.LinkIt.domain.hashtag.dto.response.HashtagVO;
import com.kw.LinkIt.domain.hashtag.service.HashtagService;
import com.kw.LinkIt.global.common.response.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
        List<String> hashtagNames = hashtagService.findAllHashtagNames(teamId);
        return BaseResponse.ok(hashtagNames);
    }

    /**
     * 우선 POST 요청 성공 시 메세지가 반환되도록 구현. 추후 Long타입으로 바꿔야함.
     */
    @Operation(summary = "[링크 등록 모달] 특정 팀에 새로운 해시태그 생성", description = "'링크 등록' 시 유저가 기존에 존재하던 해시태그 외 새로운 해시태그를 생성했을 경우, 해당 api 로 요청하여 새 해시태그를 등록한다. " +
            "<br> 반환값: 새로 생성된 해시태그 고유 id")
    @PostMapping("")
    public ResponseEntity<Long> postHashtag( @ModelAttribute @Valid PostHashtagDTO postHashtagDTO) {
        HashtagVO newHashtag = hashtagService.postHashtagByTeam(postHashtagDTO);
        return BaseResponse.ok(newHashtag.hashtagId());
    }

    @Operation(summary = "특정 해시태그를 삭제", description = "'해시태그 고유 id' 를 전송해, 특정 해시태그를 삭제한다.")
    @DeleteMapping("/{hashtagId}")
    public ResponseEntity<String> deleteHashtag(@PathVariable("hashtagId") Long hashtagId) {
        return BaseResponse.ok("해시태그 삭제 성공");
    }
}
