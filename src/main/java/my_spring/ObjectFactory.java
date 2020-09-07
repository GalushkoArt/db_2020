package my_spring;

import com.google.common.collect.ImmutableMap;
import lombok.SneakyThrows;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Evgeny Borisov
 */
public class ObjectFactory {
    private Map<Class<?>, Class<?>> ifc2ImplClass;


    private static ObjectFactory objectFactory = new ObjectFactory();

    private ObjectFactory() {
        ifc2ImplClass = ImmutableMap.<Class<?>, Class<?>> builder()
                .put(Cleaner.class, CleanerImpl.class)
                .put(Speaker.class, ConsoleSpeaker.class)
                .build();
    }

    public static ObjectFactory getInstance() {
        return objectFactory;
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        if (ifc2ImplClass.containsKey(type)) {
            return (T) ifc2ImplClass.get(type).getDeclaredConstructor().newInstance();
        }
        return type.getDeclaredConstructor().newInstance();
    }
}
