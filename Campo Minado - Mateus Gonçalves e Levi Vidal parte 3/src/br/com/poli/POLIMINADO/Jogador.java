package br.com.poli.POLIMINADO;

public class Jogador {
	private String nome;

	public Jogador(String nome) { // Construtor da classe Jogador que inicializa seu nome.
		this.nome = nome;
	
	}

	public String getNome() { // Get do atributo this.nome.
		return this.nome;
	}

	public void setNome(String nome) { // Set do atributo this.nome.
		this.nome = nome;
	}

}
