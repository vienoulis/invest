package ru.vienoulis.investor.connection;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.tinkoff.invest.openapi.OpenApi;

@Slf4j
@Component
public class ConnectionInpl implements Connection {

    private final OpenApi api;

    public ConnectionInpl(OpenApi api) {
        this.api = api;
    }

    @Override
    public void test() {
        log.info("Open api {}", api);
    }

    @Override
    public void connect() {

    }
}
