package org.swap;

import org.swap.entity.BankDetails;
import org.swap.service.BankDetailsService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/bank")
public class BankResource {
	
    @Inject
    BankDetailsService bankService;

    @GET
    @Path("/{bankAccountNumber}")
    public Response getBankDetails(@PathParam("bankAccountNumber") Long bankAccountNumber) {
        BankDetails bankDetails = bankService.fetchBankDetails(bankAccountNumber);

        if (bankDetails == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Bank details not found").build();
        }
        
        return Response.ok(bankDetails).build();
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("hello")
    public String hello() {
        return "Hello from Quarkus Bank";
    }
}
