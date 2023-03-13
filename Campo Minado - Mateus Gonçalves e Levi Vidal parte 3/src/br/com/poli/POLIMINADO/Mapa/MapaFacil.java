package br.com.poli.POLIMINADO.Mapa;

public class MapaFacil extends Mapa { // Classe concreta que extende de Mapa, mas inicia um mapa fácil através do
										// construtor, chamando o super com suas constantes.

	private static final int TAMANHO = 9;
	private static final int BOMBAS = 10;

	public MapaFacil() {
		super(TAMANHO, BOMBAS);

	}

}
