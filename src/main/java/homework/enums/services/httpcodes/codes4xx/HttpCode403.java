package homework.enums.services.httpcodes.codes4xx;

import homework.enums.services.httpcodes.HttpCode;

public class HttpCode403 implements HttpCode {
    @Override
    public void process() {
        System.out.println("Клиент зашёл неавторизованным на страницу");
    }
}
