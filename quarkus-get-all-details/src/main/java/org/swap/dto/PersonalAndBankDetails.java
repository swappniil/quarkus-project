package org.swap.dto;

import org.swap.entity.Person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonalAndBankDetails {
	public Person personalDetails;
	public BankDetailsDto BankDetails;
}
