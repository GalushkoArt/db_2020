package real_spring.aop_advanced;

import lombok.experimental.Delegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

@Component
public class CacheSet<T> {
    private final Set<T> cache;
    private final int size;

    @Autowired //cache.size=500
    public CacheSet(@Value("${cache.size}") int cacheSize) {
        this.size = cacheSize;
        this.cache = new LinkedHashSet<>(cacheSize);
    }

    public boolean add(T t) {
        if (!cache.contains(t) && cache.size() == size) {
            Iterator<T> iterator = cache.iterator();
            iterator.next();
            iterator.remove();
            return cache.add(t);
        }
        return cache.add(t);
    }

    public int size() {
        return cache.size();
    }

    public boolean contains(T t) {
        return cache.contains(t);
    }
}
