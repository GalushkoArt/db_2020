package homework.enums.services;

import homework.enums.services.httpcodes.HttpCodeDefault;
import homework.enums.services.httpcodes.codes4xx.HttpCode404;
import homework.enums.services.httpcodes.codes4xx.HttpCode4xxDefault;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;

public class HttpCodeFactoryTest {

    @Test
    public void getCode() throws ReflectiveOperationException {
        Assertions.assertThat(HttpCodeFactory.getCode(404)).isInstanceOf(HttpCode404.class);
        Assertions.assertThat(HttpCodeFactory.getCode(493)).isInstanceOf(HttpCode4xxDefault.class);
        Assertions.assertThat(HttpCodeFactory.getCode(1864)).isInstanceOf(HttpCodeDefault.class);
    }
}