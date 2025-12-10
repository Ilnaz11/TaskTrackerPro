package ru.baymukhametov.TaskTrackerPro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "ru.baymukhametov.TaskTrackerPro")
@SpringBootApplication
public class TaskTrackerProApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskTrackerProApplication.class, args);
	}
}
//•	логирование действий в консоль.