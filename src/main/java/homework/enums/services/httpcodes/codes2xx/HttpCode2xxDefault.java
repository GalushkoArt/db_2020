package homework.enums.services.httpcodes.codes2xx;

import homework.enums.services.httpcodes.HttpCode;

public class HttpCode2xxDefault implements HttpCode {
    @Override
    public void process() {
        System.out.println("Не опознаный успешный код");
    }
}
