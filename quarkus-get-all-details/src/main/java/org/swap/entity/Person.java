package org.swap.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Person extends PanacheEntity {
	
    @Column(name = "Vehicle_Number", unique = true)
    private Integer vehicleNumber;

    @Column(name = "Licesnse_Number")
    private String licesnseNumber;
    
    @Column(name = "Name")
    private String name;
    
    @Column(name = "Address")
    private String address;
    
    @Column(name = "Mobile_Number")
    private Long mobileNumber;
    
    @Column(name = "Email_Id")
    private String email;
    
    @Column(name = "Bank_Account_Number")
    private Long bankAccountNumber;
}