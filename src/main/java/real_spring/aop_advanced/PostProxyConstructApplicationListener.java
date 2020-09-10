package real_spring.aop_advanced;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class PostProxyConstructApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private ConfigurableListableBeanFactory factory;

    @SneakyThrows
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext context = event.getApplicationContext();
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            String className = factory.getBeanDefinition(name).getBeanClassName();
            Class<?> beanClass = Class.forName(className);
            for (Method method: beanClass.getMethods()) {
                if (method.isAnnotationPresent(PostProxyConstruct.class)) {
                    Object bean = context.getBean(name);
                    Method presentMethod = bean.getClass().getMethod(method.getName(), method.getParameterTypes());
                    presentMethod.invoke(bean);
                }
            }
        }
    }
}
