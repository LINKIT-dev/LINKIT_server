package com.kw.LinkIt.domain.hashtag.repository;

import com.kw.LinkIt.domain.hashtag.dto.request.PostHashtagDTO;
import com.kw.LinkIt.domain.hashtag.entity.Hashtag;
import java.util.List;
import org.springframework.data.repository.query.Param;

public interface CustomHashtagRepository {
    List<Hashtag> findAllByTeam(Long teamId);

}
