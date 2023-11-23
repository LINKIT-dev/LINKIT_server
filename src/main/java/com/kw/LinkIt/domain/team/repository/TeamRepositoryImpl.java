package com.kw.LinkIt.domain.team.repository;

import static com.kw.LinkIt.domain.team.entity.QTeam.team;

import com.kw.LinkIt.domain.team.entity.Team;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TeamRepositoryImpl implements CustomTeamRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public Team findById(Long teamId) {
        return queryFactory
                .selectFrom(team)
                .where(team.id.eq(teamId))
                .fetchOne();
    }

}
