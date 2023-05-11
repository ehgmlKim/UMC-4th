package com.example.umc4.dto;

import com.example.umc4.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.annotation.processing.Generated;
import java.util.Optional;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BoardListResponseDto {

    private String title;
    private String content;
    private Long userId;

    public BoardListResponseDto(Board board) {
        this.title = board.getTitle();
        this.content = board.getContent();
        this.userId = board.getUserId();
    }

    public BoardListResponseDto(Optional<Board> board) {
        this.title = board.get().getTitle();
        this.content = board.get().getContent();
        this.userId = board.get().getUserId();
    }
}
