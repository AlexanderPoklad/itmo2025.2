package ru.itmo.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.itmo.jpa.model.City;
import ru.itmo.jpa.model.Country;
import ru.itmo.jpa.repository.CityRepository;
import ru.itmo.jpa.repository.CountryRepository;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class SpringWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebApplication.class, args);
	}
}