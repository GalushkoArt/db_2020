package homework.never_use_switch;

import com.github.javafaker.Faker;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan
@EnableScheduling
public class MailConfiguration {

    @Bean
    public Faker faker() {
        return new Faker();
    }

    @Bean
    public DataFactory dataFactory() {
        return new DataFactory();
    }

    public static void main(String[] args) {
        MailMockProducer producer = new AnnotationConfigApplicationContext(MailConfiguration.class)
                .getBean(MailMockProducer.class);
    }
}
