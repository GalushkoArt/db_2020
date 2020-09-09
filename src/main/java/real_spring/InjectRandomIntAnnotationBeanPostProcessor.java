package real_spring;

import heroes.RandomUtil;
import lombok.SneakyThrows;
import my_spring.InjectRandomInt;
import org.reflections.ReflectionUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;
import java.util.Set;

public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {
    @SneakyThrows
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        Set<Field> fields = ReflectionUtils.getAllFields(beanClass);
        for (Field field : fields) {
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            if (annotation != null) {
                int min = annotation.min();
                int max = annotation.max();
                field.setAccessible(true);
                field.set(bean, RandomUtil.getIntBetween(min, max));
            }
        }
        return bean;
    }
}
