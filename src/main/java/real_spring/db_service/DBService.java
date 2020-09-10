package real_spring.db_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class DBService {
    @Autowired
    @Oracle
    private Dao mainDB;

    @Autowired
    @Derby
    private Dao backupDB;

    @Scheduled(fixedDelay = 1000)
    public void doWork() {
        mainDB.save();
    }

    @Scheduled(fixedDelay = 3000)
    public void doBackup() {
        backupDB.save();
    }
}
