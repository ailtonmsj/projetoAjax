package com.domain;

public class Municipio {
	
	private String nome;	
	private String uf;	
	private Integer id;
	
	public Municipio(Integer id, String uf, String nome){
		this.id = id;
		this.uf = uf;
		this.nome = nome;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String toString(){
		return nome;
	}
}