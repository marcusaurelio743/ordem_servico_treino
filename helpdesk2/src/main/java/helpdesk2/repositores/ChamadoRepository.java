package helpdesk2.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import helpdesk2.domains.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Long>{

}
