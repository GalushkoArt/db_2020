package real_spring;

import heroes.RandomUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Evgeny Borisov
 */
@Configuration
@PropertySource("application.properties")
public class Conf {
    @Bean
    public Integer randomInt(){
        return RandomUtil.getIntBetween(1, 100);
    }
}
