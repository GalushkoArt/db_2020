package homework.enums.services.httpcodes.codes2xx;

import homework.enums.services.httpcodes.HttpCode;

public class HttpCode202 implements HttpCode {
    @Override
    public void process() {
        System.out.println("Запрос принят");
    }
}
