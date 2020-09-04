package radio_alarm_clock;

import java.time.LocalDateTime;

public class StandardAlarmClock implements AlarmClock {
    private LocalDateTime alarmTime;

    @Override
    public Response setAlarm(LocalDateTime time) {
        this.alarmTime = time;
        return new ClockResponse("установил время на "+time.toString());
    }

    @Override
    public LocalDateTime getTime() {
        return LocalDateTime.now();
    }
}
