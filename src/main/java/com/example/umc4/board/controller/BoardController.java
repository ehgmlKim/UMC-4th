package com.example.umc4.board.controller;

import com.example.umc4.board.dto.BoardListResponseDto;
import com.example.umc4.board.dto.BoardResponseDto;
import com.example.umc4.board.dto.BoardSaveRequestDto;
import com.example.umc4.board.dto.BoardUpdateRequestDto;
import com.example.umc4.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    //전체 글 조회
    @GetMapping("/board/posts")
    public List<BoardListResponseDto> getAllBoard() {

        return boardService.findAllBoard();
    }
    //글 등록
    @PostMapping("/board/post")
    public String boardSave(@RequestBody BoardSaveRequestDto requestDto) {
        return boardService.boardSave(requestDto);
    }
    //글 수정
    @PutMapping ("/board/update/{id}")
    public String boardUpdate(@PathVariable Long id, @RequestBody BoardUpdateRequestDto requestDto) {
        return boardService.boardUpdate(id, requestDto);
    }
    //글 하나 조회
    @GetMapping("/board/post/{id}")
    public BoardResponseDto findById (@PathVariable Long id) {

        return boardService.findById(id);
    }
    //글 삭제
    @DeleteMapping("/board/delete/{id}")
    public String delete(@PathVariable Long id) {
        boardService.boardDelete(id);
        return id + ": 글이 삭제되었습니다.";
    }
}
