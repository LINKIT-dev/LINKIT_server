package com.kw.LinkIt.domain.user.repository;

import com.kw.LinkIt.domain.user.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUid(String uid);
    Optional<User> findById(Long id);
    Optional<User> findByOauthId(long oauthId);
}
