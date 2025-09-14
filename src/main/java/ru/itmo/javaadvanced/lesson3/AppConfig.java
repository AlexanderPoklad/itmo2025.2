package ru.itmo.javaadvanced.lesson3;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Value("${fib.cache.enabled:true}")
    private boolean cacheEnabled;

    public boolean isCacheEnabled() {
        return cacheEnabled;
    }
}