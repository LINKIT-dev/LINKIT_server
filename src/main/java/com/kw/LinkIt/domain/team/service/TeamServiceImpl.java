package com.kw.LinkIt.domain.team.service;

import com.kw.LinkIt.domain.team.dto.request.CreateTeamDTO;
import com.kw.LinkIt.domain.team.entity.Team;
import com.kw.LinkIt.domain.team.repository.TeamRepository;
import com.kw.LinkIt.domain.user.entity.User;
import com.kw.LinkIt.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    public void createTeam(CreateTeamDTO createTeamDTO, User user) {
        teamRepository.save(Team.builder()
                        .name(createTeamDTO.getName())
                        .profileImg(createTeamDTO.getProfileImgUrl())
                        .capacity(createTeamDTO.getCapacity())
                        .leader(user)
                        .build());
    }

    public Team getTeam(Long teamId) {
        return teamRepository.findById(teamId).orElseThrow();
    }
}
