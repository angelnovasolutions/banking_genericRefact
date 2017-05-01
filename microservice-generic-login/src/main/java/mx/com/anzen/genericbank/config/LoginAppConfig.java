package mx.com.anzen.genericbank.config;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import mx.com.anzen.repository.SPRepository;
 

@Configuration
public class LoginAppConfig {
	
	// Realizar la inyección de dependencia para el repositorio de persistencia
	@Bean
    public SPRepository entityManager() {
        return new SPRepository();
    }
	
}
