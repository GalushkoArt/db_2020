package homework.enums.services.httpcodes.codes1xx;

import homework.enums.services.httpcodes.HttpCode;

public class HttpCode102 implements HttpCode {
    @Override
    public void process() {
        System.out.println("В обработке");
    }
}
