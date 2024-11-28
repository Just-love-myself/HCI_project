package com.example.HumanInterface.dto;


import com.example.HumanInterface.domain.Member;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class MemberRequestDTO {
    // 모든 요소 필수 입력 값.

    @NotBlank(message = "이름은 필수 입력값입니다.")
    private String name;

    @NotNull(message = "나이는 필수 입력값입니다.")
    private Integer age;

    @NotBlank(message = "성별은 필수 입력값입니다.")
    private String gender;

    @NotNull(message = "레벨은 필수 입력값입니다.")
    private Integer level;


    @Builder
    public Member toEntity() {
        return Member.builder()
                .name(name)
                .age(age)
                .gender(gender)
                .level(level)
                .build();
    }
}
