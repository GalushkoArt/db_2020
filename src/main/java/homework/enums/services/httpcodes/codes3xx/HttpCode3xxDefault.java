package homework.enums.services.httpcodes.codes3xx;

import homework.enums.services.httpcodes.HttpCode;

public class HttpCode3xxDefault implements HttpCode {
    @Override
    public void process() {
        System.out.println("Не опознанное перенаправление");
    }
}
