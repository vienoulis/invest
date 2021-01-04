package ru.vienoulis.investor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.vienoulis.investor.connection.Connection;

@Controller
public class HelloPageController {
    private final Connection connection;

    public HelloPageController(Connection connection) {
        this.connection = connection;
    }

    @GetMapping("/*")
    public void getStartPage() {
//        connection.test();

    }
}
