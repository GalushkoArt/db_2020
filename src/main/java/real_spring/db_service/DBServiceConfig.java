package real_spring.db_service;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan
@EnableScheduling
public class DBServiceConfig {

    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(DBServiceConfig.class);
    }
}
