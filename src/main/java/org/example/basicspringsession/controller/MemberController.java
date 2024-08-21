package org.example.basicspringsession.controller;

import lombok.RequiredArgsConstructor;
import org.example.basicspringsession.dto.MemberSaveRequestDto;
import org.example.basicspringsession.dto.MemberSaveResponseDto;
import org.example.basicspringsession.dto.MemberSimpleResponseDto;
import org.example.basicspringsession.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private MemberService memberService;

    @PostMapping("/members") //멤버 등록
    public ResponseEntity<MemberSaveResponseDto> saveMember(@RequestBody MemberSaveRequestDto requestDto){
        return ResponseEntity.ok(memberService.saveMember(requestDto)); //memeberService의 saveMember 메서드 불러옴
        //MemberSaveRequestDto 에 따라 name 저장?
    }

    @GetMapping("/members")
    public ResponseEntity<List<MemberSimpleResponseDto>> getMembers() {
        // 조회하는 컨트롤러 memberService에 조회하는 메서드를 불러와 리턴해준다.
        return ResponseEntity.ok(memberService.getMembers());
    }

}
