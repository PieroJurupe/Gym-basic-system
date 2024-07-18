package com.jc.gymbasicsystem.domain.usercases.member;

import com.jc.gymbasicsystem.domain.entities.MemberEntity;
import com.jc.gymbasicsystem.domain.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SearchMemberUseCase {

    @Autowired
    private MemberRepository memberRepository;

    public SearchMemberUseCase(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Optional<MemberEntity> execute(String dni) {
        return memberRepository.findByDni(dni);
    }

}
