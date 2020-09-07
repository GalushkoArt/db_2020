package my_spring;

import lombok.SneakyThrows;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;

public class InstanceInjector {
    @SneakyThrows
    public static void inject(Context context, Object object) {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field: fields) {
            if (field.isAnnotationPresent(InjectInstance.class)) {
                Class<?> type = field.getType();
                field.setAccessible(true);
                field.set(object, context.getInstance(type));
            }
        }
    }
}
