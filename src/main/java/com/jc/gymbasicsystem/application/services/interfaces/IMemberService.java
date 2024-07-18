package com.jc.gymbasicsystem.application.services.interfaces;

import com.jc.gymbasicsystem.application.dto.member.CreateMemberDto;
import com.jc.gymbasicsystem.domain.entities.MemberEntity;

import java.util.List;
import java.util.Optional;

public interface IMemberService {

        List<MemberEntity> getAllMembers();

        MemberEntity getMemberById(String memberId);

        Optional<MemberEntity> getMemberByDni(String dni);

        MemberEntity createMember(CreateMemberDto createMemberDto);

        MemberEntity updateMember();

        void deleteMember();
}
