package helpdesk2.repositores;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import helpdesk2.domains.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
	Optional<Pessoa> findByCpf(String cpf);
	Optional<Pessoa> findByEmail(String email);

}
