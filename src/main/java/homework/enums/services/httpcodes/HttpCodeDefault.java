package homework.enums.services.httpcodes;

public class HttpCodeDefault implements HttpCode {
    @Override
    public void process() {
        System.out.println("Пришёл неизвестный код!");
    }
}
