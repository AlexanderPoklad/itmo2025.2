package ru.itmo.javaadvanced.lesson3;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class AppConfigur {

    @Value("${fib.cache.enabled:true}")
    private boolean cacheEnabled;

    public boolean isCacheEnabled() {
        return cacheEnabled;
    }
}