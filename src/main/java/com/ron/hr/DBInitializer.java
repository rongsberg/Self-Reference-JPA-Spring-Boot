package com.ron.hr;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class DBInitializer {

	@Bean
	CommandLineRunner initDatabase(HRDAO dao) {
		return args -> {
			log.info("saving to DB:"+dao.save(new Associate("Ron")));
            log.info("saving to DB:"+dao.save(new Associate("Jenna")));
		};
	}
}