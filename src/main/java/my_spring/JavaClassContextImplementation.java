package my_spring;

import lombok.SneakyThrows;

public class JavaClassContextImplementation implements Context {

    @SneakyThrows
    public JavaClassContextImplementation(Config config) {
        ObjectFactory.getInstance().setupFactory(config);
    }

    @Override
    public <T> T getInstance(Class<T> c) {
        return ObjectFactory.getInstance().createObject(c);
    }
}
