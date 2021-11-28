package com.example.cursomc.domin.enums;

public enum TipoCliente {
	PESSOAFISICA(1, "PESSOA FÍSICA"),
	PESSOAJURIDICA(2, "PESSOA JURÍDICA");
	
	private int cod;
	private String descricao;
	
	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static TipoCliente toEnem(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(TipoCliente x :TipoCliente.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
			
		}
		
		throw new IllegalArgumentException("Id inválido " + cod);
	}
}
