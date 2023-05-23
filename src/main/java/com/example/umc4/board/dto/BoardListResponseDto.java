package com.example.umc4.board.dto;

import com.example.umc4.board.domain.Board;
import com.example.umc4.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BoardListResponseDto {

    private String title;
    private String content;
    private User user;

    public BoardListResponseDto(Board board) {
        this.title = board.getTitle();
        this.content = board.getContent();
        this.user = board.getUser();
    }

    public BoardListResponseDto(Optional<Board> board) {
        this.title = board.get().getTitle();
        this.content = board.get().getContent();
        this.user = board.get().getUser();
    }
}
