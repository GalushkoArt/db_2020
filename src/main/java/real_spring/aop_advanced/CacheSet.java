package real_spring.aop_advanced;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class CacheSet<T> {
    private final Set<T> cache;
    private final int size;

    public CacheSet(int cacheSize) {
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
