package org.swap.service;

import org.swap.entity.Person;
import org.swap.repo.PersonRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PersonServiceImpl implements PersonService{
	
	@Inject
	PersonRepository personRepository;

	@Override
	public Person findPersonalDetails(Integer vehicleNumber) {
		return personRepository.findByVehicleNumber(vehicleNumber);
	}
}
