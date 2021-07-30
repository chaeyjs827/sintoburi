package com.sintoburi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sintoburi.entity.ApiReqResLogEntity;

public interface ApiReqResLogRepository extends JpaRepository<ApiReqResLogEntity, Long> {
//	Optional<ApiReqResLogEntity> findByApiName(String apiName);
}
