package com.unisinos.nathan.ticTacToe;

import java.util.ArrayList;

public class Grade {
	Jogada[][] tabuleiro;
	private Jogada algarismoGanhador;
	private ArrayList<ServidorThread> jogadores;
	private int indiceJogadorAtual;
	
	public Jogada getAlgarismoGanhador() {
		return algarismoGanhador;
	}
	public Grade(ArrayList<ServidorThread> jogadores) {
		indiceJogadorAtual = 0;
		this.jogadores = jogadores;
		tabuleiro = new Jogada[3][3];
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[i].length; j++) {
				tabuleiro[i][j] = Jogada.VAZIO;
			}
		}
	}
	public void jogar(Jogada jogada, int x, int y, ServidorThread jogador) throws JogadaInvalidaException {
		if ((tabuleiro[x][y] == Jogada.VAZIO) && jogador == jogadores.get(indiceJogadorAtual)) {
			tabuleiro[x][y] = jogada;
			indiceJogadorAtual = (indiceJogadorAtual + 1) % jogadores.size();
		} else {
			throw new JogadaInvalidaException();
		}
	}
	
	public String toString() {
		String tela = "";
		for (int i = 0; i < tabuleiro.length; i++) {
			tela += "| ";
			for (int j = 0; j < tabuleiro[i].length; j++) {
				tela += tabuleiro[i][j].toString() + " | ";
			}
			tela += "\n";
		}
		return tela;
	}
	
	public boolean jogoAcabou() {
		//acabou se nao ha mais o que preencher ou se tem 3 X ou O seguidos
		return !aindaHaEspaco() || alguemGanhou();
	}
	private boolean alguemGanhou() {
		for (int i = 0; i < tabuleiro.length; i++) { //olhando as linhas
			if (tabuleiro[i][0] != Jogada.VAZIO &&tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][1]  == tabuleiro[i][2]) {
				this.algarismoGanhador = tabuleiro[i][0];
				return true;
			}
		}
		for (int i = 0; i < tabuleiro.length; i++) { //olhando as colunas
			if (tabuleiro[0][i] != Jogada.VAZIO &&tabuleiro[0][i] == tabuleiro[1][i] && tabuleiro[1][i]  == tabuleiro[2][i]) {
				this.algarismoGanhador = tabuleiro[0][i];
				return true;
			}
		}
		
		if (tabuleiro[0][0] != Jogada.VAZIO && tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2]) { //diagonal principal
			this.algarismoGanhador = tabuleiro[0][0];
			return true;
		}
		
		if (tabuleiro[0][2] != Jogada.VAZIO && tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0]) { //diagonal secundária
			this.algarismoGanhador = tabuleiro[0][2];
			return true;
		}
		
		return false;
		
	}
	private boolean aindaHaEspaco() {
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[i].length; j++) {
				if (tabuleiro[i][j] != Jogada.VAZIO) {
					return true;
				}
			}
		}
		return false;
	}
}
