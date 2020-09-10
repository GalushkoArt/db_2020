package real_spring.aop_advanced.aop;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import real_spring.aop_advanced.CacheSet;
import real_spring.aop_advanced.services.DBRuntimeException;

/**
 * @author Evgeny Borisov
 */
@Component
@Aspect
//@PropertySource("mails_dba.properties")
public class ExceptionHandlerAspect {
    @Autowired
    private CacheSet<DBRuntimeException> cache;

    @AfterThrowing(pointcut = "@target(org.springframework.stereotype.Repository) && execution(* real_spring.aop_advanced..*.*(..))", throwing = "ex")
    public void handleDbException(DBRuntimeException ex) {
        if (cache.add(ex)) {
            System.out.println("sending mails " + ex.getMessage());
        }
    }
}
