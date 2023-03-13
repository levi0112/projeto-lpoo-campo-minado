package br.com.poli.POLIMINADO.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.GridLayout;
import javax.swing.JCheckBox;

import br.com.poli.POLIMINADO.CampoMinado;

public class BotaoJogo {

	private int linha, coluna;
	private JButton botao;
	private Jogo jogo;
	private CampoMinado campominado;
	

	public BotaoJogo(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
		this.botao = new JButton();
		
	}
	
	public void botaoDireito(CampoMinado campominado, Jogo jogo) {
	
		botao.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent event) {
				
				if (botao == (JButton) event.getSource()) {

				if (event.getButton() == MouseEvent.BUTTON3) {

				JButton meuBotao = (JButton) event.getSource();

				if ( meuBotao.getText() == "") {

					 meuBotao.setEnabled(false);
					 meuBotao.setText("|>");
					 jogo.getBotoes()[linha][coluna].getBotao().setIcon(new ImageIcon(Jogo.class.getResource("/br/com/poli/POLIMINADO/Resources/bandeira editar 2.jpg")));

				campominado.getMapa().getCelula(linha, coluna).setBandeira(true);

				} else if (botao.getText() == "|>") {

					 meuBotao.setEnabled(true);
					 meuBotao.setText("");
					 jogo.getBotoes()[linha][coluna].getBotao().setIcon(null);

				campominado.getMapa().getCelula(linha, coluna).setBandeira(false);
				
				
				}
				}
				}
				
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			
			
		});
	}
	
   
	public void setAction(CampoMinado campominado, Jogo jogo) {

		botao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (!campominado.getMapa().getCelula(linha, coluna).isVisivel()) {
					campominado.getMapa().escolherPosicao(linha, coluna);
					atualizarBotoes(campominado,jogo);
					if (campominado.getMapa().getCelula(linha,coluna).isBomba()) {
						JOptionPane.showMessageDialog(null,"VOCÊ PERDEU!");
						jogo.dispose();
						Menu menu = new Menu();
						menu.setVisible(true);
					}
					if (campominado.getMapa().isGanhouJogo()) {
						JOptionPane.showMessageDialog(null,"VOCÊ GANHOU PARABENS!");
					}
					
					
				}
				}
							
			
		});

		
		
	}
	
	
	public void exit() {
		System.exit(0);
	}	
	
	
	public void atualizarBotoes(CampoMinado campominado, Jogo jogo) {
		for (int i = 0; i < campominado.getDificuldade().getValor(); i++) {
			for (int j = 0; j < campominado.getDificuldade().getValor(); j++) {
				if(campominado.getMapa().getCelula(i, j).isVisivel()) {
					if(campominado.getMapa().getCelula(i, j).isBomba()) {
					jogo.getBotoes()[i][j].getBotao().setIcon(new ImageIcon(Jogo.class.getResource("/br/com/poli/POLIMINADO/Resources/bomba2.jpg")));
					
				}
					
					else {
					jogo.getBotoes()[i][j].getBotao().setText(Integer.toString(campominado.getMapa().getCelula(i, j).getQtdBombasVizinhas()));
					}
					jogo.getBotoes()[i][j].getBotao().setEnabled(false);
			}
		}
		
		
	}
	
	}
		

	
		
public void setBotao(JButton botao) {
		this.botao = botao;
		
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

	public JButton getBotao() {
		return botao;
	}
}
	

	