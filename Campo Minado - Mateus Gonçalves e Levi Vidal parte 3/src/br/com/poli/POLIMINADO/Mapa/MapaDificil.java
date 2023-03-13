package br.com.poli.POLIMINADO.Mapa;

public class MapaDificil extends Mapa { // Classe concreta que extende de Mapa, mas inicia um mapa difícil através do
										// construtor, chamando o super com suas constantes.

	private static final int TAMANHO = 32;
	private static final int BOMBAS = 99;

	public MapaDificil() {
		super(TAMANHO, BOMBAS);

	}

}
