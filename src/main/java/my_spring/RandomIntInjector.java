package my_spring;

import heroes.RandomUtil;
import lombok.SneakyThrows;

import java.lang.reflect.Field;

public class RandomIntInjector {
    @SneakyThrows
    public static void inject(Object object) {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field: fields) {
            if (field.isAnnotationPresent(InjectRandomInt.class)) {
                InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
                int value = RandomUtil.getIntBetween(annotation.min(), annotation.max());
                field.setAccessible(true);
                field.set(object, value);
            }
        }
    }
}
