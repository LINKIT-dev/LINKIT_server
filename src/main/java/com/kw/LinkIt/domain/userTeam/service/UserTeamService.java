package com.kw.LinkIt.domain.userTeam.service;

import com.kw.LinkIt.domain.hashtag.repository.HashtagRepository;
import com.kw.LinkIt.domain.team.entity.Team;
import com.kw.LinkIt.domain.user.entity.User;
import com.kw.LinkIt.domain.hashtag.entity.Hashtag;
import com.kw.LinkIt.domain.userTeam.dto.response.GetMyParticipationsVO;
import com.kw.LinkIt.domain.userTeam.dto.response.TeamVO;
import com.kw.LinkIt.domain.userTeam.entity.UserTeam;
import com.kw.LinkIt.domain.userTeam.repository.UserTeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserTeamService {

    private final UserTeamRepository userTeamRepository;
    private final HashtagRepository hashtagRepository;

    public GetMyParticipationsVO getMyParticipations(User user) {
        List<Team> myTeams = userTeamRepository.findAllByUser(user).stream().map(UserTeam::getTeam).collect(Collectors.toList());

        List<TeamVO> teamVOs = myTeams.stream().map(team -> {
            List<String> memberProfileImgs = getMemberProfileImgs(team);
            List<String> top3hashtagNames = getTop3HashtagNames(team);
            int totalHashtagCounts = getTotalHashtagCounts(team);
            return new TeamVO(team.getId(), team.getName(), team.getProfileImg(), memberProfileImgs, top3hashtagNames, totalHashtagCounts);
        }).collect(Collectors.toList());

        return new GetMyParticipationsVO(teamVOs, myTeams.size());
    }

    private List<String> getMemberProfileImgs(Team team) {
        List<User> members = getTeamMembers(team);
        return members.stream().map(User::getProfileImg).collect(Collectors.toList());
    }

    private List<User> getTeamMembers(Team team) {
        return userTeamRepository.findAllByTeam(team)
                .stream()
                .map(UserTeam::getUser)
                .collect(Collectors.toList());
    }

    private List<String> getTop3HashtagNames(Team team) {
        List<Hashtag> top3Hashtags = hashtagRepository.findTop3ByTeamId(team.getId());
        return top3Hashtags.stream().map(Hashtag::getName).collect(Collectors.toList());
    }

    private int getTotalHashtagCounts(Team team) {
        return hashtagRepository.countAllByTeamId(team.getId());
    }
}
