package org.swap.service;

import org.swap.entity.BankDetails;

public interface BankDetailsService {

	BankDetails fetchBankDetails(Long bankAccountNumber);

}
