package com.kw.LinkIt.domain.link.service;

import com.kw.LinkIt.domain.hashtag.entity.Hashtag;
import com.kw.LinkIt.domain.hashtag.repository.HashtagRepository;
import com.kw.LinkIt.domain.link.dto.request.PostLinkDTO;
import com.kw.LinkIt.domain.link.dto.response.GetTeamLinksVO;
import com.kw.LinkIt.domain.link.dto.response.LinkVO;
import com.kw.LinkIt.domain.link.entity.Link;
import com.kw.LinkIt.domain.link.repository.LinkRepository;
import com.kw.LinkIt.domain.linkHashtag.entity.LinkHashtag;
import com.kw.LinkIt.domain.linkHashtag.repository.LinkHashtagRepository;
import com.kw.LinkIt.domain.team.entity.Team;
import com.kw.LinkIt.domain.team.repository.TeamRepository;
import com.kw.LinkIt.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LinkService {

    private final LinkRepository linkRepository;
    private final LinkHashtagRepository linkHashtagRepository;
    private final TeamRepository teamRepository;
    private final HashtagRepository hashtagRepository;

    public GetTeamLinksVO getTeamLinks(Long teamId, String hashtagName) {
        Team team = getTeam(teamId);

        if (hashtagName == null) {
            List<Link> links = linkRepository.findAllByTeamId(teamId);
            return new GetTeamLinksVO(team.getName(), LinkVO.ofList(links), links.size());
        }

        List<LinkHashtag> linkHashtags = linkHashtagRepository.findAllByTeamIdAndHastagName(teamId, hashtagName);
        List<Link> links = linkHashtags.stream().map(LinkHashtag::getLink).collect(Collectors.toList());
        return new GetTeamLinksVO(team.getName(), LinkVO.ofList(links), links.size());
    }

    @Transactional
    public void postLink(PostLinkDTO postLinkDTO, User user) {
        Team team = getTeam(postLinkDTO.getTeamId());

        // hashtag 디비를 찾아서, 해시태그가 새롭게 추가되는 해시태그라면 -> 생성 후 hashtag entity get / 새롭지 않은 해시태그라면 -> hashtag entity 반환
        List<Hashtag> hashtagsOfLink = getHashtagsOfLink(postLinkDTO.getHashtagNames(), team);

        // link 엔티티 생성
        Link createdLink = linkRepository.save(postLinkDTO.toEntity(user,team));

        // link-hashtag 관계 매핑 저장
        hashtagsOfLink.forEach(hashtag -> {
            linkHashtagRepository.save(LinkHashtag.builder()
                    .link(createdLink)
                    .hashtag(hashtag)
                    .build());
        });
    }

    private Team getTeam(Long teamId) {
        return teamRepository.findById(teamId).get();
    }

    private List<Hashtag> getHashtagsOfLink(List<String> hashtagNames, Team team) {
        return hashtagNames.stream().map(hashtagName -> {
            if (hashtagRepository.existsByNameAndTeamId(hashtagName,team.getId())) {
                return hashtagRepository.findByNameAndTeamId(hashtagName,team.getId()).get();
            }
            return hashtagRepository.save(Hashtag.builder()
                    .name(hashtagName)
                    .team(team)
                    .build());
        }).collect(Collectors.toList());
    }
}
