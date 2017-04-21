package cass.config;


import cass.web.ApplicationRoutes;
import cass.web.HotelHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;

@Configuration
public class WebConfig {

    @Autowired
    private HotelHandler hotelHandler;

    @Bean
    public RouterFunction<?> routerFunction() {
        return ApplicationRoutes.routes(this.hotelHandler);
    }
}
