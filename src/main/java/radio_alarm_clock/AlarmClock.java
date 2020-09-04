package radio_alarm_clock;

import java.time.LocalDateTime;

public interface AlarmClock {
    Response setAlarm(LocalDateTime time);
    LocalDateTime getTime();
}
