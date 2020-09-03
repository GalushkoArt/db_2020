package homework.enums.services.httpcodes.codes5xx;

import homework.enums.services.httpcodes.HttpCode;

public class HttpCode504 implements HttpCode {
    @Override
    public void process() {
        System.out.println("Истекло вреня ожидания сервера");
    }
}
