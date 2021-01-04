package ru.vienoulis.investor.config;

import lombok.extern.slf4j.Slf4j;
import okhttp3.RequestBody;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.tinkoff.invest.openapi.OpenApi;
import ru.tinkoff.invest.openapi.OpenApiFactoryBase;
import ru.tinkoff.invest.openapi.SandboxOpenApi;
import ru.tinkoff.invest.openapi.models.user.BrokerAccountType;
import ru.tinkoff.invest.openapi.okhttp.OkHttpOpenApiFactory;

import java.util.concurrent.Executors;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@Slf4j
@Configuration
public class AppConf {


    @Value(value = "${investor.token.sendbox}")
    private String token;
    @Value(value = "${investor.sandboxMode}")
    private boolean sandBoxMode;
    private  Logger logger = Logger.getLogger("test");

    @Bean
    public OpenApiFactoryBase getOpenApiFactoryBase() {
        return new OkHttpOpenApiFactory(token, logger);
    }

    @Bean
    public OpenApi getApi(OpenApiFactoryBase openApiFactoryBase) {
        RequestBody r;
        OpenApi api;
        if (sandBoxMode) {
            api = openApiFactoryBase.createSandboxOpenApiClient(Executors.newSingleThreadExecutor());
            // ОБЯЗАТЕЛЬНО нужно выполнить регистрацию в "песочнице"
            ((SandboxOpenApi) api).getSandboxContext().performRegistration(null).join();
        } else {
            api = openApiFactoryBase.createOpenApiClient(Executors.newSingleThreadExecutor());
        }
        return api;
    }

}
