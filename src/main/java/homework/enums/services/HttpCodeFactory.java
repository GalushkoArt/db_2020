package homework.enums.services;

import homework.enums.services.httpcodes.HttpCode;
import homework.enums.services.httpcodes.HttpCodeDefault;
import org.reflections.Reflections;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class HttpCodeFactory {
    private HttpCodeFactory(){}

    public static HttpCode getCode(int code) throws ReflectiveOperationException {
        String group = "codes" + (code / 100) + "xx";
        Path codeClassName = getPathFromCodeAndGroup(group, code);
        if (codeClassName != null) {
            return (HttpCode) Class.forName("homework.enums.services.httpcodes." + group + ".HttpCode" + code)
                    .getDeclaredConstructor()
                    .newInstance();
        } else {
            try {
                return (HttpCode) Class.forName("homework.enums.services.httpcodes." + group + ".HttpCode" + (code/100) +"xxDefault")
                        .getDeclaredConstructor()
                        .newInstance();
            } catch (ClassNotFoundException e) {
                return new HttpCodeDefault();
            }
        }
    }

    protected static Path getPathFromCodeAndGroup(String group, int code) {
        try {
            return Files.list(Path.of("src/main/java/homework/enums/services/httpcodes/" + group))
                    .filter(c -> c.getFileName().toString().startsWith("HttpCode" + code))
                    .findFirst()
                    .orElse(null);
        } catch (IOException e) {
            return null;
        }
    }
}
