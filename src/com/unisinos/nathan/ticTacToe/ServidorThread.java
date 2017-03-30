package com.unisinos.nathan.ticTacToe;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorThread implements Runnable {
	
	int port;
	Grade grade;
	
	public ServidorThread(int port) {
		this.port = port;
	}
	
	@Override
	public void run() {
		ServerSocket socketRecepcao;
		try {
			socketRecepcao = new ServerSocket(port);
			while (true) {
				Socket socketConexao = socketRecepcao.accept(); //chamada bloqueante
				BufferedReader doCliente = new BufferedReader(new InputStreamReader(socketConexao.getInputStream())); //espera no formato caracter,x,y
				ObjectOutputStream paraCliente = new ObjectOutputStream(socketConexao.getOutputStream());
				String line = doCliente.readLine();
				String[] args = line.split(",");
				Mensagem mensagem;
				try {
					grade.jogar(Jogada.valueOf(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]), this);
					mensagem = new Mensagem(grade.toString());
					
				} catch (JogadaInvalidaException e) {
					mensagem = new Mensagem("Jogada inválida!");
				}
				paraCliente.writeObject(mensagem);
			}
			
			
			
			
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void setGrade(Grade grade) {
		this.grade = grade;
	}

}
