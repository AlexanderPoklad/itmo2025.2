package ru.itmo.spring_database;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itmo.spring_database.dao.CityDao;
import ru.itmo.spring_database.model.City;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class SpringDatabaseApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDatabaseApplication.class, args);
		CityDao dao = context.getBean(CityDao.class);

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1 - Добавить город, 2 - Показать города, 0 - Выход");
			int choice = sc.nextInt();
			sc.nextLine();

			if (choice == 1) {
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

				dao.save(city);
				System.out.println("Город добавлен!");
			} else if (choice == 2) {
				List<City> cities = dao.findAll();
				cities.forEach(System.out::println);
			} else if (choice == 0) {
				break;
			}
		}
	}
}