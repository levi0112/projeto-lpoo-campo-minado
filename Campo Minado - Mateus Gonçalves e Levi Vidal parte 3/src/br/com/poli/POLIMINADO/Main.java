package br.com.poli.POLIMINADO;

import br.com.poli.POLIMINADO.CampoMinado;

public class Main {

	public static void main(String[] args) { // M�todo "Main" que testa o jogo, com um imprimeTela(true), o "modo teste"
												// para servir de orienta��o para o teste.

		CampoMinado m1 = new CampoMinado("Monitor m�tico que vai me dar 100", Dificuldade.FACIL);
		m1.getMapa().imprimeTela(true);
		m1.iniciarJogo();

	}

}
