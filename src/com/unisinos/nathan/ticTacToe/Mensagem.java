package com.unisinos.nathan.ticTacToe;

import java.io.Serializable;

public class Mensagem implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String texto;

	public String getTexto() {
		return texto;
	}

	public Mensagem(String texto) {
		this.texto = texto;
	}
}
