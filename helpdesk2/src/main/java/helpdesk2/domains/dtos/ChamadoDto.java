package helpdesk2.domains.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import helpdesk2.domains.Chamado;

public class ChamadoDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	@JsonFormat(pattern = "dd/M/yyyy")
	private LocalDate data_abertura = LocalDate.now();
	@JsonFormat(pattern = "dd/M/yyyy")
	private LocalDate data_fechamento;
	private Integer prioridade;
	private Integer status;
	private String titulo;
	private String observacoes;
	private Long tecnico;
	private Long cliente;
	private String nomeTecnico;
	private String nomeCliente;
	public ChamadoDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChamadoDto(Chamado obj) {
		super();
		this.id = obj.getId();
		this.data_abertura = obj.getData_abertura();
		this.data_fechamento = obj.getData_fechamento();
		this.prioridade = obj.getPrioridade().getCodigo();
		this.status = obj.getStatus().getCodigo();
		this.titulo = obj.getTitulo();
		this.observacoes = obj.getObservacoes();
		this.tecnico = obj.getTecnico().getId();
		this.cliente = obj.getCliente().getId();
		this.nomeTecnico = obj.getTecnico().getNome();
		this.nomeCliente = obj.getCliente().getNome();
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
	public Integer getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(Integer prioridade) {
		this.prioridade = prioridade;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
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
	public Long getTecnico() {
		return tecnico;
	}
	public void setTecnico(Long tecnico) {
		this.tecnico = tecnico;
	}
	public Long getCliente() {
		return cliente;
	}
	public void setCliente(Long cliente) {
		this.cliente = cliente;
	}
	public String getNomeTecnico() {
		return nomeTecnico;
	}
	public void setNomeTecnico(String nomeTecnico) {
		this.nomeTecnico = nomeTecnico;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	
	
	

}
