package com.jc.gymbasicsystem.domain.repository;

import com.jc.gymbasicsystem.domain.entities.PlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends JpaRepository<PlanEntity, String> {}
