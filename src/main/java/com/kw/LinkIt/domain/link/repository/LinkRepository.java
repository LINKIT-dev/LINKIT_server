package com.kw.LinkIt.domain.link.repository;

import com.kw.LinkIt.domain.link.entity.Link;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LinkRepository extends JpaRepository<Link,Long> {
    List<Link> findAllByTeamId(Long teamId);
}
