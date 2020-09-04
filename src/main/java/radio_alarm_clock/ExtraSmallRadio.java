package radio_alarm_clock;

public class ExtraSmallRadio implements Radio {
    private boolean isWorks;
    private double currentFrequency;

    @Override
    public Response tuneIn(double frequency) {
        if (isWorks) {
            this.currentFrequency = frequency;
            return new RadioResponse("настроил частоту " + frequency);
        } else {
            return new RadioResponse("выключен и не настроен на частоту " + frequency);
        }
    }

    @Override
    public boolean turnOn() {
        if (!isWorks) {
            isWorks = true;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean turnOff() {
        if (isWorks) {
            isWorks = false;
            return true;
        } else {
            return false;
        }
    }
}
