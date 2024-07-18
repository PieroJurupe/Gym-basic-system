package com.jc.gymbasicsystem.interfaces.controllers;

import com.jc.gymbasicsystem.application.dto.member.CreateMemberDto;
import com.jc.gymbasicsystem.application.services.MemberService;
import com.jc.gymbasicsystem.domain.entities.MemberEntity;
import jakarta.validation.Valid;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping()
    public ResponseEntity<List<MemberEntity>> getMembers() {
        return ResponseEntity.ok(memberService.getAllMembers());
    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<MemberEntity> getMember(@PathVariable String dni) {

        Optional<MemberEntity> member = memberService.getMemberByDni(dni);
        return member.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<MemberEntity> createMember(
            @RequestBody @Valid CreateMemberDto createMemberDto
    ) {
        return ResponseEntity.ok(memberService.createMember(createMemberDto));
    }


}
