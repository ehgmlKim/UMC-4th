package com.example.umc4.board.service;

import com.example.umc4.board.domain.Board;
import com.example.umc4.board.dto.BoardListResponseDto;
import com.example.umc4.board.dto.BoardResponseDto;
import com.example.umc4.board.dto.BoardSaveRequestDto;
import com.example.umc4.board.dto.BoardUpdateRequestDto;
import com.example.umc4.board.repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public String boardSave(BoardSaveRequestDto requestDto) {
        return boardRepository.save(requestDto.toEntity()).getPId() + ": 글이 등록되었습니다.";
    }

    @Transactional
    public String boardUpdate(Long id, BoardUpdateRequestDto requestDto) {
        Board board = boardRepository.findById(id).orElseThrow
                (() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        board.update(requestDto.getTitle(), requestDto.getContent());

        return id + ": 글이 수정되었습니다.";
    }
    @Transactional
    public void boardDelete(Long id){
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
