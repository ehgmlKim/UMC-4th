package com.example.umc4.board.dto;

import com.example.umc4.board.domain.Board;
import com.example.umc4.user.domain.User;
import lombok.Getter;

@Getter
public class BoardResponseDto {
    private Long id;
    private String title;
    private String content;
    private User userId;

    public BoardResponseDto(Board entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.userId = entity.getUser();
    }
}
