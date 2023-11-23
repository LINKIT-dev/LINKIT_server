package com.kw.LinkIt.domain.hashtag.repository;

import com.kw.LinkIt.domain.hashtag.entity.Hashtag;
import java.util.List;
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

}
