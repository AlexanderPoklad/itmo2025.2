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
public class SpringDatabaseApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDatabaseApplication.class, args);
		CityRepository cityRepository = context.getBean(CityRepository.class);
		CountryRepository countryRepository = context.getBean(CountryRepository.class);

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1 - Добавить страну, 2 - Добавить город, 3 - Показать города, 0 - Выход");
			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
				case 1 -> {
					Country country = new Country();
					System.out.print("Код страны: ");
					country.setCode(sc.nextLine());
					System.out.print("Название (RU): ");
					country.setNameRu(sc.nextLine());
					System.out.print("Название (EN): ");
					country.setNameEn(sc.nextLine());

					countryRepository.save(country);
					System.out.println("Страна добавлена!");
				}
				case 2 -> {
					List<Country> countries = countryRepository.findAll();
					if (countries.isEmpty()) {
						System.out.println("Сначала добавьте страну!");
						break;
					}
					System.out.println("Доступные страны:");
					countries.forEach(c -> System.out.println(c.getId() + " - " + c.getNameRu()));

					System.out.print("ID страны: ");
					Long countryId = sc.nextLong();
					sc.nextLine();

					Country country = countryRepository.findById(countryId)
							.orElseThrow(() -> new RuntimeException("Страна не найдена"));

					City city = new City();
					System.out.print("Код города: ");
					city.setCode(sc.nextLine());
					System.out.print("Название (RU): ");
					city.setNameRu(sc.nextLine());
					System.out.print("Название (EN): ");
					city.setNameEn(sc.nextLine());
					System.out.print("Численность: ");
					city.setPopulation(sc.nextInt());
					sc.nextLine();
					city.setCountry(country);

					cityRepository.save(city);
					System.out.println("Город добавлен!");
				}
				case 3 -> {
					List<City> cities = cityRepository.findAll();
					cities.forEach(System.out::println);
				}
				case 0 -> {
					return;
				}
			}
		}
	}
}