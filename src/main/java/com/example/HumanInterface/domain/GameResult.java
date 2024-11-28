package com.example.HumanInterface.domain;

import com.example.HumanInterface.dto.GameResultRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class GameResult extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private int cardCount;

    @Enumerated(EnumType.STRING)
    private CardType cardType;

    private Long solvedTime;  //밀리초로 저장 ex) 30000 = 30초

    private String userAnswer;  // ex) 4x4, NUMBER 일 때, "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16" (콤마로 구분)

    private int wrongCount;

    @Builder
    public GameResult(Member member, int cardCount, CardType cardType, Long solvedTime, String userAnswer, int wrongCount) {
        this.member = member;
        this.cardCount = cardCount;
        this.cardType = cardType;
        this.solvedTime = solvedTime;
        this.userAnswer = userAnswer;
        this.wrongCount = wrongCount;
    }

    public GameResultRequestDTO of() {
        return GameResultRequestDTO.builder()
                .cardCount(cardCount)
                .cardType(cardType)
                .solvedTime(solvedTime)
                .userAnswer(userAnswer)
                .wrongCount(wrongCount)
                .build();
    }
}
