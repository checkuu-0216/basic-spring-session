package org.example.basicspringsession.dto;

import lombok.Getter;

@Getter
public class MemberUpdateReponseDto {

    private final Long id;
    private final String name;

    public MemberUpdateReponseDto(Long id, String name){
        this.id = id;
        this.name = name;
    }
}
