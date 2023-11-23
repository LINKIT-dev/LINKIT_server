package com.kw.LinkIt.domain.team.service;

import com.kw.LinkIt.domain.team.dto.request.CreateTeamDTO;
import com.kw.LinkIt.domain.team.entity.Team;
import com.kw.LinkIt.domain.user.entity.User;

public interface TeamService {
    void createTeam(CreateTeamDTO createTeamDTO, User user);

    Team getTeam(Long teamId);
}
