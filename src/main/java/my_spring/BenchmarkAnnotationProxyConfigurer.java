package my_spring;

import org.springframework.util.ClassUtils;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;

public class BenchmarkAnnotationProxyConfigurer implements ProxyConfigurer {
    @Override
    public Object configureProxy(Object o, Class<?> c) {
        Map<String, List<Class<?>[]>> methods = new HashMap<>();
        if (c.isAnnotationPresent(Benchmark.class)) {
            for (Method method : c.getDeclaredMethods()) {
                methods.putIfAbsent(method.getName(), new ArrayList<>());
                methods.get(method.getName()).add(method.getParameterTypes());
            }
        } else {
            for (Method method : c.getDeclaredMethods()) {
                if (method.isAnnotationPresent(Benchmark.class)) {
                    methods.putIfAbsent(method.getName(), new ArrayList<>());
                    methods.get(method.getName()).add(method.getParameterTypes());
                }
            }
        }
        if (methods.size() > 0) {
            return Proxy.newProxyInstance(c.getClassLoader(), ClassUtils.getAllInterfaces(o), (proxy, method, args) -> {
                if (methods.containsKey(method.getName())) {
                    for (Class<?>[] params : methods.get(method.getName())) {
                        if (Arrays.equals(params, method.getParameterTypes())) {
                            System.out.println("************* BENCHMARK STARTED for method "+ method.getName()+" ****************");
                            long start = System.nanoTime();
                            Object retVal = method.invoke(o, args);
                            long end = System.nanoTime();
                            System.out.println(end-start);
                            System.out.println("************* BENCHMARK ENDED for method "+ method.getName()+" ****************");
                            return retVal;
                        }
                    }
                }
                return method.invoke(o, args);
            });
        }
        return o;
    }
}
