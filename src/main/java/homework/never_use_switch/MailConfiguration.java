package homework.never_use_switch;

import com.github.javafaker.Faker;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class MailConfiguration {
    @Bean
    public Faker faker() {
        return new Faker();
    }

    @Bean
    public DataFactory dataFactory() {
        return new DataFactory();
    }
}
