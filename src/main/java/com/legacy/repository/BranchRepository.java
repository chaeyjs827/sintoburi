package com.legacy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.legacy.entity.Branch;
import com.legacy.model.AccountResult;

public interface BranchRepository extends JpaRepository<Branch, String> {

    @Query(value = "SELECT account_no as accountNo, account_name as accountName FROM account WHERE branch_code = :branchCode", nativeQuery = true)
    List<AccountResult> getAccountByBranchCode(@Param("branchCode") String branchCode);
    
}
