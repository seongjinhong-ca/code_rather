package io.github.seongjinhong_ca.code_rather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class CodeRatherApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeRatherApplication.class, args);
	}

}
