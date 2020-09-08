package my_spring;

public interface Context {
    <T> T getInstance(Class<T> c);
}
