package homework.enums.services.httpcodes.codes4xx;

import homework.enums.services.httpcodes.HttpCode;

public class HttpCode4xxDefault implements HttpCode {
    @Override
    public void process() {
        System.out.println("Не опознаная ошибка у клиента");
    }
}
