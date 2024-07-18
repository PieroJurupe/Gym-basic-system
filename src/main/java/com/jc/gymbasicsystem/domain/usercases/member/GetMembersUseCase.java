package com.jc.gymbasicsystem.domain.usercases.member;

import com.jc.gymbasicsystem.domain.entities.MemberEntity;
import com.jc.gymbasicsystem.domain.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetMembersUseCase {

    @Autowired
    private MemberRepository memberRepository;

    public GetMembersUseCase(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<MemberEntity> execute() {
        return memberRepository.findAll();
    }
}
