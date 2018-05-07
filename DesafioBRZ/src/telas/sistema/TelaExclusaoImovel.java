package telas.sistema;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sistema.GerenciadorImobiliarioDal;
import sistema.Imovel;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;

public class TelaExclusaoImovel extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private String tituloImovel;

	
	public TelaExclusaoImovel(GerenciadorImobiliarioDal gerente) {
		setTitle("Exclus\u00E3o de Im\u00F3vel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmVoltar = new JMenuItem("Voltar");
		mntmVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal tela = new TelaPrincipal(gerente);
				tela.setVisible(true);
			}
		});
		menuBar.add(mntmVoltar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTtuloDoImvel = new JLabel("T\u00EDtulo do Im\u00F3vel:");
		lblTtuloDoImvel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblTtuloDoImvel.setBounds(10, 25, 125, 14);
		contentPane.add(lblTtuloDoImvel);
		
		textField = new JTextField();
		textField.setBounds(132, 23, 292, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Excluir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tituloImovel = textField.getText();
				gerente.excluirImovel(tituloImovel);	
			}
		});
		btnNewButton.setBounds(312, 62, 112, 23);
		contentPane.add(btnNewButton);
	}

}
