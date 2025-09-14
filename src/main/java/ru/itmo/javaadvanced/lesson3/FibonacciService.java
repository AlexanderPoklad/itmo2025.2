package ru.itmo.javaadvanced.lesson3;
import java.util.Map;

public interface FibonacciService {
    long calculate(int n);

    Map<Integer, Long> getCache();
}