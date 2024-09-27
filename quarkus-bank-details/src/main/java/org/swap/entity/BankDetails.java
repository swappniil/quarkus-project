package org.swap.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class BankDetails{
	
	@Id
	@Column(name = "Bank_Account_Number", unique = true)
    public Long bankAccountNumber;
	
	@Column(name = "Bank_Name")
    public String bankName;
	
	@Column(name = "Branch_Name")
    public String branchName;
	
	@Column(name = "IFSC_Code")
    public String ifscCode;
	
	@Column(name = "Account_Holder_Name")
    public String accountHolderName;
	
	@Column(name = "Balance")
    public double balance;
}
