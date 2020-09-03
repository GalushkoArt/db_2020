package homework.enums.services.httpcodes.codes1xx;

import homework.enums.services.httpcodes.HttpCode;

public class HttpCode100 implements HttpCode {
    @Override
    public void process() {
        System.out.println("Продолжить обработку");
    }
}
