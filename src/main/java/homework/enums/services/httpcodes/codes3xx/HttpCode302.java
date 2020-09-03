package homework.enums.services.httpcodes.codes3xx;

import homework.enums.services.httpcodes.HttpCode;

public class HttpCode302 implements HttpCode {
    @Override
    public void process() {
        System.out.println("Перенаправление найдено");
    }
}
