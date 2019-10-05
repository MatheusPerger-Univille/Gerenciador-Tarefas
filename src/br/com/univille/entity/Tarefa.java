package br.com.univille.entity;

import java.util.Date;

public class Tarefa {

	private int id;
	private String titulo;
	private String descricao;
	private boolean realizada;
	private Date data;
	private int prioridade;
	private int usuario_id;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public boolean isRealizada() {
		return realizada;
	}
	
	public void setRealizada(boolean realizada) {
		this.realizada = realizada;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public int getPrioridade() {
		return prioridade;
	}
	
	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}
	
	public int getUsuario_id() {
		return usuario_id;
	}
	
	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}
	
	@Override
	public String toString() {
		String str =  "Tarefa n°: " + getId() + "\n"
					+ "Titulo: " + getTitulo() + "\n"
					+ "Descrição: " + getDescricao() + "\n"
					+ "Data prazo: " + getData() + "\n"
					+ "Prioridade: " + getPrioridade() + "\n"
					+ "Usuário ID: " + getUsuario_id() + "\n"
					+ "Tarefa realizada? " + ((isRealizada()) ? "Sim" : "Não")
					+ "\n";
		
		return str;
	}
}
