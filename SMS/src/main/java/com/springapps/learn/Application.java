package com.springapps.learn;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
@Controller
public class Application {

	@Value("${phoneNumber:** Todo: buy a phone number from Twilio **}")
	private String phoneNumber;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@GetMapping("/")
	public ModelAndView hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		ModelAndView home = new ModelAndView("home");
		home.addObject("phoneNumber", phoneNumber);
		return home;
	}
}
