package com.sintoburi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sintoburi.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
	Optional<MemberEntity> findByUsername(String username);
}
