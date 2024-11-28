package com.example.HumanInterface.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@Getter

public class MemberResponseDTO {

    @JsonProperty("member_id")
    private Long memberId;


    @Builder
    public MemberResponseDTO(Long memberId) {
        this.memberId = memberId;
    }
}
