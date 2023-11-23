package com.kw.LinkIt.domain.hashtag.service;

import com.kw.LinkIt.domain.hashtag.dto.request.DeleteHashtagDTO;
import com.kw.LinkIt.domain.hashtag.dto.request.PostHashtagDTO;
import com.kw.LinkIt.domain.hashtag.dto.response.HashtagVO;
import java.util.List;

public interface HashtagService {
    List<String> findAllHashtagNames(long teamId);

    HashtagVO postHashtagByTeam(PostHashtagDTO postHashtagDTO);

    void deleteHashtag(DeleteHashtagDTO deleteHashtagDTO);

}
