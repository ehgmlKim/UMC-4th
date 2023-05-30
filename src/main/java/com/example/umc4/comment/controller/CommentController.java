package com.example.umc4.comment.controller;

import com.example.umc4.comment.domain.Comment;
import com.example.umc4.comment.dto.CommentListResponseDto;
import com.example.umc4.comment.dto.CommentSaveRequestDto;
import com.example.umc4.comment.dto.CommentUpdateRequestDto;
import com.example.umc4.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    //특정 글에 달린 댓글 전체 조회
    @GetMapping("/board/post/{id}/comments")
    public List<CommentListResponseDto> getAllComment() {
        return commentService.findAllComment();
    }

    //특정 글에
    // 댓글 등록
    @PostMapping("/board/post/{pId}/comments/post")
    public String commentSave(@RequestBody CommentSaveRequestDto requestDto) {
        return commentService.commentSave(requestDto);
    }

    //댓글 수정
    @PatchMapping("/board/post/{pId}/comments/update/{cId}")
    public String commentUpdate(@PathVariable Long cId, CommentUpdateRequestDto requestDto) {
        return commentService.commentUpdate(cId, requestDto);
    }

    @DeleteMapping("/board/post/{pId}/comments/delete/{cId}")
    public String delete(@PathVariable Long cId) {
        commentService.commentDelete(cId);
        return "댓글이 삭제되었습니다.";
    }
}
