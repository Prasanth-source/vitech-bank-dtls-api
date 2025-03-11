package vitech.bank.com.api.serviceIMPL;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vitech.bank.com.api.Repo.BankRepo;
import vitech.bank.com.api.model.Bankmodel;
import vitech.bank.com.api.service.Bankservice;

@Service
public class BankserviceIMPL implements Bankservice {

	@Autowired
	public BankRepo bankrepo;
	
	// new method for inserting data
	
	@Override
	public String createBankAccount(Bankmodel bank) {
	    System.out.println("save bankdata : Start");

	    // Check if an account with the same account number and bank name already exists
	    Optional<Bankmodel> existingBank = bankrepo.findByAccountNumberAndBankName(bank.getAccountNumber(), bank.getBankName());
	    
	    if (existingBank.isPresent()) {
	    	
	        // If an account exists, return an appropriate response
	        return "Account " + bank.getAccountNumber() + " already exists in the bank please create new account " + bank.getBankName();
	    }
	    
	    // Save the new bank data
	    bankrepo.save(bank);
	    return "Customer details saved successfully. Account number: " + bank.getAccountNumber();
	}

//	@Override
//	public String depositAmount(Bankmodel bank) {
//		Optional<Bankmodel> existingBank = java.util.Optional.empty();
//		
//		Bankmodel bankValues = existingBank.get();
//    	Float depositeAmountOld = bankValues.getDepositeAmount() ;
//        Float dipositeAmmountNew = bankValues.getDepositeAmount();
//    	bank.setDepositeAmount(depositeAmountOld + dipositeAmmountNew);
//        return "Amount deposit successfully done for the Account Number " + bank.getAccountNumber();
//    }
	@Override
    public String depositAmount(String accountNumber, String bankName, Float depositAmount) {
        // Fetch the account using accountNumber and bankName
        Optional<Bankmodel> optionalBank = bankrepo.findByAccountNumberAndBankName(accountNumber, bankName);
        
        Float currentBalance;
        // If account does not exist, return an error message
        if (!optionalBank.isPresent()) {
            return "Account " + accountNumber + " does not exist. Enter valid details.";
        } else {
        	// Fetch the current account data
            Bankmodel bankModel = optionalBank.get();

            // Add the deposit amount to the current balance
            currentBalance = bankModel.getDepositeAmount();
            if (currentBalance == null) {
                currentBalance = 0f; // If the account has no balance yet, initialize it to 0
            }

            // Add the deposit to the balance
            bankModel.setDepositeAmount(currentBalance + depositAmount);

            // Save the updated account information to the database
            bankrepo.save(bankModel);

        }
        
        
        return "Amount deposited successfully. New balance for account " + accountNumber + ": " + (currentBalance + depositAmount);
    }
	
	@Override
    public String withdrawAmount(String accountNumber, String bankName, Float withdrawAmount) {
        // Fetch the account using accountNumber and bankName
        Optional<Bankmodel> optionalBank = bankrepo.findByAccountNumberAndBankName(accountNumber, bankName);
        
        Float currentBalance;

        // If account does not exist, return an error message
        if (!optionalBank.isPresent()) {
            return "Account " + accountNumber + " does not exist. Enter valid details.";
        } else {
        	// Fetch the current account data
            Bankmodel bankModel = optionalBank.get();

            // Add the deposit amount to the current balance
            currentBalance = bankModel.getDepositeAmount();
            
            // Check if the withdrawal amount is more than the current balance
            if ( currentBalance < withdrawAmount) {
                return "Insufficient balance in account " + accountNumber + ". Current balance: " + currentBalance;
            } else {
            	 // Add the deposit to the balance
            	float amount=currentBalance - withdrawAmount;
       
                bankModel.setDepositeAmount(amount);

                // Save the updated account information to the database
                bankrepo.save(bankModel);

            }
                   
        }
        
		return "Amount withdraw successfully. New balance for account " + accountNumber + ": " + (currentBalance - withdrawAmount);
    }

	@Override
	public String atmPin(String accountNumber, String bankName, Integer atmPin) {
		 Optional<Bankmodel> bankDbResponse = bankrepo.findByAccountNumberAndBankName(accountNumber, bankName);
		 if (bankDbResponse.isEmpty()) {
			 return "accountNumber + ":"does not exist enter valid details";
		 } else {
		       if(bankDbResponse.get().getAtmPin() == atmPin ) {
		    	   return "your account balance is -"+ bankDbResponse.get().getDepositeAmount();
		       }else {
		    	   return "dosenot match your atmPin with this account number";
		       }
		 }
	}
	}
