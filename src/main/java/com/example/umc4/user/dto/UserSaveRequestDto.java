package com.example.umc4.user.dto;

import com.example.umc4.board.domain.Board;
import com.example.umc4.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSaveRequestDto {
    private String nickname;

    @Builder
    public UserSaveRequestDto(String nickname){
        this.nickname = nickname;
    }

    public User toEntity() {
        return User.builder()
                .nickname(nickname)
                .build();

    }
}
