package org.swap.service;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.swap.dto.BankDetailsDto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/bank")
@RegisterRestClient(baseUri = "http://localhost:8080/bank")  // Explicitly define the base URI here
public interface BankDetailsClient {

    @GET
    @Path("/{bankAccountNumber}")
    @Produces(MediaType.APPLICATION_JSON)
    BankDetailsDto getBankDetailsByAccountNumber(@PathParam("bankAccountNumber") Long bankAccountNumber);
}
