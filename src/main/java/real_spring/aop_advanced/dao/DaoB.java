package real_spring.aop_advanced.dao;

import org.springframework.stereotype.Repository;
import real_spring.aop_advanced.services.DBRuntimeException;

/**
 * @author Evgeny Borisov
 */
@Repository
public class DaoB {
    public void save() {
        System.out.println("trying to save in BBBBBBB");
        throw new DBRuntimeException("fire all DBA");
    }
}
