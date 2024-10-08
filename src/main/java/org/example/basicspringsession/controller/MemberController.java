package org.example.basicspringsession.controller;

import lombok.RequiredArgsConstructor;
import org.example.basicspringsession.dto.*;
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

    @GetMapping("/members/{memberId}") //멤버 단건 조회
    public ResponseEntity<MemberDetailResponseDto> getMember(@PathVariable Long memberId) { //id를 이용해 맞는 이용자를 찾기
        return ResponseEntity.ok(memberService.getMember(memberId)); //getMember 메서드에 id를 넣어 해당 값 리턴
    }

    @PutMapping("/members/{memberId}") //특정 id에 해당하는 멤버 수정
    public ResponseEntity<MemberUpdateReponseDto> updateMember(@PathVariable Long memberId, @RequestBody MemberUpdateRequestDto requestDto) {//수정하기 위한 id 값과 완료후 보여주기위한? RequestBody
        return ResponseEntity.ok(memberService.updateMember(memberId,requestDto));
    }

    @DeleteMapping("/members/{memberId}") //특정 id에 해당하는 멤버 삭제
    public void deleteMember(@PathVariable Long memberId) {//요청한 id에 맞는 멤버 지우기 위한 PathVariable
        memberService.deleteMember(memberId);
    }
}
