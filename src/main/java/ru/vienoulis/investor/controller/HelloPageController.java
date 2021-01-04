package ru.vienoulis.investor.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.tinkoff.invest.openapi.OpenApi;
import ru.vienoulis.investor.connection.Connection;

@Slf4j
@Controller
public class HelloPageController {
    private final Connection connection;
    private final OpenApi api;

    public HelloPageController(Connection connection, OpenApi api) {
        this.connection = connection;
        this.api = api;
    }

    @GetMapping("/*")
    public void getStartPage() {
        connection.test();
        log.info(" {}", api);
        log.info("getMarketContext() {}", api.getMarketContext());
        log.info("getOperationsContext() {}", api.getOperationsContext());
        log.info("getOrdersContext() {}", api.getOrdersContext());
        log.info("getPortfolioContext {}", api.getPortfolioContext());
        log.info("getStreamingContext {}", api.getStreamingContext());
        log.info("getStreamingContext {}", api.getUserContext());
    }
}
