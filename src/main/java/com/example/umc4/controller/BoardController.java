package com.example.umc4.controller;

import com.example.umc4.dto.BoardListResponseDto;
import com.example.umc4.dto.BoardResponseDto;
import com.example.umc4.dto.BoardSaveRequestDto;
import com.example.umc4.dto.BoardUpdateRequestDto;
import com.example.umc4.service.BoardService;
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
    public String save(@RequestBody BoardSaveRequestDto requestDto) {
        return boardService.save(requestDto);
    }
    //글 수정
    @PutMapping ("/board/update/{id}")
    public String update(@PathVariable Long id, @RequestBody BoardUpdateRequestDto requestDto) {
        return boardService.update(id, requestDto);
    }
    //글 하나 조회
    @GetMapping("/board/post/{id}")
    public BoardResponseDto findById (@PathVariable Long id) {
        return boardService.findById(id);
    }
    //글 삭제
    @DeleteMapping("/board/delete/{id}")
    public String delete(@PathVariable Long id) {
        boardService.delete(id);
        return id + ": 글이 삭제되었습니다.";
    }
}
