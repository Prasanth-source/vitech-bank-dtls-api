package vitech.bank.com.api.Repo;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vitech.bank.com.api.model.Bankmodel;

@Repository
public interface BankRepo  extends JpaRepository<Bankmodel, Integer>{

	Optional<Bankmodel> findByAccountNumberAndBankName(String accountNumber, String bankName);
	
	}


