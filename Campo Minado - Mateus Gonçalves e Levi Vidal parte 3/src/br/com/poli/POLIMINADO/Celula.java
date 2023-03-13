package br.com.poli.POLIMINADO;

import java.util.ArrayList;

public class Celula { // Cria��o da classe c�lula, classe que comp�em o array formado em campo.
	private boolean bandeira;
	private boolean bomba;
	private int qtdBombasVizinhas;
	private boolean visivel;
	private int linha;
	private int coluna;
	private ArrayList<Celula> vizinhos = new ArrayList<Celula>(); // Arraylist de vizinhos da c�lula.

	public Celula(int linha, int coluna) { // Construtor da c�lula, com linha e coluna j� especificadas.
		this.linha = linha;
		this.coluna = coluna;
	}

	public void buscarVizinhos(Celula[][] campo) { // M�todo que adiciona em uma lista todos os vizinhos da c�lula.
		for (int x = -1; x <= 1; x++) {
			for (int y = -1; y <= 1; y++) {
				if (x + this.linha >= 0 && x + this.linha < campo.length && this.coluna + y >= 0
						&& this.coluna + y < campo.length) {
					vizinhos.add(campo[x + this.linha][y + this.coluna]);
				}
			}
		}
	}

	public boolean isEmBranco() { // M�todo que checa se a c�lula � um "0".
		if (this.qtdBombasVizinhas == 0) {
			return true;
		} else {
			return false;
		}
	}

	// getters e setters dos atributos de Celula.

	public boolean isBandeira() {
		return bandeira;
	}

	public void setBandeira(boolean bandeira) {
		this.bandeira = bandeira;
	}

	public boolean isBomba() {
		return bomba;
	}

	public void setBomba(boolean bomba) {
		this.bomba = bomba;
	}

	public int getQtdBombasVizinhas() {
		return qtdBombasVizinhas;
	}

	public void setQtdBombasVizinhas(int qtdBombasVizinhas) {
		this.qtdBombasVizinhas = qtdBombasVizinhas;
	}

	public boolean isVisivel() {
		return visivel;
	}

	public void setVisivel(boolean visivel) {
		this.visivel = visivel;
	}

	public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public int getColuna() {
		return coluna;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}

	public ArrayList<Celula> getVizinhos() {
		return vizinhos;
	}

	public void setVizinhos(ArrayList<Celula> vizinhos) {
		this.vizinhos = vizinhos;
	}
}
