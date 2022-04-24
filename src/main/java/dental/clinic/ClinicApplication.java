package dental.clinic;

import dental.clinic.entities.ERole;
import dental.clinic.entities.Role;
import org.apache.log4j.PropertyConfigurator;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ClinicApplication {

	@Bean //Crea un "componente" para que spring lo reconozca
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}


	public static void main(String[] args) {
		PropertyConfigurator.configure("log4j.properties");
		SpringApplication.run(ClinicApplication.class, args);
	}


}

