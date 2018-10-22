package com.domain;

public class Estado {
	
	public Estado(Integer id, String uf, String nome){
		this.id = id;
		this.uf = uf;
		this.nome = nome;
	}

	private String nome;	
	private String uf;	
	private Integer id;
	
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
