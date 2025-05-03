package helpdesk2.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import helpdesk2.domains.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Long>{

}
