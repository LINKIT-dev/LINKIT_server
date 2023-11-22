package com.kw.LinkIt.domain.link.controller;

import com.kw.LinkIt.domain.link.dto.request.PostLinkDTO;
import com.kw.LinkIt.domain.link.dto.request.UpdateLinkDTO;
import com.kw.LinkIt.domain.link.dto.response.GetTeamLinksVO;
import com.kw.LinkIt.global.common.response.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Link")
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/link")
public class LinkController {

    @Operation(summary = "[팀 페이지] 해당 팀에 등록된 모든 링크 조회")
    @GetMapping("/team-links")
    public ResponseEntity<GetTeamLinksVO> getTeamLinks(@Parameter(description = "특정 해시태그에 대해 검색하고 싶을 경우 해시태그 고유id 입력 (입력하지 않을 경우, 전체 링크 조회)")
                                                           @RequestParam(required = false) Long hashtagId) {
        return BaseResponse.ok(GetTeamLinksVO.mock());
    }

    @Operation(summary = "링크 등록", description = "특정 팀에 링크를 등록합니다.")
    @PostMapping()
    public ResponseEntity<String> postLink(@ModelAttribute @Valid PostLinkDTO postLinkDTO) {
        return BaseResponse.ok("링크 등록 완료");
    }

    @Operation(summary = "링크 수정", description = "링크를 수정합니다.")
    @PutMapping("/{linkId}")
    public ResponseEntity<String> updateLink(@PathVariable("linkId") Long linkId, @ModelAttribute @Valid UpdateLinkDTO updateLinkDTO) {
        return BaseResponse.ok("링크 수정 완료");
    }

    @Operation(summary = "링크 삭제", description = "링크를 삭제합니다.")
    @DeleteMapping("/{linkId}")
    public ResponseEntity<String> deleteLink(@PathVariable("linkId") Long linkId) {
        return BaseResponse.ok("링크 삭제 완료");
    }
}
