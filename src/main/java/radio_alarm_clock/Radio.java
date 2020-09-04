package radio_alarm_clock;

public interface Radio {
    Response tuneIn(double frequency);
    boolean turnOn();
    boolean turnOff();
}
