package com.unisinos.nathan.ticTacToe;

import java.util.ArrayList;

public class Servidor {
	public static void main(String argv[]) throws Exception {
		
		
		ServidorThread player1 = new ServidorThread(6789);
		ServidorThread player2 = new ServidorThread(6790); 
		ArrayList<ServidorThread> players = new ArrayList<>(2);
		players.add(player1);
		players.add(player2);
		Grade grade = new Grade(players);
		player1.setGrade(grade);
		player2.setGrade(grade);
		
		
		Thread t1 = new Thread(player1);
		Thread t2 = new Thread(player2);
		
		t1.start();
		t2.start();
		
	
		
		

		/*while(true) {
			Socket socketConexao = socketRecepcao.accept(); //chamada bloqueante
			BufferedReader doCliente = new BufferedReader(new InputStreamReader(socketConexao.getInputStream())); //espera no formato caracter,x,y
			String line = doCliente.readLine();
			String[] args = line.split(",");
			grade.jogar(Jogada.valueOf(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
			PrintWriter pw = new PrintWriter(socketConexao.getOutputStream());
			pw.println(grade.toString());
		}*/
	}
}
