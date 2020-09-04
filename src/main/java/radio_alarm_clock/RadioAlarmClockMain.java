package radio_alarm_clock;

import java.time.LocalDateTime;

public class RadioAlarmClockMain {
    public static void main(String[] args) {
        RadioAlarmClock alarmClock = new AwesomeAlarmClock();
        System.out.println(alarmClock.turnOn());
        System.out.println(alarmClock.getTime());
        System.out.println(alarmClock.tuneIn(99.4));
        System.out.println(alarmClock.turnOff());
        System.out.println(alarmClock.turnOff());
        System.out.println(alarmClock.tuneIn(101.1));
        System.out.println(alarmClock.setAlarm(LocalDateTime.now().plusHours(4L)));
    }
}
