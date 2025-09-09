package ru.itmo.javaadvanced.lesson2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component

public class ConverterRunner implements CommandLineRunner {

    private final TemperatureConverter converter;

    public ConverterRunner(TemperatureConverter converter) {
        this.converter = converter;
    }

    @Override

    public void run(String... args) {

        double cToF = converter.convert(100, "C", "F");
        double fToK = converter.convert(100, "F", "K");
        double kToC = converter.convert(100, "K", "C");

        System.out.printf("100 C -> F = %.2f%n", cToF);
        System.out.printf("100 F -> K = %.2f%n", fToK);
        System.out.printf("100 K -> C = %.2f%n", kToC);
    }
}