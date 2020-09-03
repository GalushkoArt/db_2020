package homework.enums.services.httpcodes.codes1xx;

import homework.enums.services.httpcodes.HttpCode;

public class HttpCode1xxDefault implements HttpCode {
    @Override
    public void process() {
        System.out.println("Не опознаное информационное сообщение");
    }
}
