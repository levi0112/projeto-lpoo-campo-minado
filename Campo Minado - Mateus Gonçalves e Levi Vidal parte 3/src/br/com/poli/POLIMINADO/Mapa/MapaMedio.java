package br.com.poli.POLIMINADO.Mapa;

public class MapaMedio extends Mapa { // Classe concreta que extende de Mapa, mas inicia um mapa médio através do
										// construtor, chamando o super com suas constantes.

	private static final int TAMANHO = 16;
	private static final int BOMBAS = 40;

	public MapaMedio() {
		super(TAMANHO, BOMBAS);

	}

}
