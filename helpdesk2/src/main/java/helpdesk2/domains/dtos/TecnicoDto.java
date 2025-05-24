package helpdesk2.domains.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import helpdesk2.domains.Tecnico;
import helpdesk2.domains.enumns.Perfil;

public class TecnicoDto implements Serializable {

	private static final long serialVersionUID = 1L;

	protected Long id;
	@NotNull(message = "O campo nome é requerido!!")
	protected String nome;
	@NotNull(message = "O campo cpf é requerido!!")
	protected String cpf;
	@NotNull(message = "O campo Email é requerido!!")
	protected String email;
	@NotNull(message = "O campo senha é requerido!!")
	protected String senha;

	protected Set<Integer> perfis = new HashSet<>();

	@JsonFormat(pattern = "dd/M/yyyy")
	protected LocalDate data_criacao = LocalDate.now();

	public TecnicoDto() {
		super();
		AddPerfil(Perfil.CLIENTE); 
	}

	public TecnicoDto(Tecnico obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.perfis = obj.getPerfis().stream().map(x-> x.getCodigo()).collect(Collectors.toSet());
		this.data_criacao = obj.getData_criacao();
		AddPerfil(Perfil.CLIENTE); 
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x-> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void AddPerfil(Perfil perfil) {
		this.perfis.add(perfil.getCodigo());
	}

	public LocalDate getData_criacao() {
		return data_criacao;
	}

	public void setData_criacao(LocalDate data_criacao) {
		this.data_criacao = data_criacao;
	}
	
	
	
	
	
	

}
