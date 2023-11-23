package com.kw.LinkIt.domain.link.service;

import com.kw.LinkIt.domain.link.dto.response.GetTeamLinksVO;
import com.kw.LinkIt.domain.link.dto.response.LinkVO;
import com.kw.LinkIt.domain.link.entity.Link;
import com.kw.LinkIt.domain.link.repository.LinkRepository;
import com.kw.LinkIt.domain.linkHashtag.entity.LinkHashtag;
import com.kw.LinkIt.domain.linkHashtag.repository.LinkHashtagRepository;
import com.kw.LinkIt.domain.team.entity.Team;
import com.kw.LinkIt.domain.team.repository.TeamRepository;
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

    private Team getTeam(Long teamId) {
        return teamRepository.findById(teamId).get();
    }
}
