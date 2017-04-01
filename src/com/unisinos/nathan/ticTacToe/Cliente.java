package com.unisinos.nathan.ticTacToe;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Cliente {
	public static void main(String argv[]) throws Exception {
		String input;
		int socket = argv.length > 0 ? Integer.parseInt(argv[0]) : 6789;
		
		BufferedReader doUsuario = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("****COMO JOGAR****");
		System.out.println("Na sua vez, digite sua jogada no seguinte formato:");
		System.out.println("<jogada>,<coordenada_x>,<coordenada_y>");
		System.out.println("Valores de jogada válidos: X e O maiúsculos");
		System.out.println("Valores de coordenadas válidos: de 0 a 2, desde que os espaços que estejam vazios");
		System.out.println("O jogador da porta 6789 começa primeiro");
		System.out.println("Para perguntar ao servidor o status atual do jogo, aperte enter sem passar nenhum texto");

		
		

		while (true) {
			Socket socketCliente = new Socket("127.0.0.1", socket);
			DataOutputStream paraServidor = new DataOutputStream(socketCliente.getOutputStream());
			ObjectInputStream doServidor = new ObjectInputStream(socketCliente.getInputStream());
			System.out.println("Digite a jogada: ");
			input = doUsuario.readLine();
			paraServidor.writeBytes(input + "\n");
			paraServidor.flush();
			Mensagem mensagem = (Mensagem) doServidor.readObject();
			System.out.println(mensagem.getTexto());

		}
	}
}