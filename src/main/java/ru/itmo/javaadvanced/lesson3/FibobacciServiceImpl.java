package ru.itmo.javaadvanced.lesson3;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class FibobacciServiceImpl implements FibonacciService {

    private final AppConfig config;
    private final ConcurrentHashMap<Integer, Long> cache = new ConcurrentHashMap<>();

    @Override
    public long calculate(int n) {
        if (n < 0) throw new IllegalArgumentException("n должно быть >= 0");

        if (config.isCacheEnabled() && cache.containsKey(n)) {
            return cache.get(n);
        }

        long result = fib(n);
        if (config.isCacheEnabled()) {
            cache.put(n, result);
        }
        return result;
    }

    private long fib(int n) {
        if (n <= 1) return n;
        long a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            long tmp = a + b;
            a = b;
            b = tmp;
        }
        return b;
    }

    @Override
    public Map<Integer, Long> getCache(){
        return Map.copyOf(cache);
    }
}