package homework.enums.services.httpcodes.codes2xx;

import homework.enums.services.httpcodes.HttpCode;

public class HttpCode200 implements HttpCode {
    @Override
    public void process() {
        System.out.println("Успешное выполнение");
    }
}
