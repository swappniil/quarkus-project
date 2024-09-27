package org.swap.repo;

import org.swap.entity.Person;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {

	public Person findByVehicleNumber(Integer vehicleNumber) {
	    System.out.println("Searching for vehicle number: " + vehicleNumber);
	    return find("vehicleNumber", vehicleNumber).firstResult();
	}
}

