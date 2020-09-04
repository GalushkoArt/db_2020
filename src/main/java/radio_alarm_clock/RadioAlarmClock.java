package radio_alarm_clock;

import lombok.AllArgsConstructor;
import lombok.experimental.Delegate;

@AllArgsConstructor
public abstract class RadioAlarmClock implements AlarmClock, Radio {
    @Delegate
    private AlarmClock alarmClock;
    @Delegate
    private Radio radioModule;
}
