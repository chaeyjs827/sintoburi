package com.legacy.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(TransactionHistoryPK.class)
public class TransactionHistory{

	@Id
    private String transactionDate;
    
    private String accountNo;
    
    @Id
    private String transactionSeq;
    
    private Integer transactionAmount;
    
    private Integer transactionFee;
    
    private String transactionVoidYN;
    
}
