package ru.geekbrains.summer.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SummerMarketApplication {
 //черновик домашнее задание 16
//
//	 План по магазину:
//	 1. Привязка корзины к пользователю, подключение Reddis
//	 2. Рассылка писем
//	 3. Админка
//	 4. Swagger
//	 + 5. Фильтры по товарам
//	 6. Маппинг DTO <-> Entity, @EntityGraph
//	 7. Картинки
//	 8. Промо-коды
//	 9. Регистрация

	public static void main(String[] args) {
		SpringApplication.run(SummerMarketApplication.class, args);
	}
}
