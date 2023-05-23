package com.example.umc4.user.dto;

import com.example.umc4.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserListResponseDto {
    private Long userId;
    private String nickname;

    public UserListResponseDto(User user) {
        this.userId = user.getUserId();
        this.nickname = user.getNickname();

    }


}
