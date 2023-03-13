package br.com.poli.POLIMINADO.gui;
import br.com.poli.POLIMINADO.CampoMinado;
import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;


import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class Jogo extends JFrame {

	private JPanel contentPane;
	private JPanel panelCampo;
	private BotaoJogo botoes[][];
	private Menu menu;
	private int contador=0;
	private Timer timer;
	private JCheckBox bandeira;
	private CampoMinado campominado;

	public Jogo(CampoMinado campominado) {
		
		
		botoes = new BotaoJogo[campominado.getDificuldade().getValor()][campominado.getDificuldade().getValor()];
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 10, 1350, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelCampo = new JPanel();
		panelCampo.setBounds(10, 51, 1315, 750);
		contentPane.add(panelCampo);
		
		JCheckBox bandeira = new JCheckBox("bandeira");
		bandeira.setBounds(78, 51, 50, 50);
		contentPane.add(bandeira);
		
		
		JLabel lbljogador= new JLabel(campominado.getJogador().getNome());
		lbljogador.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbljogador.setBounds(205, 15, 110, 16);
		contentPane.add(lbljogador);
		lbljogador.setVisible(true);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				menu = new Menu();
				menu.setVisible(true);
			}
		});
		btnMenu.setBounds(908, 17, 89, 23);
		contentPane.add(btnMenu);
		btnMenu.setVisible(true);
		panelCampo.setLayout(new GridLayout(campominado.getDificuldade().getValor(),campominado.getDificuldade().getValor()));
		
		for (int i = 0; i < botoes.length; i++) {
			for (int j = 0; j < botoes.length; j++) {
				botoes[i][j]= new BotaoJogo(i,j);
				botoes[i][j].setAction(campominado, this);
				botoes[i][j].getBotao().setVisible(true);
				panelCampo.add(botoes[i][j].getBotao());
				botoes[i][j].botaoDireito(campominado, this);
				
			}
		}
		
		
	
	
	JLabel timerLabel = new JLabel("00:00");

	timerLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
	timerLabel.setBounds(572, 1, 89, 39);
	contentPane.add(timerLabel);
	timer = new Timer();
	timer.scheduleAtFixedRate(new TimerTask() {
		@Override
		public void run() {
			contador++;
			int segundos = contador % 60;
			int minutos = contador / 60;
			timerLabel.setText(String.format("%02d:%02d", minutos, segundos));
			if (campominado.getMapa().isFimDeJogo() || campominado.getMapa().isGanhouJogo()) {
				timer.cancel();
				contador = 0;
			}

		}
	},1000, 1000);
	
	
	}
	
	
	
	
	public JCheckBox getBandeira() {
		return bandeira;
	}

	public void setBandeira(JCheckBox bandeira) {
		this.bandeira = bandeira;
	}

	public BotaoJogo[][] getBotoes() {
		return botoes;
	}

	public void setBotoes(BotaoJogo[][] botoes) {
		this.botoes = botoes;
	}
}
