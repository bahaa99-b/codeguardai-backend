package elbouch.project.apigateway.config;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {
    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("core", r -> r.path("/core/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("http://core-service:8080"))
                .route("analysis", r -> r.path("/analysis/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("http://code-analysis-service:8080"))
                .build();
    }
}