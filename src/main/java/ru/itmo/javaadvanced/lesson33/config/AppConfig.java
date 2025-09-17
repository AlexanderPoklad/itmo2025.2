package ru.itmo.javaadvanced.lesson33.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import ru.itmo.javaadvanced.lesson33.component.AppResources;

@Configuration
@EnableConfigurationProperties(AppResources.class)
public class AppConfig {
}