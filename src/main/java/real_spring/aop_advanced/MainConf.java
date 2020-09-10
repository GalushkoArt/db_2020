package real_spring.aop_advanced;

import org.springframework.context.annotation.*;
import real_spring.aop_advanced.services.ServiceA;


/**
 * @author Evgeny Borisov
 */
@Configuration
@EnableAspectJAutoProxy
@PropertySource("classpath:application.properties")
@ComponentScan
public class MainConf {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConf.class);
        for (int i = 0; i < 501; i++) {
            context.getBean(ServiceA.class).doA();
        }
    }

}
