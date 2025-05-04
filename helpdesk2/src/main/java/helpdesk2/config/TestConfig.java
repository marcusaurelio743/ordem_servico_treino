package helpdesk2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import helpdesk2.services.DBService;

@Configuration
@Profile("test")
public class TestConfig {
	@Autowired
	private DBService dbService;
	
	@Bean
	public void instanciaDB() {
		//carregar a instancia de db service toda vez que o perfil test for chamado
		this.dbService.InstanciaDB();
	}

}
