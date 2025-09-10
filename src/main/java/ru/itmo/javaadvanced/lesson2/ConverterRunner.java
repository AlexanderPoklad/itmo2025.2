package ru.itmo.javaadvanced.lesson2;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.itmo.javaadvanced.lesson2.service.TemperatureConverter;

@Component
@RequiredArgsConstructor
public class ConverterRunner implements CommandLineRunner {

    private final TemperatureConverter converter;

    @Override
    public void run(String... args) {

        double cToF = converter.convert(100, TemperatureUnit.C, TemperatureUnit.F);
        double fToK = converter.convert(100, TemperatureUnit.F, TemperatureUnit.K);
        double kToC = converter.convert(100, TemperatureUnit.K, TemperatureUnit.C);

        System.out.printf("100 C -> F = %.2f%n", cToF);
        System.out.printf("100 F -> K = %.2f%n", fToK);
        System.out.printf("100 K -> C = %.2f%n", kToC);
    }
}