package com.kw.LinkIt.domain.hashtag.service;

import com.kw.LinkIt.domain.hashtag.dto.request.PostHashtagDTO;
import com.kw.LinkIt.domain.hashtag.dto.response.HashtagVO;
import com.kw.LinkIt.domain.hashtag.entity.Hashtag;
import com.kw.LinkIt.domain.hashtag.repository.HashtagRepository;
import com.kw.LinkIt.domain.team.entity.Team;
import com.kw.LinkIt.domain.team.repository.TeamRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class HashtagServiceImpl implements HashtagService {

    private final HashtagRepository hashtagRepository;
    private final TeamRepository teamRepository;

    public List<String> findAllHashtagNames(long teamId) {
        List<Hashtag> allHashTags = hashtagRepository.findAllByTeam(teamId);
        return allHashTags.stream().map(Hashtag::getName).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public HashtagVO postHashtagByTeam (PostHashtagDTO postHashtagDTO) {
        Optional<Team> myTeam = teamRepository.findById(postHashtagDTO.getTeamId());

        Hashtag newHashtag = hashtagRepository.save(Hashtag.builder()
                    .name(postHashtagDTO.getHashtagName())
                    .team(myTeam.orElseThrow())
                    .build());
        return new HashtagVO(newHashtag.getId(), newHashtag.getName());
    }
}
