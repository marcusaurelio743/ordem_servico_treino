package helpdesk2.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import helpdesk2.domains.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
