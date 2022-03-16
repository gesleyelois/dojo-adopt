package br.com.alura.dojoadopt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@Controller
@SpringBootApplication
public class DojoAdoptApplication {

	public static void main(String[] args) {
		SpringApplication.run(DojoAdoptApplication.class, args);
	}

}
