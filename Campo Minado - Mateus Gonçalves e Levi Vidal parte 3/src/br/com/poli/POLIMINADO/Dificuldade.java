package br.com.poli.POLIMINADO;

public enum Dificuldade { // "Enum" que serve para a seleção da dificuldade do jogo.
	FACIL(9), MEDIO(16), DIFICIL(32);
	private int valor;

	private Dificuldade(int valor) {
		this.valor = valor;
	}

	public int getValor() { // Get do atributo valor.
		return this.valor;
	}

}
