package dev.avee.bettersecurity.modules.auth.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
class TestController {

    @GetMapping
    String getResponse() {
        return "hello!";
    }
}
