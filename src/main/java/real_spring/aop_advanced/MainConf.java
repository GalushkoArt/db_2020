package real_spring.aop_advanced;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import real_spring.aop_advanced.services.DBRuntimeException;
import real_spring.aop_advanced.services.ServiceA;


/**
 * @author Evgeny Borisov
 */
@Configuration
@EnableAspectJAutoProxy
@PropertySource("classpath:application.properties")
@ComponentScan
public class MainConf {
    
    @Bean
    public CacheSet<DBRuntimeException> exceptionCacheSet(@Value("${cache.size}") int cacheSize) {
        return new CacheSet<>(cacheSize);
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConf.class);
        for (int i = 0; i < 501; i++) {
            context.getBean(ServiceA.class).doA();
        }
    }

}
