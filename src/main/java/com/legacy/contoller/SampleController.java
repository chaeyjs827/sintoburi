package com.legacy.contoller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.legacy.entity.Account;
import com.legacy.model.AccountResult;
import com.legacy.model.BranchMigrationResult;
import com.legacy.model.BranchTotalAmountResult;
import com.legacy.model.NonServiceCustomerResult;
import com.legacy.model.TopCustomerResult;
import com.legacy.service.AccountService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Sample")
@RestController
@RequestMapping("/api/")
public class SampleController {
    @Autowired
    private AccountService accountService;

    @ApiOperation(value = "first")
    @GetMapping(value = "/first")
    @ResponseBody
    public List<TopCustomerResult> getTopCustomerOfYear(String branchCode) {
    	List<TopCustomerResult> list = accountService.getTopCustomerOfYear(branchCode);
        return list;
    }

    @ApiOperation(value = "second")
    @GetMapping(value = "/second")
    @ResponseBody
    public List<NonServiceCustomerResult> getNonServiceCustomer() {
    	List<NonServiceCustomerResult> list = accountService.getNonServiceCustomer();
    	return list;
    }
    
    
    @ApiOperation(value = "third")
    @GetMapping(value = "/third")
    public List<BranchTotalAmountResult> getThird() {
    	List<BranchTotalAmountResult> list = accountService.getBranchTotalAmountByYear();
    	return list;
    }
   
    
    @ApiOperation(value = "fourth")
    @GetMapping(value = "/fourth")
    public <T> List<BranchMigrationResult> getFourth(@RequestParam("brName") String branchName) {
    	List<BranchMigrationResult> list = accountService.getBranchMigration(branchName);
    	if(list.size() == 0) {
    		
    	}
    	return list;
    }
    
//    @ApiOperation(value = "findByAccountName")
//    @GetMapping(value = "/findByAccountName")
//    public <T> List<AccountResult> findByAccountName(@RequestParam("accountName") String accountName) {
//    	List<AccountResult> list = accountService.findByAccountName(accountName);
//    	if(list.size() == 0) {
//    		
//    	}
//    	return list;
//    }
    
    @ApiOperation(value = "findAllbyAllCondition")
    @GetMapping(value = "/findAllbyAllCondition")
//    String accountName, String accountNo, String accountCode    
    public <T> List<AccountResult> findByAccountName(@RequestParam("accountName") String accountName,
										    		@RequestParam("accountNo") String accountNo,
										    		@RequestParam("branchCode") String branchCode) {
    	List<AccountResult> list = accountService.findByAccountNameAndBranchCodeAndAccountNo(accountName, accountNo ,branchCode );
    	if(list.size() == 0) {
    		
    	}
    	return list;
    }
    
    @ApiOperation(value = "testFindAllInAccount")
    @GetMapping(value = "/testFindAllInAccount")
    public Optional<Account> testFindAllInAccount(@RequestParam("accountName") String accountName) {
    	Optional<Account> result = accountService.testFindAllInAccount(accountName);
    	return result;
    }
    
    
}
