package BrandonOrellana_20240208.BrandonOrellana_20240208;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BrandonOrellana20240208Application {

	public static void main(String[] args) {

		Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
		dotenv.entries().forEach(entry ->
				System.setProperty(entry.getKey(),entry.getValue()));

		SpringApplication.run(BrandonOrellana20240208Application.class, args);
	}

}
