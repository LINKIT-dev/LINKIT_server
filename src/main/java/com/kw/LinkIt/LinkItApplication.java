package com.kw.LinkIt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * DataSourceAutoConfiguration : DB 설정 시 삭제 후 application.properties 지정해줘야 한다.
 */
@SpringBootApplication
@EnableJpaAuditing
@EnableFeignClients
public class LinkItApplication {

	public static void main(String[] args) {
		SpringApplication.run(LinkItApplication.class, args);
	}

}
