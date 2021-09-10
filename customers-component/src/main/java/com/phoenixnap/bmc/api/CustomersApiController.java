package com.phoenixnap.bmc.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-17T12:39:04.897924+02:00[Europe/Belgrade]")
@Controller
@RequestMapping("${openapi.customer.base-path:}")
public class CustomersApiController implements CustomersApi {

    private final CustomersApiDelegate delegate;

    public CustomersApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) CustomersApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new CustomersApiDelegate() {});
    }

    @Override
    public CustomersApiDelegate getDelegate() {
        return delegate;
    }

}
