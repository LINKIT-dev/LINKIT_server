package com.kw.LinkIt.domain.team.repository;

import com.kw.LinkIt.domain.hashtag.entity.Hashtag;
import com.kw.LinkIt.domain.team.entity.Team;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;

public interface CustomTeamRepository {
    Team findById(Long teamId);
}
