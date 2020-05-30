package io.wkrzywiec.hexagonal.library.application;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class LibraryHexagonalController {

    @GetMapping("")
    public String getAppRoot(){
        return "Library Hexagonal REST API";
    }
}
