package real_spring;

import heroes.RandomUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
@Configuration
public class Conf {

    @Bean
    public Integer randomInt(){
        return RandomUtil.getIntBetween(1, 100);
    }

    @Bean("shake")
    public String shakespeareQuote() {
        return "poor Jorik";
    }

    @Bean("terminator")
    public List<String> terminatorQuotes() {
        return List.of("I ll not be bach", "get daaaaaaaaaaaaawn", "Astalavista baby", "I ll be back", "trust me!");
    }
}
