package com.jc.gymbasicsystem.domain.usercases.member;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.jc.gymbasicsystem.application.dto.member.CreateMemberDto;
import com.jc.gymbasicsystem.domain.entities.MemberEntity;
import com.jc.gymbasicsystem.domain.repository.MemberRepository;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//import java.time.format.DateTimeFormatter;
import java.util.Date;
import org.joda.time.format.DateTimeFormatter;

@Component
public class CreateMemberUseCase {

    @Autowired
    private MemberRepository memberRepository;

    public CreateMemberUseCase(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public MemberEntity execute(CreateMemberDto createMemberDto) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
        LocalDateTime dateOfBirth = formatter.parseLocalDateTime(createMemberDto.getDateOfBirth());
        MemberEntity member = new MemberEntity();
        member.setFirstName(createMemberDto.getFirstName());
        member.setLastName(createMemberDto.getLastName());
        member.setDni(createMemberDto.getDni());
        member.setPhoneNumber(createMemberDto.getPhoneNumber());
        member.setEmail(createMemberDto.getEmail());
        member.setDateOfBirth(dateOfBirth.toString());
        member.setActive(true);

        return memberRepository.save(member);
    }
}
