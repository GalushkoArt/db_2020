package my_spring;

import javax.annotation.PostConstruct;

/**
 * @author Evgeny Borisov
 */
public interface Cleaner {

    void clean();
    void clean(int i);
}
