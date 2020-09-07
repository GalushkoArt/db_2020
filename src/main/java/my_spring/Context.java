package my_spring;

import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;

public class Context {
    Map<Class<?>, Object> singletonsMap = new HashMap<>();

    public Context() {
        new Reflections("my_spring")
                .getTypesAnnotatedWith(Singleton.class)
                .forEach(e -> singletonsMap.put(e, ObjectFactory.getInstance().createObject(e)));
        for (Class<?> aClass : singletonsMap.keySet()) {
            for (Class<?> anInterface : aClass.getInterfaces()) {
                singletonsMap.put(anInterface, singletonsMap.get(aClass));
            }
        }
        singletonsMap.values().forEach(RandomIntInjector::inject);
        singletonsMap.values().forEach(e -> InstanceInjector.inject(this, e));
    }

    public<T> T getInstance(Class<T> c) {
        if (singletonsMap.containsKey(c)) {
            return (T) singletonsMap.get(c);
        }
        T instance = ObjectFactory.getInstance().createObject(c);
        RandomIntInjector.inject(instance);
        InstanceInjector.inject(this, instance);
        return instance;
    }
}
