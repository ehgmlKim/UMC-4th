package com.example.umc4.service;

import com.example.umc4.domain.Board;
import com.example.umc4.dto.BoardListResponseDto;
import com.example.umc4.dto.BoardResponseDto;
import com.example.umc4.dto.BoardSaveRequestDto;
import com.example.umc4.dto.BoardUpdateRequestDto;
import com.example.umc4.repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedTransferQueue;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public String save(BoardSaveRequestDto requestDto) {
        return boardRepository.save(requestDto.toEntity()).getId() + ": 글이 등록되었습니다.";
    }

    @Transactional
    public String update(Long id, BoardUpdateRequestDto requestDto) {
        Board board = boardRepository.findById(id).orElseThrow
                (() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        board.update(requestDto.getTitle(), requestDto.getContent());

        return id + ": 글이 수정되었습니다.";
    }
    @Transactional
    public void delete(Long id){
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id =" + id));
        //존재하는 글인지 확인하기 위해 조회 후 삭제
        boardRepository.delete(board);
    }

    public BoardResponseDto findById(Long id) {
        Board entity = boardRepository.findById(id).orElseThrow
                (() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        return new BoardResponseDto(entity);
    }

    @Transactional
    public List<BoardListResponseDto> findAllBoard() {
        try {
            List<Board> boardList = boardRepository.findAll();
            List<BoardListResponseDto> responseDtoList = new ArrayList<>();
            for (Board board : boardList) {
                responseDtoList.add(
                        new BoardListResponseDto(board)
                );
            }
            return responseDtoList;
        } catch (Exception e) {
        }
        return null;
    }
}
