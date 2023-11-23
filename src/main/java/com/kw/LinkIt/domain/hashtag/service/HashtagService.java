package com.kw.LinkIt.domain.hashtag.service;

import com.kw.LinkIt.domain.hashtag.dto.request.PostHashtagDTO;
import com.kw.LinkIt.domain.hashtag.dto.response.GetTeamHashtagsVO;
import com.kw.LinkIt.domain.hashtag.dto.response.HashtagVO;
import java.util.List;

public interface HashtagService {
    List<HashtagVO> findAllHashtag(long teamId);

    HashtagVO postHashtagByTeam(PostHashtagDTO postHashtagDTO);
}
