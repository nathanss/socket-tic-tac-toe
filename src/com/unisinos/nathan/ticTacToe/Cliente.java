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