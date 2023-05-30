package com.example.umc4.comment.dto;

import com.example.umc4.comment.domain.Comment;
import lombok.Getter;

@Getter
public class CommentResponseDto {
    private Long cId;
    private String comment;
    private String writer;

    public CommentResponseDto(Comment entity) {
        this.cId = entity.getCId();
        this.comment = entity.getComment();
        this.writer = entity.getWriter();
    }
}
