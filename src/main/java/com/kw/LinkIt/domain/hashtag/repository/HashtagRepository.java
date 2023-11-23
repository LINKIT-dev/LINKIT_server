package com.kw.LinkIt.domain.hashtag.repository;

import com.kw.LinkIt.domain.hashtag.entity.Hashtag;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HashtagRepository extends JpaRepository<Hashtag, Long> {

    @Query(value =
            "select ht from Hashtag ht "
                + "join fetch ht.team "
                + "where ht.team.id = :teamId"
    )
    List<Hashtag> findAllByTeam(@Param("teamId") Long teamId);

    Boolean existsByNameAndTeamId(String hashtagName, Long teamId);

    Optional<Hashtag> findByNameAndTeamId(String hashtagName, Long teamId);

    List<Hashtag> findTop3ByTeamId(Long teamId);

    int countAllByTeamId(Long teamId);
}
