package br.com.univille.entity;

public class Usuario {

	private int id;
	private String nome;
	private String email;
	private String login;
	private String senha;
	private boolean ativo;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean isAtivo() {
		return ativo;
	}
	
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	@Override
	public String toString() {
		String str =  "C�digo�: " + getId() + "\n"
				+ "Nome: " + getNome() + "\n"
				+ "E-mail: " + getEmail() + "\n"
				+ "Login: " + getLogin() + "\n"
				+ "Senha: " + getSenha() + "\n"
				+ "Status? " + ((isAtivo()) ? "Ativo" : "Inativo");
	
		return str;
	}
}
