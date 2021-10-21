package com.sintoburi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sintoburi.entity.AccessTokenEntity;

@Repository
public interface AccessTokenRepository extends JpaRepository<AccessTokenEntity, Long>{

}
