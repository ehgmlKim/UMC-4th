package com.example.umc4.comment.dto;

import com.example.umc4.comment.domain.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentListResponseDto {
    private String comment;
    private String writer;

    public CommentListResponseDto(Comment comment) {
        this.comment = comment.getComment();
        this.writer = comment.getWriter();
    }
}
