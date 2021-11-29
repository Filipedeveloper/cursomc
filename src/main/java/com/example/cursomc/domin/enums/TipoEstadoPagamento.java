package com.example.cursomc.domin.enums;

public enum TipoEstadoPagamento {
	
	PENDETE(1, "PENDENTE"),
	QUITADO(2, "QUITADO"),
	CANCELADO(3, "CANCELADO");
	
	private int cod;
	private String descricao;
	
	TipoEstadoPagamento(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static TipoEstadoPagamento toEnem(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(TipoEstadoPagamento x :TipoEstadoPagamento.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
			
		}
		
		throw new IllegalArgumentException("Id inválido " + cod);
	}
	

}
