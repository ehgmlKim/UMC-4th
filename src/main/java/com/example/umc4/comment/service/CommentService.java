package com.example.umc4.comment.service;

import com.example.umc4.board.dto.BoardSaveRequestDto;
import com.example.umc4.comment.domain.Comment;
import com.example.umc4.comment.dto.CommentListResponseDto;
import com.example.umc4.comment.dto.CommentResponseDto;
import com.example.umc4.comment.dto.CommentSaveRequestDto;
import com.example.umc4.comment.dto.CommentUpdateRequestDto;
import com.example.umc4.comment.repository.CommentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    @Transactional
    public String commentSave(CommentSaveRequestDto requestDto) {
        return commentRepository.save(requestDto.toEntity()).getCId() + ": 댓글이 등록되었습니다.";
    }

    @Transactional
    public String commentUpdate(Long cId, CommentUpdateRequestDto requestDto) {
        Comment comment = commentRepository.findById(cId).orElseThrow
                (()-> new IllegalArgumentException("해당 댓글이 없습니다."));
        comment.update(requestDto.getComment());

        return cId + ": 댓글이 수정되었습니다.";
    }

    @Transactional
    public void commentDelete(Long cId) {
        Comment comment = commentRepository.findById(cId)
                .orElseThrow(()->new IllegalArgumentException("해당 댓글이 없습니다."));
        commentRepository.delete(comment);
    }

    public CommentResponseDto findById(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow
                (()->new IllegalArgumentException("해당 댓글이 없습니다."));

        return new CommentResponseDto(comment);
    }

    @Transactional
    public List<CommentListResponseDto> findAllComment() {
        try {
            List<Comment> commentList = commentRepository.findAll();
            List<CommentListResponseDto> responseDtoList = new ArrayList<>();
            for (Comment comment : commentList) {
                responseDtoList.add(
                        new CommentListResponseDto(comment)
                );

            } return responseDtoList;
        }catch (Exception e) {
        }
        return null;
    }

}
