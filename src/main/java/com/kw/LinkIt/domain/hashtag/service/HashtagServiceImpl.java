package com.kw.LinkIt.domain.hashtag.service;

import com.kw.LinkIt.domain.hashtag.dto.request.DeleteHashtagDTO;
import com.kw.LinkIt.domain.hashtag.dto.request.PostHashtagDTO;
import com.kw.LinkIt.domain.hashtag.dto.response.HashtagVO;
import com.kw.LinkIt.domain.hashtag.entity.Hashtag;
import com.kw.LinkIt.domain.hashtag.repository.HashtagRepository;
import com.kw.LinkIt.domain.linkHashtag.repository.LinkHashtagRepository;
import com.kw.LinkIt.domain.team.entity.Team;
import com.kw.LinkIt.domain.team.repository.TeamRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.kw.LinkIt.domain.user.entity.User;
import com.kw.LinkIt.domain.userTeam.entity.UserTeam;
import com.kw.LinkIt.domain.userTeam.repository.UserTeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class HashtagServiceImpl implements HashtagService {

    private final HashtagRepository hashtagRepository;
    private final TeamRepository teamRepository;
    private final LinkHashtagRepository linkHashtagRepository;
    private final UserTeamRepository userTeamRepository;

    public List<String> findAllHashtagNamesOfTeam(long teamId) {
        List<Hashtag> allHashTags = hashtagRepository.findAllByTeam(teamId);
        return allHashTags.stream().map(Hashtag::getName).collect(Collectors.toList());
    }

    @Override
    public List<String> findAllHashtagNames(User user) {
        // 유저가 속한 모든 팀 불러오기
        List<UserTeam> userTeams = userTeamRepository.findAllByUser(user);
        List<Team> allTeams = userTeams.stream().map(UserTeam::getTeam).collect(Collectors.toList());

        // 각 팀에 속한 hashtagNames 반환
        List<String> allHashtagNames = new ArrayList<>();
        allTeams.forEach(team -> {
            List<String> hashtagNames = findAllHashtagNamesOfTeam(team);
            allHashtagNames.addAll(hashtagNames);
        });
        return allHashtagNames;
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

    @Override
    @Transactional
    public void deleteHashtag(DeleteHashtagDTO deleteHashtagDTO) {
        linkHashtagRepository.deleteAllByHashtag(deleteHashtagDTO.getHashtagId());
        hashtagRepository.deleteById(deleteHashtagDTO.getHashtagId());
    }

    private List<String> findAllHashtagNamesOfTeam(Team team) {
        List<Hashtag> allHashTags = hashtagRepository.findAllByTeam(team.getId());
        return allHashTags.stream().map(Hashtag::getName).collect(Collectors.toList());
    }
}
