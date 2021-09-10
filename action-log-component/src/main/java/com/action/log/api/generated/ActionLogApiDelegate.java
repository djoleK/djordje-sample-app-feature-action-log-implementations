package com.action.log.api.generated;

import com.action.log.models.generated.Action;
import com.action.log.models.generated.ActionEvent;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * A delegate to be called by the {@link ActionLogApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-09-07T09:17:33.543942+02:00[Europe/Belgrade]")
public interface ActionLogApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /action-log : Get a list of all action events.
     * Successful response - returns an array of ActionEvent entities.
     *
     * @param loggedInUserId Logged in user ID. (optional)
     * @param customerId Customer ID. (optional)
     * @param action Action performed on the customer. (optional)
     * @return Succesful response - returns an array of Action Events. (status code 200)
     *         or Unauthorized. (status code 401)
     *         or We&#39;re not supposed to be here. (status code 500)
     * @see ActionLogApi#actionLogGet
     */
    default ResponseEntity<List<ActionEvent>> actionLogGet(String loggedInUserId,
        String customerId,
        Action action) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"customerId\" : \"60c3b5433c6c7a4bb69be303\", \"loggedInUserId\" : \"60c3b5433c6c7a4bb69be303\", \"id\" : \"60c3b5433c6c7a4bb69be303\", \"action\" : \"CREATED\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
