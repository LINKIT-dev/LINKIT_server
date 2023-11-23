package com.kw.LinkIt.domain.likes.repository;

import com.kw.LinkIt.domain.likes.entity.Likes;
import com.kw.LinkIt.domain.link.entity.Link;
import com.kw.LinkIt.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikesRepository extends JpaRepository<Likes, Long> {
    boolean existsByUserAndLink(User user, Link link);
}
