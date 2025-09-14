package ru.itmo.javaadvanced.lesson3;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.itmo.javaadvanced.lesson3.service.FibonacciService;

import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class FibRunner implements CommandLineRunner {

    private final FibonacciService fibonacciService;

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Введите n (или -1 для выхода): ");
            int n;
            try {
                n = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Ошибка: введено не число. Попробуйте снова.");
                scanner.nextLine();
                continue;
            }

            if (n == -1) {
                System.out.println("Выход из программы.");
                break;
            }

            try {
                long result = fibonacciService.calculate(n);
                System.out.println("F(" + n + ") = " + result);
                System.out.println("Кэш сейчас: " + fibonacciService.getCache());
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }
}