package com.kw.LinkIt.domain.hashtag.repository;

import com.kw.LinkIt.domain.hashtag.dto.request.PostHashtagDTO;
import com.kw.LinkIt.domain.hashtag.entity.Hashtag;
import com.kw.LinkIt.domain.hashtag.entity.QHashtag;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.kw.LinkIt.domain.hashtag.entity.QHashtag.hashtag;
import static com.kw.LinkIt.domain.team.entity.QTeam.team;

@Repository
@RequiredArgsConstructor
public class HashtagRepositoryImpl implements CustomHashtagRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Hashtag> findAllByTeam(Long teamId) {
        return queryFactory
                .selectFrom(hashtag)
                .join(hashtag.team, team).fetchJoin()
                .where(hashtag.team.id.eq(teamId))
                .stream()
                .toList();
    }
}
