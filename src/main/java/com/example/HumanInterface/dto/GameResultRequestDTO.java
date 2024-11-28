package com.example.HumanInterface.dto;

import com.example.HumanInterface.domain.CardType;
import com.example.HumanInterface.domain.GameResult;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GameResultRequestDTO {
    @JsonProperty("card_count")
    private int cardCount;

    @JsonProperty("card_type")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private CardType cardType;

    @JsonProperty("solved_time")
    private Long solvedTime;

    @JsonProperty("user_answer")
    private String userAnswer;

    @JsonProperty("wrong_count")
    private int wrongCount;

    public GameResult toEntity() {
        return GameResult.builder()
                .cardCount(cardCount)
                .cardType(cardType)
                .solvedTime(solvedTime)
                .userAnswer(userAnswer)
                .wrongCount(wrongCount)
                .build();
    }

    @Builder
    public GameResultRequestDTO (int cardCount, CardType cardType, Long solvedTime, String userAnswer, int wrongCount) {
        this.cardCount = cardCount;
        this.cardType = cardType;
        this.solvedTime = solvedTime;
        this.userAnswer = userAnswer;
        this.wrongCount = wrongCount;
    }
}
