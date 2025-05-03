package helpdesk2.domains;

import java.time.LocalDate;
import java.util.Objects;

import helpdesk2.domains.enumns.Prioridade;
import helpdesk2.domains.enumns.Status;

public class Chamado {
	private Long id;
	private LocalDate data_abertura = LocalDate.now();
	private LocalDate data_fechamento;
	private Prioridade prioridade;
	private Status status;
	private String titulo;
	private String observacoes;
	private Tecnico tecnico;
	private Cliente cliente;

	

	public Chamado(Long id, Prioridade prioridade, Status status, String titulo, String observacoes, Tecnico tecnico,
			Cliente cliente) {
		super();
		this.id = id;
		this.prioridade = prioridade;
		this.status = status;
		this.titulo = titulo;
		this.observacoes = observacoes;
		this.tecnico = tecnico;
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chamado other = (Chamado) obj;
		return Objects.equals(id, other.id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getData_abertura() {
		return data_abertura;
	}

	public void setData_abertura(LocalDate data_abertura) {
		this.data_abertura = data_abertura;
	}

	public LocalDate getData_fechamento() {
		return data_fechamento;
	}

	public void setData_fechamento(LocalDate data_fechamento) {
		this.data_fechamento = data_fechamento;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Prioridade getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}

}
