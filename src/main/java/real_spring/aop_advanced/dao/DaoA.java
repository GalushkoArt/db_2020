package real_spring.aop_advanced.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import real_spring.aop_advanced.services.DBRuntimeException;

/**
 * @author Evgeny Borisov
 */
@Repository
public class DaoA {
    @Autowired
    private DaoB dao;

    public void save() {
        System.out.println("trying to save in AAAAAAAAA");
        dao.save();
    }
}
