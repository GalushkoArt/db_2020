package my_spring;

import heroes.RandomUtil;
import lombok.Setter;
import lombok.SneakyThrows;
import org.reflections.ReflectionUtils;
import org.reflections.Reflections;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * @author Evgeny Borisov
 */
public class ObjectFactory {
    @Setter
    private Config config;
    private Reflections scanner;
    private Map<Class<?>, Object> singletons = new HashMap<>();
    private List<ObjectConfigurer> objectConfigurers = new ArrayList<>();
    private static ObjectFactory objectFactory = new ObjectFactory();

    private ObjectFactory() {
    }

    public static ObjectFactory getInstance() {
        return objectFactory;
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        if (singletons.get(type) != null) {
            return (T) singletons.get(type);
        }
        Class<? extends T> implClass = resolveImpl(type);
        T t = create(implClass);
        configure(t);
        invokeInitMethod(implClass, t);
        if (implClass.isAnnotationPresent(Singleton.class)) {
            singletons.put(type, t);
            singletons.put(implClass, t);
        }
        return t;
    }

    @SneakyThrows
    protected void setupFactory(Config config) {
        this.config = config;
        scanner = new Reflections(config.getPackageToScan());
        Set<Class<? extends ObjectConfigurer>> classes = scanner.getSubTypesOf(ObjectConfigurer.class);
        for (Class<? extends ObjectConfigurer> aClass : classes) {
            if (!Modifier.isAbstract(aClass.getModifiers())) {
                objectConfigurers.add(aClass.getDeclaredConstructor().newInstance());
            }
        }
        setupConfigurers();
        setupSingletons();
    }

    private <T> void invokeInitMethod(Class<? extends T> implClass, T t) throws IllegalAccessException, InvocationTargetException {
        Set<Method> methods = ReflectionUtils.getAllMethods(implClass);
        for (Method method : methods) {
            if (method.isAnnotationPresent(PostConstruct.class)) {
                method.invoke(t);
            }
        }
    }

    @SneakyThrows
    private void setupConfigurers()  {
        for (Class<? extends ObjectConfigurer> aClass : scanner.getSubTypesOf(ObjectConfigurer.class)) {
            if (!Modifier.isAbstract(aClass.getModifiers())) {
                objectConfigurers.add(aClass.getDeclaredConstructor().newInstance());
            }
        }
    }

    private void setupSingletons() {
        for (Class<?> annotated : scanner.getTypesAnnotatedWith(Singleton.class)) {
            Singleton annotation = annotated.getAnnotation(Singleton.class);
            if (annotation.hot()) {
                createObject(annotated);
            } else {
                singletons.put(annotated, null);
            }
        }
    }

    private <T> void configure(T t) {
        objectConfigurers.forEach(objectConfigurer -> objectConfigurer.configure(t));
    }

    private <T> T create(Class<? extends T> implClass) throws InstantiationException, IllegalAccessException, java.lang.reflect.InvocationTargetException, NoSuchMethodException {
        return implClass.getDeclaredConstructor().newInstance();
    }

    private <T> Class<? extends T> resolveImpl(Class<T> type) {
        Class<? extends T> implClass;
        if (type.isInterface()) {
            implClass = config.getImpl(type);
            if (implClass == null) {
                Set<Class<? extends T>> classes = scanner.getSubTypesOf(type);
                if (classes.size() != 1) {
                    throw new IllegalStateException(type + " has 0 or more than one impl, please update your config");
                }
                implClass = classes.iterator().next();
            }
        } else {
            implClass = type;
        }
        return implClass;
    }
}








