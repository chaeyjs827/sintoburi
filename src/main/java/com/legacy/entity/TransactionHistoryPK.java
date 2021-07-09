package com.legacy.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class TransactionHistoryPK implements Serializable {
	private String transactionSeq;
	private String transactionDate;
}
