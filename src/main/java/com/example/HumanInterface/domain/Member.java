package com.example.HumanInterface.domain;

import com.example.HumanInterface.dto.MemberResponseDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Builder
@Getter
@AllArgsConstructor
@Table(name = "member")
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 회원 고유 ID (Primary Key)

    @Column(nullable = false)
    private String name; // 이름

    @Column(nullable = false)
    private int age; // 나이

    @Column(nullable = false)
    private String gender; // 성별

    @Column(nullable = false)
    private int level;  // 레벨테스트 결과

    public MemberResponseDTO of(){
        return MemberResponseDTO.builder()
                .memberId(id)
                .build();
    }


}
