package ru.itmo.javaadvanced.lesson2.service;


import ru.itmo.javaadvanced.lesson2.TemperatureUnit;

public interface TemperatureConverter {
    double convert(double value, TemperatureUnit from, TemperatureUnit to);
}