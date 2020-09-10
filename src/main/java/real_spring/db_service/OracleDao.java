package real_spring.db_service;

import org.springframework.stereotype.Component;

@Component
@Oracle
public class OracleDao implements Dao {
    @Override
    public void save() {
        System.out.println("Сохраняю в Оракл");
    }
}
