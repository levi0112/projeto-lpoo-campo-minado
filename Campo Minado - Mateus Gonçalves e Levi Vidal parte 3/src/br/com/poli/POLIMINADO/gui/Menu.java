package br.com.poli.POLIMINADO.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.poli.POLIMINADO.CampoMinado;
import br.com.poli.POLIMINADO.Dificuldade;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class Menu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private CampoMinado campo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 5, 900, 750);
		contentPane = 	new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCampoMinado = new JLabel("CAMPO MINADO");
		lblCampoMinado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCampoMinado.setBounds(389, 71, 151, 38);
		contentPane.add(lblCampoMinado);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "FÁCIL", "MÉDIO", "DIFÍCIL" }));
		comboBox.setBounds(270, 258, 129, 22);
		contentPane.add(comboBox);

		JLabel lblDificuldade = new JLabel("Dificuldade:");
		lblDificuldade.setBounds(270, 231, 78, 16);
		contentPane.add(lblDificuldade);

		JButton btnJogar = new JButton("JOGAR");
		btnJogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				switch (comboBox.getSelectedIndex()) {
				case 0:
					campo = new CampoMinado(textField.getText(), Dificuldade.FACIL);
					break;
				case 1:
					campo = new CampoMinado(textField.getText(), Dificuldade.MEDIO);
					break;
				case 2:
					campo = new CampoMinado(textField.getText(), Dificuldade.DIFICIL);
					break;
				}
				dispose();
				Jogo jogo = new Jogo(campo);
				jogo.setVisible(true);
				campo.getJogador().setNome(textField.getText());
			
			}
		});
		btnJogar.setBounds(411, 367, 129, 25);
		contentPane.add(btnJogar);

		JButton btnNewButton = new JButton("RANKING");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(411, 452, 129, 25);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("SAIR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(411, 533, 129, 25);
		contentPane.add(btnNewButton_1);

		textField = new JTextField();
		textField.setBounds(562, 258, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblJogador = new JLabel("jogador:");
		lblJogador.setBounds(562, 232, 46, 14);
		contentPane.add(lblJogador);
	}
}
