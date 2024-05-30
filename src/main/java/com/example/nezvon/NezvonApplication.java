package com.example.nezvon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import redis.clients.jedis.Jedis;

import java.util.Set;

@SpringBootApplication
@EnableCaching
public class NezvonApplication {

	public static void main(String[] args) {
		SpringApplication.run(NezvonApplication.class, args);
		Jedis jedis = new Jedis("localhost", 6379);

		// Получение всех ключей
		Set<String> keys = jedis.keys("cat::*");

		// Получение и вывод значений для каждого ключа
		for (String key : keys) {
			String value = jedis.get(key);
			System.out.println(key + ": " + value);
			jedis.expire(key, 300); // Установка TTL на 5 минут (300 секунд
		}

		// Закрытие соединения
		jedis.close();
	}
	}


