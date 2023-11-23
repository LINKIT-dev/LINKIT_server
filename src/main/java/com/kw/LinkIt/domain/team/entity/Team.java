package com.kw.LinkIt.domain.team.entity;

import com.kw.LinkIt.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long id;

    private String name;

    private String profileImg;

    private Integer capacity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "leader_id")
    private User leader;

    @Builder
    public Team(String name, String profileImg, Integer capacity, User leader) {
        this.name = name;
        this.profileImg = profileImg;
        this.capacity = capacity;
        this.leader = leader;
    }
}
