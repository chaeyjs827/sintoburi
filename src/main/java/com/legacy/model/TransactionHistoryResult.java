package com.legacy.model;

public interface TransactionHistoryResult {
	String getTransactionDate();
	String getAccountNo();
	String getTransactionSeq();
	String getTransactionAmount();
	String getTransactionFee();
	String getTransactionVoidYN();
}
