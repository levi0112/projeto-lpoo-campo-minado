package br.com.poli.POLIMINADO;

import br.com.poli.POLIMINADO.Mapa.Mapa;

import br.com.poli.POLIMINADO.Mapa.MapaDificil;
import br.com.poli.POLIMINADO.Mapa.MapaFacil;
import br.com.poli.POLIMINADO.Mapa.MapaMedio;
import java.util.Scanner;

public class CampoMinado { // Classe CampoMinado com Mapa, Jogador e Dificuldade como atributos.
	private Jogador jogador;
	private Mapa mapa;
	private Dificuldade dificuldade;

	public CampoMinado(String nome, Dificuldade dificuldade) { // Construtor que inicializa um CampoMinado com nome do
																// jogador e dificuldade como parâmetros
		this.dificuldade = dificuldade; // e inicia um mapa chamando seu construtor com a dificuldade passada nos
										// parâmetros.
		this.jogador = new Jogador(nome);

		if (dificuldade.getValor() == 9) {
			this.mapa = new MapaFacil();
		}

		else if (dificuldade.getValor() == 16) {
			this.mapa = new MapaMedio();
		} else if (dificuldade.getValor() == 32) {
			this.mapa = new MapaDificil();
		}

	}

	public void iniciarJogo() { // Método que inicia o jogo, pedindo constantemente posições para serem
								// escolhidas pelo jogador,
								// e passadas ao escolherPosicao(i,j), enquanto fimdejogo e ganhoujogo forem
								// falsos(até que o jogador perca ou ganhe).
		Scanner ler = new Scanner(System.in); // abertura do scanner

		while (!this.mapa.isFimDeJogo() && !this.mapa.isGanhouJogo()) {

			int i, j;
			System.out.println("Digite a linha:");
			i = ler.nextInt(); // leitura da linha
			System.out.println("Digite a coluna:");
			j = ler.nextInt(); // leitura da coluna

			if (i < this.mapa.getTamanho() && j < this.mapa.getTamanho()) { // chamada do escolherPosicao só é feita se
																			// não exceder os limites do tamanho do
																			// mapa.
				this.mapa.escolherPosicao(i, j);
			}

		}
		ler.close(); // fechamento do scanner

	}

	public Jogador getJogador() { // Getters e Setters dos atributos de CampoMinado.
		return this.jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public Mapa getMapa() {
		return this.mapa;
	}

	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
	}

	public Dificuldade getDificuldade() {
		return this.dificuldade;
	}

	public void setDificuldade(Dificuldade dificuldade) {
		this.dificuldade = dificuldade;
	}

}
