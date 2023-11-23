package com.kw.LinkIt.domain.linkHashtag.repository;

import com.kw.LinkIt.domain.linkHashtag.entity.LinkHashtag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LinkHashtagRepository extends JpaRepository<LinkHashtag, Long> {
    @Query("select lh from LinkHashtag lh " +
            "join fetch lh.link " +
            "where lh.link.team.id = :teamId " +
                "and lh.hashtag.name = :hashtagName")
    List<LinkHashtag> findAllByTeamIdAndHastagName(Long teamId, String hashtagName);
}
