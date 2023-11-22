package com.kw.LinkIt.domain.hashtag.service;

import com.kw.LinkIt.domain.hashtag.dto.response.HashtagVO;
import com.kw.LinkIt.domain.hashtag.entity.Hashtag;
import com.kw.LinkIt.domain.hashtag.repository.HashtagRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class HashtagServiceImpl implements HashtagService {

    private final HashtagRepository hashtagRepository;

    public List<HashtagVO> findAllHashtag(long teamId) {
        List<Hashtag> allHashTags = hashtagRepository.findAllByTeam(teamId);

        return allHashTags.stream()
                .map(HashtagVO::of)
                .toList();
    }
}
