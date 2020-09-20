package io.codehooks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestService service;

    public String getMessage() {
        return service.getMessage();
    }
}
