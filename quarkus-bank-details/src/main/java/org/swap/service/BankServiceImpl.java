package org.swap.service;

import org.swap.entity.BankDetails;
import org.swap.repo.BankDetailsRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class BankServiceImpl implements BankDetailsService{

    @Inject
    BankDetailsRepository bankDetailsRepository;

    @Override
    public BankDetails fetchBankDetails(Long bankAccountNumber) {
        return bankDetailsRepository.findByBankAccountNumber(bankAccountNumber);
    }
}