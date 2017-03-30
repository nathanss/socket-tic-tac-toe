package com.unisinos.nathan.ticTacToe;

public enum Jogada {
	X("X"), O("O"), VAZIO(" ");
	
	private String jogada;

	private Jogada(String jogada) {
		this.jogada = jogada;
	}
	
	public String toString() {
		return jogada;
	}
}
