package com.kw.LinkIt.domain.link.repository;

import com.kw.LinkIt.domain.link.entity.Link;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LinkRepository extends JpaRepository<Link,Long> {
    List<Link> findAllByTeamId(Long teamId);
    Optional<Link> findById(Long linkId);
    boolean existsById(Long linkId);
}
