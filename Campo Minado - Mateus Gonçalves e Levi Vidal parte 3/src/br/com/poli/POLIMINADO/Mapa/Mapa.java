package br.com.poli.POLIMINADO.Mapa;

import java.util.Random;

import br.com.poli.POLIMINADO.Celula;

public abstract class Mapa {
	private Celula[][] campo;
	private int tamanho;
	private boolean fimDeJogo = false;
	private boolean ganhouJogo = false;
	private int bombas;
	private int celulasVisiveis;

	public Mapa(int tamanho, int bombas) { // Construtor que inicializa o campo com o tamanho adequado, de acordo com a
											// dificuldade selecionada e distribui as bombas em posições aleatórias.
		this.tamanho = tamanho;
		this.campo = new Celula[tamanho][tamanho];
		this.bombas = bombas;
		this.inicializarCelulas();
		this.distribuirBombas(bombas);
		this.contarBombas();
		this.imprimeTela(false);

	}

	public void distribuirBombas(int bombas) {

		Random gerador = new Random();
		int x = 0;
		int y = 0;

		for (int cont = 0; cont < bombas; cont++) {

			x = gerador.nextInt(this.tamanho); // Posição x (linha) da matriz sendo aleatoriezada através do
												// nextInt que gera um inteiro aleatório.
			y = gerador.nextInt(this.tamanho); // Posição y (coluna) da matriz sendo aleatoriezada através do
												// nextInt que gera um inteiro aleatório.

			if (this.campo[x][y].isBomba()) { // Caso a posição selecionada já esteja preenchida com uma bomba, o
												// contador diminui para 10 bombas serem inseridas no campo.
				cont--;
			}

			this.campo[x][y].setBomba(true); // Insere uma bomba na posição aleatória gerada através do nexInt caso a
												// mesma não contenha uma.
		}

	}

	public void inicializarCelulas() { // Preenche a matriz Campo com uma nova célula em cada posição.
		for (int i = 0; i < this.tamanho; i++) {
			for (int j = 0; j < this.tamanho; j++) {
				this.campo[i][j] = new Celula(i, j);
			}
		}

		for (int i = 0; i < this.tamanho; i++) { // Ao inicializar as células, é também preenchido o arraylist de
													// vizinhos de cada uma delas.
			for (int j = 0; j < this.tamanho; j++) {
				this.campo[i][j].buscarVizinhos(this.campo);
			}
		}
	}

	public void imprimeTela(boolean teste) { // Método que imprime a matriz com dois modos: o teste, que imprime todas
												// as posições,
												// e o "não-teste", que mostra apenas o que é visível. Com "-1"s sendo
												// impressos caso a célula seja uma bomba
												// ou a quantidade de bombas vizinhas, caso a célula não seja uma bomba.

		for (int i = 0; i < (this.tamanho); i++) {

			for (int j = 0; j < (this.tamanho); j++) {
				if (teste) {
					if (this.campo[i][j].isBomba()) {
						System.out.print(" -1");
					} else {
						System.out.print("  " + this.campo[i][j].getQtdBombasVizinhas());
					}
				} else {
					if (this.campo[i][j].isVisivel()) {
						if (this.campo[i][j].isBomba()) {
							System.out.print("-1  ");
						} else {
							System.out.print(this.campo[i][j].getQtdBombasVizinhas() + "  ");
						}
					} else {
						System.out.print("?  ");
					}
				}

			}
			System.out.println();

		}

	}

	public void contarBombas() { // Método que percorre a matriz campo e checa as oito posições em volta de todas
									// as bombas e atribui às células vizinhas
									// um valor ao seu atributo qtdBombasVizinhas, caso as mesmas não sejam uma
									// bomba.

		for (int i = 0; i < (this.tamanho); i++) {

			for (int j = 0; j < (this.tamanho); j++) {

				if (this.campo[i][j].isBomba()) {
					if (i - 1 >= 0 && !this.campo[i - 1][j].isBomba()) {
						this.campo[i - 1][j].setQtdBombasVizinhas(this.campo[i - 1][j].getQtdBombasVizinhas() + 1);
					}
					if (i + 1 <= this.tamanho - 1 && !this.campo[i + 1][j].isBomba()) {
						this.campo[i + 1][j].setQtdBombasVizinhas(this.campo[i + 1][j].getQtdBombasVizinhas() + 1);
					}
					if (j - 1 >= 0 && !this.campo[i][j - 1].isBomba()) {
						this.campo[i][j - 1].setQtdBombasVizinhas(this.campo[i][j - 1].getQtdBombasVizinhas() + 1);
					}
					if (j + 1 <= this.tamanho - 1 && !this.campo[i][j + 1].isBomba()) {
						this.campo[i][j + 1].setQtdBombasVizinhas(this.campo[i][j + 1].getQtdBombasVizinhas() + 1);
					}
					if (i + 1 <= this.tamanho - 1 && j + 1 <= this.tamanho - 1 && !this.campo[i + 1][j + 1].isBomba()) {
						this.campo[i + 1][j + 1]
								.setQtdBombasVizinhas(this.campo[i + 1][j + 1].getQtdBombasVizinhas() + 1);
					}
					if (i - 1 >= 0 && j - 1 >= 0 && !this.campo[i - 1][j - 1].isBomba()) {
						this.campo[i - 1][j - 1]
								.setQtdBombasVizinhas(this.campo[i - 1][j - 1].getQtdBombasVizinhas() + 1);
					}
					if (i - 1 >= 0 && j + 1 <= this.tamanho - 1 && !this.campo[i - 1][j + 1].isBomba()) {
						this.campo[i - 1][j + 1]
								.setQtdBombasVizinhas(this.campo[i - 1][j + 1].getQtdBombasVizinhas() + 1);
					}
					if (i + 1 <= this.tamanho - 1 && j - 1 >= 0 && !this.campo[i + 1][j - 1].isBomba()) {
						this.campo[i + 1][j - 1]
								.setQtdBombasVizinhas(this.campo[i + 1][j - 1].getQtdBombasVizinhas() + 1);
					}
				}

			}

		}

	}

	public void escolherPosicao(int i, int j) { // Método que escolhe uma posição para tornar visível através do
												// parâmetros (i - linha , j- coluna).
		if (campo[i][j].isBomba()) { // Caso a posição seja uma bomba, o jogo é encerrado através do fimDejogo =
										// true, e imprime a msg de gameover na tela.
			campo[i][j].setVisivel(true);

			this.fimDeJogo = true;
			System.out.println("Fim de Jogo. Você perdeu!");

		}

		else if (campo[i][j].getQtdBombasVizinhas() != 0 && campo[i][j].isBomba() == false) { // Caso a célula seja não
																								// nula e não bomba, ela
																								// apenas torna-se
																								// visível.

			this.celulasVisiveis++;

			campo[i][j].setVisivel(true);

			if (!this.ganhouJogo) {
				this.imprimeTela(false);
			}

		}

		else if (campo[i][j].getQtdBombasVizinhas() == 0 && campo[i][j].isBomba() == false) {
// Caso a célula seja um "0", chama-se a função revelarEspacos.
			this.revelarEspacos(campo[i][j]);

			if (!this.ganhouJogo) {
				this.imprimeTela(false);
			}
		}
		this.ganhouJogo = verificarGanhouJogo();
	}

	private void revelarEspacos(Celula celulaEscolhida) {

		if (celulaEscolhida.isEmBranco() && !celulaEscolhida.isVisivel()) { // Caso a celulaEscolhida esteja em branco e
																			// não seja visível
			celulaEscolhida.setVisivel(true); // Ela se torna visível
			this.celulasVisiveis++;
			for (int i = 0; i < celulaEscolhida.getVizinhos().size(); i++) { // E chama o método de forma recursiva para
																				// seus vizinhos
				this.revelarEspacos(celulaEscolhida.getVizinhos().get(i));

			}
		} else if (!celulaEscolhida.isEmBranco() && !celulaEscolhida.isVisivel()) { // Caso o vizinho chamado de forma
																					// recursiva seja uma célula não
																					// nula ela apenas torna-se visível.
			celulaEscolhida.setVisivel(true);
			this.celulasVisiveis++;
		}

	}

	private boolean verificarGanhouJogo() { // Verifica se o jogo está finalizado através do contador de
											// celulasVisiveis.
		if (this.celulasVisiveis >= (this.tamanho * this.tamanho) - this.bombas) {

			System.out.println("Você ganhou o jogo!");
			return true;
		} else {
			return false;
		}
	}

	public Celula getCelula(int linha, int coluna) { // getCelula

		return this.campo[linha][coluna];

	}

	public boolean isFimDeJogo() { // Getters e setters dos atributos da classe.
		return this.fimDeJogo;
	}

	public boolean isGanhouJogo() {
		return this.ganhouJogo;
	}

	public int getBombas() {
		return this.bombas;
	}

	public int getCelulasVisiveis() {
		return this.celulasVisiveis;
	}

	public Celula[][] getCampo() {
		return this.campo;
	}

	public void setCampo(Celula[][] campo) {
		this.campo = campo;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

}
