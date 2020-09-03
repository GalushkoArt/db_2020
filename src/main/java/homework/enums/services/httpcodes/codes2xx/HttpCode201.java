package homework.enums.services.httpcodes.codes2xx;

import homework.enums.services.httpcodes.HttpCode;

public class HttpCode201 implements HttpCode {
    @Override
    public void process() {
        System.out.println("Создание успешно");
    }
}
