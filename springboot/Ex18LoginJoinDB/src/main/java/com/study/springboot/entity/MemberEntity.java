package com.study.springboot.entity;

import com.study.springboot.dto.MemberJoinDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "member")  // name : table 이름
@Getter
// @Setter는 별도로 update 커스텀 메소드로 만든다.
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_pw")
    private String userPw;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_role")
    private String userRole;

    @Column(name = "join_date")
    //@DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate joinDate;

    // Entity를 SaveDto로 바꾸기
    public MemberJoinDto toSaveDto() {
        return MemberJoinDto.builder()
                .id(id)
                .userId(userId)
                .userPw(userPw)
                .userName(userName)
                .userRole(userRole)
                .joinDate(joinDate)
                .build();
    }
}
