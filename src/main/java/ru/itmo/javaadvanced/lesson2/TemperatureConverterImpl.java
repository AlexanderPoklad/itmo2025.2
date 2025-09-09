package ru.itmo.javaadvanced.lesson2;

import org.springframework.stereotype.Service;

@Service

public class TemperatureConverterImpl implements TemperatureConverter {

    @Override

    public double convert(double value, String from, String to) {
        from = from.toUpperCase();
        to = to.toUpperCase();

        double celsius;
        switch (from) {
            case "C":
                celsius = value;
                break;
            case "F":
                celsius = (value - 32) * 5 / 9;
                break;
            case "K":
                celsius = value - 273.15;
                break;
            default:
                throw new IllegalArgumentException("Неизвестная система: " + from);
        }

        switch (to) {
            case "C":
                return celsius;
            case "F":
                return celsius * 9 / 5 + 32;
            case "K":
                return celsius + 273.15;
            default:
                throw new IllegalArgumentException("Неизвестная система: " + to);
        }
    }
}