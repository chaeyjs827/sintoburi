package com.legacy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.legacy.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
	Optional<MemberEntity> findByEmail(String userEmail);
}
