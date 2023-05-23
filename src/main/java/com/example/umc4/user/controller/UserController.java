package com.example.umc4.user.controller;

import com.example.umc4.user.dto.UserListResponseDto;
import com.example.umc4.user.dto.UserResponseDto;
import com.example.umc4.user.dto.UserSaveRequestDto;
import com.example.umc4.user.dto.UserUpdateRequestDto;
import com.example.umc4.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //전체 회원 조회
    @GetMapping("/users")
    public List<UserListResponseDto> getAllUser() {
        return userService.findAllUser();
    }
    //회원 등록
    @PostMapping("/users/join")
    public String userSave(@RequestBody UserSaveRequestDto requestDto) {

        return userService.userSave(requestDto);
    }
    //회원 정보 수정
    @PutMapping("/users/update/{userId}")
    public String userUpdate(@PathVariable Long userId, @RequestBody UserUpdateRequestDto requestDto) {
        return userService.userUpdate(userId, requestDto);
    }
    //특정 회원 조회
    @GetMapping("/users/{userId}")
    public UserResponseDto findById(@PathVariable Long userId) {
        return userService.findById(userId);
    }
    //회원 삭제
    @DeleteMapping("/users/delete/{userId}")
    public String userDelete(@PathVariable Long userId) {
        userService.userDelete(userId);
        return userId + "회원이 퇄퇴되었습니다." ;
    }
}
