package helpdesk2.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import helpdesk2.domains.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
