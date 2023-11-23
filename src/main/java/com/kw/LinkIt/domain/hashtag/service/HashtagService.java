package com.kw.LinkIt.domain.hashtag.service;

import com.kw.LinkIt.domain.hashtag.dto.request.DeleteHashtagDTO;
import com.kw.LinkIt.domain.hashtag.dto.request.PostHashtagDTO;
import com.kw.LinkIt.domain.hashtag.dto.response.HashtagVO;
import com.kw.LinkIt.domain.user.entity.User;

import java.util.List;

public interface HashtagService {
    List<String> findAllHashtagNamesOfTeam(long teamId);

    List<String> findAllHashtagNames(User user);

    HashtagVO postHashtagByTeam(PostHashtagDTO postHashtagDTO);

    void deleteHashtag(DeleteHashtagDTO deleteHashtagDTO);

}
