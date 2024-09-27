package org.swap.repo;

import org.swap.entity.BankDetails;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BankDetailsRepository implements PanacheRepository<BankDetails>{

    public BankDetails findByBankAccountNumber(Long bankAccountNumber) {
        return find("bankAccountNumber", bankAccountNumber).firstResult();
    }
}