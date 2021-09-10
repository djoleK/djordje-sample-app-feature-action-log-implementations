package com.phoenixnap.bmc.api;

import com.phoenixnap.bmc.api.models.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

/**
 * A delegate to be called by the {@link CustomersApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-17T12:39:04.897924+02:00[Europe/Belgrade]")
public interface CustomersApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /customers : Create a customer
     * Creates a new instance of a &#x60;customer&#x60;.
     *
     * @param customer A new &#x60;customer&#x60; to be created. (required)
     * @return Successful response. (status code 201)
     * @see CustomersApi#createCustomer
     */
    default ResponseEntity<Customer> createCustomer(Customer customer) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"id\" : \"60c3b5433c6c7a4bb69be303\", \"firstName\" : \"Djole\", \"lastName\" : \"Kostic\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /customers/{id} : Delete a customer
     * Deletes an existing &#x60;customer&#x60;.
     *
     * @param id A unique identifier for a &#x60;customer&#x60;. (required)
     * @return Successful response. (status code 204)
     *         or Internal server error. (status code 500)
     * @see CustomersApi#deleteCustomer
     */
    default ResponseEntity<Void> deleteCustomer(String id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /customers : List All customers
     * Gets a list of all &#x60;customer&#x60; entities.
     *
     * @return Successful response - returns an array of &#x60;customer&#x60; entities. (status code 200)
     *         or No customers found. (status code 204)
     *         or Internal server error. (status code 500)
     * @see CustomersApi#getAllCustomers
     */
    default ResponseEntity<List<Customer>> getAllCustomers() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"id\" : \"60c3b5433c6c7a4bb69be303\", \"firstName\" : \"Djole\", \"lastName\" : \"Kostic\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /customers/{id} : Get a customer
     * Gets the details of a single instance of a &#x60;customer&#x60;.
     *
     * @param id A unique identifier for a &#x60;customer&#x60;. (required)
     * @return Successful response - returns a single &#x60;customer&#x60;. (status code 200)
     *         or Unsuccessful response - no customer found with provided id. (status code 404)
     * @see CustomersApi#getCustomerById
     */
    default ResponseEntity<Customer> getCustomerById(String id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"id\" : \"60c3b5433c6c7a4bb69be303\", \"firstName\" : \"Djole\", \"lastName\" : \"Kostic\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /customers/{id} : Update a customer
     * Updates an existing &#x60;customer&#x60;.
     *
     * @param id A unique identifier for a &#x60;customer&#x60;. (required)
     * @param customer Updated &#x60;customer&#x60; information. (required)
     * @return Successful response. (status code 202)
     *         or Customer not found. (status code 404)
     * @see CustomersApi#updateCustomer
     */
    default ResponseEntity<Customer> updateCustomer(String id,
        Customer customer) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"id\" : \"60c3b5433c6c7a4bb69be303\", \"firstName\" : \"Djole\", \"lastName\" : \"Kostic\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
