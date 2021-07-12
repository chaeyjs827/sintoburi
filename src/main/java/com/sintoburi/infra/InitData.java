package com.sintoburi.infra;

import org.springframework.stereotype.Component;

@Component
public class InitData {
//
//    @Autowired
//    private AccountRepository accountRepository;
//
//    @Autowired
//    private BranchRepository branchRepository;
//    
//    @Autowired
//    private TransactionHistoryRepository transactionRepository;
//    
//    @Autowired
//    private MemberRepository memberRepository;
//    
//    @PostConstruct
//    private void initAccount() throws IOException {
//        if (accountRepository.count() == 0) {
//            Resource resource = new ClassPathResource("h2-sample/account_info.csv");
//            List<Account> accountList = Files.readAllLines(resource.getFile().toPath(), StandardCharsets.UTF_8)
//                    .stream().skip(1).map(line -> {
//                        String[] split = line.split(",");
//                        return Account.builder().accountNo(split[0]).accountName(split[1]).branchCode(split[2])
//                                .build();
//                    }).collect(Collectors.toList());
//            accountRepository.saveAll(accountList);
//        }
//    }
//    
//    @PostConstruct
//    private void initBranch() throws IOException {
//    	if(branchRepository.count() == 0) {
//    		Resource resource = new ClassPathResource("h2-sample/branch_info.csv");
//    		List<Branch> branchList = Files.readAllLines(resource.getFile().toPath(), StandardCharsets.UTF_8)
//                    .stream().skip(1).map(line -> {
//                        String[] split = line.split(",");
//                        return Branch.builder().branchCode(split[0]).branchName(split[1]).build();
//                    }).collect(Collectors.toList());
//    		branchRepository.saveAll(branchList);
//    	}
//    }
//    
//    @PostConstruct
//    private void initTransactionHistory() throws IOException {
//    	if(transactionRepository.count() == 0) {
//    		Resource resource = new ClassPathResource("h2-sample/transaction_history.csv");
//    		List<TransactionHistory> transactionList = Files.readAllLines(resource.getFile().toPath(), StandardCharsets.UTF_8)
//                    .stream().skip(1).map(line -> {
//                        String[] split = line.split(",");
//                        return TransactionHistory.builder().transactionDate(split[0]).accountNo(split[1]).transactionSeq(split[2])
//                        		.transactionAmount(Integer.parseInt(split[3])).transactionFee(Integer.parseInt(split[4])).transactionVoidYN(split[5]).build();
//                    }).collect(Collectors.toList());
//    		transactionRepository.saveAll(transactionList);
//    	}
//    }
//    
//    @PostConstruct
//    private void initMember() throws IOException {
//    	if(memberRepository.count() == 0) {
//    		Resource resource = new ClassPathResource("h2-sample/member.csv");
//    		List<MemberEntity> memberList = Files.readAllLines(resource.getFile().toPath(), StandardCharsets.UTF_8)
//    				.stream().skip(1).map(line -> {
//    					String[] split = line.split(",");
//    					return MemberEntity.builder().id(Long.parseLong(split[0])).email(split[1]).password(split[2]).build();
//    				}).collect(Collectors.toList());
//    		memberRepository.saveAll(memberList);
//    	}
//    }
}
