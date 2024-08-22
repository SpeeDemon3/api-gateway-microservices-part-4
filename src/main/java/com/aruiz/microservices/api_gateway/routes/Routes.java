package com.aruiz.microservices.api_gateway.routes;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.function.server.RequestPredicates;

import java.net.URI;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration(proxyBeanMethods = false)
public class Routes {

    @Bean
    public RouterFunction<ServerResponse> productServiceRoute() {
        return route(RequestPredicates.path("/api/product"),
                req -> ServerResponse.temporaryRedirect(URI.create("http://localhost:8080")).build());
    }

    @Bean
    public RouterFunction<ServerResponse> orderServiceRoute() {
        return route(RequestPredicates.path("/api/order"),
                req -> ServerResponse.temporaryRedirect(URI.create("http://localhost:8081")).build());
    }

    @Bean
    public RouterFunction<ServerResponse> inventoryServiceRoute() {
        return route(RequestPredicates.path("/api/inventory"),
                req -> ServerResponse.temporaryRedirect(URI.create("http://localhost:8082")).build());
    }
}
