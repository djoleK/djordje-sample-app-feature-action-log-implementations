package com.action.log.api.generated;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-08-11T12:13:20.462124+02:00[Europe/Belgrade]")
@Controller
@RequestMapping("${openapi.actionEvent.base-path:}")
public class ActionLogApiController implements ActionLogApi {

    private final ActionLogApiDelegate delegate;

    public ActionLogApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) ActionLogApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new ActionLogApiDelegate() {});
    }

    @Override
    public ActionLogApiDelegate getDelegate() {
        return delegate;
    }

}
