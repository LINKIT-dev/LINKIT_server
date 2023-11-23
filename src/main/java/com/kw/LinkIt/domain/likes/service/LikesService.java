package com.kw.LinkIt.domain.likes.service;

import com.kw.LinkIt.domain.likes.entity.Likes;
import com.kw.LinkIt.domain.likes.error.LikesErrorCode;
import com.kw.LinkIt.domain.likes.repository.LikesRepository;
import com.kw.LinkIt.domain.link.entity.Link;
import com.kw.LinkIt.domain.link.repository.LinkRepository;
import com.kw.LinkIt.domain.user.entity.User;
import com.kw.LinkIt.global.error.code.CommonErrorCode;
import com.kw.LinkIt.global.error.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LikesService {

    private final LikesRepository likesRepository;
    private final LinkRepository linkRepository;

    @Transactional
    public void postLike(Long linkId, User user) {
        Link link = getLink(linkId);

        if (likesRepository.existsByUserAndLink(user,link)) {
            throw new BusinessException(LikesErrorCode.LIKES_ALREADY_PRESSED);
        }

        likesRepository.save(Likes.builder()
                .link(link)
                .user(user)
                .build());
    }

    private Link getLink(Long linkId) {
        return linkRepository.findById(linkId).orElseThrow(() -> new BusinessException(CommonErrorCode.NOT_FOUND));
    }
}
