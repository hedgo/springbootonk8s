package com.example.sbonk8s;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksEndpoint {

    @GetMapping("/message")
    public String message() {
        String msg = "Zainstalowane poprawnie na k8s!!!";
        return msg;
    }
}
