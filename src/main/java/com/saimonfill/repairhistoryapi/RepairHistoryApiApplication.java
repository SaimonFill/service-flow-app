package com.saimonfill.repairhistoryapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class})
public class RepairHistoryApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RepairHistoryApiApplication.class, args);
	}

//	@Bean
//	ApplicationRunner runner(PasswordEncoder passwordEncoder) {
//		return args -> System.out.println(passwordEncoder.encode("password"));
//	}

}
