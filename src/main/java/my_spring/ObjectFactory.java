package my_spring;

import heroes.RandomUtil;
import lombok.Setter;
import lombok.SneakyThrows;
import org.reflections.ReflectionUtils;
import org.reflections.Reflections;
import org.springframework.util.ClassUtils;

import javax.annotation.PostConstruct;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Evgeny Borisov
 */
public class ObjectFactory {

    private ApplicationContext context;

    private List<ObjectConfigurer> objectConfigurers = new ArrayList<>();
    private List<ProxyConfigurer> proxyConfigurers = new ArrayList<>();

    private Reflections scanner;

    @SneakyThrows
    ObjectFactory(ApplicationContext context, Reflections scanner) {
        this.scanner = scanner;
        this.context = context;
        for (Class<? extends ObjectConfigurer> objectConfigurer : scanner.getSubTypesOf(ObjectConfigurer.class)) {
            if (!Modifier.isAbstract(objectConfigurer.getModifiers())) {
                objectConfigurers.add(objectConfigurer.getDeclaredConstructor().newInstance());
            }
        }
        for (Class<? extends ProxyConfigurer> proxyConfigurer : scanner.getSubTypesOf(ProxyConfigurer.class)) {
            if (!Modifier.isAbstract(proxyConfigurer.getModifiers())) {
                proxyConfigurers.add(proxyConfigurer.getDeclaredConstructor().newInstance());
            }
        }
    }


    @SneakyThrows
    public <T> T createObject(Class<T> implClass) {
        T t = create(implClass);

        configure(t);
        invokeInitMethod(implClass, t);
        t = proxying(t);

        return t;
    }

    private <T> T proxying(T t) {
        Class<?> c = t.getClass();
        for (ProxyConfigurer proxyConfigurer : proxyConfigurers) {
            t = (T) proxyConfigurer.configureProxy(t, c);
        }
        return t;
    }


    private <T> void invokeInitMethod(Class<? extends T> implClass, T t) throws IllegalAccessException, InvocationTargetException {
        Set<Method> methods = ReflectionUtils.getAllMethods(implClass);
        for (Method method : methods) {
            if (method.isAnnotationPresent(PostConstruct.class)) {
                method.invoke(t);
            }
        }
    }

    private <T> void configure(T t) {
        objectConfigurers.forEach(objectConfigurer -> objectConfigurer.configure(t,context));
    }

    private <T> T create(Class<? extends T> implClass) throws InstantiationException, IllegalAccessException, java.lang.reflect.InvocationTargetException, NoSuchMethodException {
        return implClass.getDeclaredConstructor().newInstance();
    }


}








