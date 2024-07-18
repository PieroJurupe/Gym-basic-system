package com.jc.gymbasicsystem.application.services;

import com.jc.gymbasicsystem.application.dto.member.CreateMemberDto;
import com.jc.gymbasicsystem.application.services.interfaces.IMemberService;
import com.jc.gymbasicsystem.domain.entities.MemberEntity;
import com.jc.gymbasicsystem.domain.usercases.member.CreateMemberUseCase;
import com.jc.gymbasicsystem.domain.usercases.member.GetMembersUseCase;
import com.jc.gymbasicsystem.domain.usercases.member.SearchMemberUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService implements IMemberService {

    @Autowired
    private CreateMemberUseCase createMemberUseCase;

    @Autowired
    private GetMembersUseCase getMembersUseCase;

    @Autowired
    private SearchMemberUseCase searchMemberUseCase;

    @Override
    public List<MemberEntity> getAllMembers() {
        return getMembersUseCase.execute();
    }

    @Override
    public MemberEntity getMemberById(String memberId) {
        return null;
    }

    @Override
    public Optional<MemberEntity> getMemberByDni(String dni) {
        return searchMemberUseCase.execute(dni);
    }

    @Override
    public MemberEntity createMember(
            CreateMemberDto createMemberDto
    ) {
        return createMemberUseCase.execute(createMemberDto);
    }

    @Override
    public MemberEntity updateMember() {
        return null;
    }

    @Override
    public void deleteMember() {

    }
}
