package backend.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.com.entity.Account;
import backend.com.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;
	
	public Account getAccountDetails(String emailid) {
		return accountRepository.getAccountDetails(emailid);
	}
	
	public String addFunds(Account acc) {
		if(acc.getAmount()<0) {
			return "Amount must be +ve";
		}else if(accountRepository.addFunds(acc.getAccnumber(), acc.getAmount())>0){
			return "Amount added successfully";
		}else {
			return "Amount did' added";
		}
	}
}
