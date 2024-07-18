package com.jc.gymbasicsystem.domain.repository;

import com.jc.gymbasicsystem.domain.entities.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, String> {
    Optional<MemberEntity> findByDni(String dni);
}
