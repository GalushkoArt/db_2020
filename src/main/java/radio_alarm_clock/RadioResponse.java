package radio_alarm_clock;

public class RadioResponse implements Response {
    private String message;

    public RadioResponse(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return "Радио "+message;
    }

    @Override
    public String toString() {
        return getMessage();
    }
}
