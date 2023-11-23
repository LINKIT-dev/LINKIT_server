package com.kw.LinkIt.domain.userTeam.repository;

import com.kw.LinkIt.domain.team.entity.Team;
import com.kw.LinkIt.domain.user.entity.User;
import com.kw.LinkIt.domain.userTeam.entity.UserTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTeamRepository extends JpaRepository<UserTeam, Long> {
    List<UserTeam> findAllByUser(User user);
    List<UserTeam> findAllByTeam(Team team);
}
