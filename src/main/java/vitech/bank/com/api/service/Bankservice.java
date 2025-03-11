package vitech.bank.com.api.service;

import org.springframework.stereotype.Service;

import vitech.bank.com.api.model.Bankmodel;

@Service
public interface Bankservice  {
	
	    String createBankAccount(Bankmodel bankmodel);


		String depositAmount(String accountNumber, String bankName, Float depositAmount);


		String withdrawAmount(String accountNumber, String bankName, Float withdrawAmount);


		String atmPin(String accountNumber, String bankName, Integer atmPin);
	
}
