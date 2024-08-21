package org.example.basicspringsession.service;

import lombok.RequiredArgsConstructor;
import org.example.basicspringsession.dto.MemberDetailResponseDto;
import org.example.basicspringsession.dto.MemberSaveRequestDto;
import org.example.basicspringsession.dto.MemberSaveResponseDto;
import org.example.basicspringsession.dto.MemberSimpleResponseDto;
import org.example.basicspringsession.entity.Member;
import org.example.basicspringsession.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberSaveResponseDto saveMember(MemberSaveRequestDto requestDto) {
        //멤버 등록 메서드
        Member newMember = new Member(requestDto.getName());  //requestDto에서 받은 이름으로 newMember 만든다
        Member savedMember = memberRepository.save(newMember); //newMember를 repository에 저장한다.

        return new MemberSaveResponseDto(savedMember.getId(),savedMember.getName()); //저장된 멤버의 이름을 불러와서 리턴한다.
    }

    public List<MemberSimpleResponseDto> getMembers() {
        //멤버 리스트로 조회하는 메서드
        List<Member> members = memberRepository.findAll(); //멤버 repository에있는 모든것을 불러온다 리스트형식으로

        List<MemberSimpleResponseDto> memberSimpleResponseDtos = new ArrayList<>(); //새로운 리스트를 만든다?
        for (Member member : members) { //for 문으로 반복문을 돌리면서 member를 하나씩 다 불러와 memberSimpleResponseDto에 저장한다.
            memberSimpleResponseDtos.add(new MemberSimpleResponseDto(member.getName())); //MemberSimpleResponseDto는 id와 name이 필요하므로 넣어준다.
        }

        return memberSimpleResponseDtos;
    }

    public MemberDetailResponseDto getMember(Long memberId) {//단건 조회를 위한 메서드
        Member member = memberRepository.findById(memberId).orElseThrow(()-> new NullPointerException("해당하는 멤버가 없습니다."));
        //findById를 이용해 repository 에서 해당 id 불러오기 orElseThrow로 예외 처리
        return new MemberDetailResponseDto(member.getId(), member.getName()); //member의 id와name을 넣어서 리턴
    }
}
