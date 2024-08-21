package org.example.basicspringsession.repository;

import org.example.basicspringsession.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
