package com.unisinos.nathan.ticTacToe;

import static org.junit.Assert.*;

import org.junit.Test;

public class GradeTest {

	@Test
	public void test() throws JogadaInvalidaException {
		Grade grade = new Grade();
		grade.jogar(Jogada.X, 0, 0);
		System.out.println(grade);
	}

}
