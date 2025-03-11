package vitech.bank.com.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vitech.bank.com.api.model.Bankmodel;
import vitech.bank.com.api.service.Bankservice;


@RestController
//@RequestMapping("/Bank")
public class Bankcontroller {

	@Autowired
	 
	private Bankservice bankservice;
	
	// new method for inserting data
	
	@PostMapping("/createAccount")
	public ResponseEntity<String> insertBankData(@RequestBody Bankmodel bank) {
	    System.out.println("insert BankData:: input received - " + bank);
	    
	    try {
	        String result = bankservice.createBankAccount(bank);
	        return ResponseEntity.ok(result);
	    } catch (Exception e) {
	        System.err.println("Error occurred: " + e.getMessage());
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                             .body("An error occurred while processing the request.");
	    }
	}
	 // Endpoint for depositing money into the account
//    @PutMapping("/deposit")
//    public ResponseEntity<String> depositAmount(@RequestBody Bankmodel bank) {
//        // Validate input data from the RAML requirements
//    	if (bank.getAccountNumber() == null || bank.getAccountNumber().length() != 10) {
//            return ResponseEntity.badRequest().body("Account number should be exactly 10 digits");
//        }
//        
//        if (!"ICICI".equals(bank.getBankName()) && 
//            !"AXIS".equals(bank.getBankName()) && 
//            !"HDFC".equals(bank.getBankName()) && 
//            !"SBI".equals(bank.getBankName())) {
//            return ResponseEntity.badRequest().body("Invalid bank name. Valid options are ICICI, AXIS, HDFC, SBI");
//        }
//
//        String responseMessage = bankservice.depositAmount(bank);
//        return ResponseEntity.ok(responseMessage);
//    }
	@PutMapping("/deposit")
    public ResponseEntity<String> depositAmount(@RequestParam String accountNumber, 
                                                @RequestParam String bankName, 
                                                @RequestParam Float depositAmount) {
       
		// Call the service to deposit the amount
        String responseMessage = bankservice.depositAmount(accountNumber, bankName, depositAmount);
        
        // Return the response message
        return ResponseEntity.ok(responseMessage);
    }
	@PutMapping("/withdraw")
    public ResponseEntity<String> withdrawAmount(@RequestParam String accountNumber, 
                                                @RequestParam String bankName, 
                                                @RequestParam Float withdrawAmount) {
       
		// Call the service to deposit the amount
        String responseMessage = bankservice.withdrawAmount(accountNumber, bankName, withdrawAmount);
        
        // Return the response message
        return ResponseEntity.ok(responseMessage);
    }
	@GetMapping("/checkBalance")
    public ResponseEntity<String> atmPin(@RequestParam String accountNumber, 
                                                @RequestParam String bankName, 
                                                @RequestParam Integer atmPin) {
       
		// Call the service to atmPin
        String responseMessage = bankservice.atmPin(accountNumber, bankName, atmPin);
        
        // Return the response message
        return ResponseEntity.ok(responseMessage);
    }
}