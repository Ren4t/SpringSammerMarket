package ru.geekbrains.summer.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SummerMarketApplication {
//	 Домашнее задание:13
//	 1. На странице заказов отобразить список и количество продуктов в заказе
//	 2. Ругаться с backend'а если поля адрес или телефон заказа не заполнены
//
//	 Домашнее задание:14
//	 1. Добавить фильтр по максимальной цене
//	 2. Убрать построение спецификаций куда-нибудь из контроллера
//	 3. * Добавить форму фильтра на фронт
//
//	 Домашнее задание:15
//	 1. AOP: С помощью АОП посчитайте по каждому сервису суммарное время,
//	 уходящее на выполнение методов этих сервисов.
//	 И по endpoint'у /statistic выдайте полученную статистику клиенту. Пример:
//	 ProductService: 1200 ms
//	 OrderService: 95 ms
//	 UserService: 2000 ms
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
