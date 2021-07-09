package com.legacy.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.legacy.entity.Account;
import com.legacy.model.AccountResult;
import com.legacy.model.BranchMigrationResult;
import com.legacy.model.BranchTotalAmountResult;
import com.legacy.model.NonServiceCustomerResult;
import com.legacy.model.TopCustomerResult;

public interface AccountRepository extends JpaRepository<Account, String> {

	@Query(value = "select transaction_year as year,account_name as name, account_no as accNo, a.sumAmt as sumAmt\n" + 
			"from \n" + 
			"   (SELECT YEAR(t.transaction_date) AS transaction_year, t.account_no, acc.account_name, SUM(t.transaction_amount-t.transaction_fee) AS sumAmt\n" + 
			"   FROM account acc\n" + 
			"   JOIN transaction_history t ON acc.account_no = t.account_no\n" + 
			"   WHERE t.transaction_voidYN = 'N'\n" + 
			"   GROUP BY t.account_no, YEAR(t.transaction_date)\n" + 
			"   ) as a ,\n" + 
			"   (SELECT max(sumAmt) as sumAmt\n" + 
			"   FROM (\n" + 
			"      SELECT YEAR(t.transaction_date) AS transaction_year, t.account_no, acc.account_name, SUM(t.transaction_amount-t.transaction_fee) AS sumAmt\n" + 
			"      FROM account acc\n" + 
			"      JOIN transaction_history t ON acc.account_no = t.account_no\n" + 
			"      WHERE t.transaction_voidYN = 'N'\n" + 
			"      GROUP BY t.account_no, YEAR(t.transaction_date)\n" + 
			"      ) as sub\n" + 
			"   group by transaction_year) as b \n" + 
			"where b.sumAmt = a.sumAmt\n" + 
			"order by transaction_year;", nativeQuery = true)
    List<TopCustomerResult> getTopCustomerOfYear(@Param("branchCode") String branchCode);
	
	@Query(value = "select COALESCE(ty, 2018) as year, account.account_no as accNo , account.account_name as name \n" + 
			"from account left join \n" + 
			"   ( select distinct account_no , YEAR(transaction_date) as ty\n" + 
			"   from transaction_history\n" + 
			"   where transaction_voidYN = 'N' AND YEAR(transaction_date) in(2018) ) as b   \n" + 
			"    on account.account_no=b.account_no\n" + 
			"where b.account_no is null\n" + 
			"union   \n" + 
			"select COALESCE(ty, 2019) as year, account.account_no , account.account_name\n" + 
			"from account left join \n" + 
			"   ( select distinct account_no , YEAR(transaction_date) as ty\n" + 
			"   from transaction_history\n" + 
			"   where transaction_voidYN = 'N' AND YEAR(transaction_date) in(2019) ) as b   \n" + 
			"    on account.account_no=b.account_no\n" + 
			"where b.account_no is null    ", nativeQuery = true)
	List<NonServiceCustomerResult> getNonServiceCustomer();

	@Query(value = "select YEAR(t.transaction_date) as year,sum(t.transaction_amount) as sumAmt, a.branch_code as brCode ,b.branch_name as brName\n" + 
			"from transaction_history t , account a , branch b\n" + 
			"where\n" + 
			"   YEAR(t.transaction_date)='2018'\n" + 
			"    and t.account_no=a.account_no\n" + 
			"    and a.branch_code=b.branch_Code\n" + 
			"    and t.transaction_voidYN='N'\n" + 
			"    group by YEAR(t.transaction_date),a.branch_code,b.branch_name\n" + 
			"union \n" + 
			"select YEAR(t.transaction_date) as year,sum(t.transaction_amount) as sum,a.branch_code,b.branch_name\n" + 
			"from transaction_history t , account a , branch b\n" + 
			"where\n" + 
			"   YEAR(t.transaction_date)='2019'\n" + 
			"    and t.account_no=a.account_no\n" + 
			"    and a.branch_code=b.branch_Code\n" + 
			"    and t.transaction_voidYN='N'\n" + 
			"    group by YEAR(t.transaction_date),a.branch_code,b.branch_name\n" + 
			"union\n" + 
			"select YEAR(t.transaction_date) as year,sum(t.transaction_amount) as sumAmt,a.branch_code,b.branch_name\n" + 
			"from transaction_history t , account a , branch b\n" + 
			"where\n" + 
			"   YEAR(t.transaction_date)='2020'\n" + 
			"    and t.account_no=a.account_no\n" + 
			"    and a.branch_code=b.branch_Code\n" + 
			"    and t.transaction_voidYN='N'\n" + 
			"    group by YEAR(t.transaction_date),a.branch_code,b.branch_name\n" + 
			"order by year,sumAmt", nativeQuery = true)
	List<BranchTotalAmountResult> getBranchTotalAmountByYear();
	
	@Query(value = "select branch_name as brName, branch_code as brCode, 0 as sumAmt from branch where branch_name = :branchName", nativeQuery = true)
	List<BranchMigrationResult> getBranchMigration(@Param("branchName") String branchName);

//	List<AccountResult> findByAccountName(String accountName);
	
	List<AccountResult> findByAccountNameAndBranchCodeAndAccountNo(String accountName, String accountNo, String accountCode);

//	Optional<AccountResult> findById(String accountName);
	Optional<Account> findByAccountName(String accountName);
	
}
