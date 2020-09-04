package radio_alarm_clock;

public class ClockResponse implements Response {
    private String message;

    public ClockResponse(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return "Будильник "+message;
    }

    @Override
    public String toString() {
        return getMessage();
    }
}
