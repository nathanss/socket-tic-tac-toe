package ExemplosSockets.chat;

import java.io.*;
import java.net.Socket;

public class Cliente {
	public static void main (String argv[]) throws Exception {
		String input;
		String nome;
		int socket;

		BufferedReader doUsuario = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Digite qual o seu socket: ");
		socket = Integer.parseInt(doUsuario.readLine());
		
		System.out.println("Digite qual o seu nome: ");
		nome = doUsuario.readLine();
		
		Socket socketCliente = new Socket("127.0.0.1", socket);
		ObjectOutputStream paraServidor = new ObjectOutputStream(socketCliente.getOutputStream());
		ObjectInputStream doCliente = new ObjectInputStream(socketCliente.getInputStream()); 
		
		while (true) {
			System.out.println("Digite a mensagem: ");
			input = doUsuario.readLine();
			Mensagem mensagem = new Mensagem(nome, input);
			paraServidor.writeObject(mensagem);
			mensagem = (Mensagem) doCliente.readObject();
			System.out.println(mensagem.getUsuario() + ": " + mensagem.getMensagem());
			
		}
		
		
		

	}
}