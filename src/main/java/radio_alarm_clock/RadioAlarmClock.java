package radio_alarm_clock;

import java.time.LocalDateTime;

public abstract class RadioAlarmClock implements AlarmClock, Radio {
    private Radio radioModule;
    private LocalDateTime alarmTime;

    public RadioAlarmClock(Radio radioModule) {
        this.radioModule = radioModule;
    }

    @Override
    public Response tuneIn(double frequency) {
        return radioModule.tuneIn(frequency);
    }

    @Override
    public boolean turnOn() {
        return radioModule.turnOn();
    }

    @Override
    public boolean turnOff() {
        return radioModule.turnOff();
    }

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
