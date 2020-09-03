package homework.enums.services;

import homework.enums.services.httpcodes.HttpCode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Evgeny Borisov
 */
public class HttpCodeService {
    public void processHttp(String text) throws ReflectiveOperationException {
        Pattern httpCodePattern = Pattern.compile("httpcode:?\\s?\\d{3,}", Pattern.CASE_INSENSITIVE);
        Matcher matcher = httpCodePattern.matcher(text);
        while (matcher.find()) {
            String codeString = text.substring(matcher.start(), matcher.end()).replaceAll("[^\\d]+","");
            int code = Integer.parseInt(codeString);
            HttpCode httpCode = HttpCodeFactory.getCode(code);
            httpCode.process();
        }
    }
}
