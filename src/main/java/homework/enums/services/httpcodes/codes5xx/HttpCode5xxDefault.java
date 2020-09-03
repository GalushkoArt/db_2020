package homework.enums.services.httpcodes.codes5xx;

import homework.enums.services.httpcodes.HttpCode;

public class HttpCode5xxDefault implements HttpCode {
    @Override
    public void process() {
        System.out.println("Не опознаная ошибка на сервере");
    }
}
