package org.swap;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.swap.dto.PersonResponseDto;
import org.swap.dto.BankDetailsDto;
import org.swap.entity.Person;
import org.swap.service.BankDetailsClient;
import org.swap.service.PersonService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/vehicles")
public class VehicleResource {

    @Inject
    PersonService personService;

    @Inject
    @RestClient
    BankDetailsClient bankDetailsClient;

    @GET
    @Path("/{vehicleNumber}")
    public Response getBankBalance(@PathParam("vehicleNumber") Integer vehicleNumber) {
        
        Person person = personService.findPersonalDetails(vehicleNumber);
        if (person == null) {
            return Response.status(Response.Status.NOT_FOUND)
                           .entity("Person not found for vehicle number: " + vehicleNumber)
                           .build();
        }

        Long bankAccountNumber = person.getBankAccountNumber();
        if (bankAccountNumber == null) {
            return Response.status(Response.Status.NOT_FOUND)
                           .entity("No bank account associated with the person.")
                           .build();
        }

        // Fetch bank details using the bank account number
        BankDetailsDto bankDetails = bankDetailsClient.getBankDetailsByAccountNumber(bankAccountNumber);
        if (bankDetails == null) {
            return Response.status(Response.Status.NOT_FOUND)
                           .entity("No bank details found for account number: " + bankAccountNumber)
                           .build();
        }
        
        // Create a response DTO with both person and bank details
        PersonResponseDto responseDto = new PersonResponseDto(person, bankDetails);
        return Response.ok(responseDto).build();
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/hello")
    public String hello() {
        return "Hello from Quarkus Vehicle";
    }
    
}
