package homework.enums;

import homework.enums.services.HttpCodeService;

public class HttpCodeMain {
    public static void main(String[] args) throws ReflectiveOperationException {
        HttpCodeService service = new HttpCodeService();
        String response = "httpcode 404\n" +
                "httpcode:403\n" +
                "httpcode: 500\n" +
                "httpcode:200\n" +
                "httpcode:302\n" +
                "httpcode:100\n" +
                "httpcode: 504\n" +
                "gdfd 325t\n" +
                "httpcode: 40cd\n" +
                "httpcode: sdf334\n" +
                "httpcode: 4294123";
        service.processHttp(response);
    }
}
