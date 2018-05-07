package telas.sistema;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sistema.GerenciadorImobiliarioDal;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaExclusaoInteresse extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private String nome;
	private String tituloImovel;

	
	public TelaExclusaoInteresse(GerenciadorImobiliarioDal gerente) {
		setTitle("Exclus\u00E3o de Interesse");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Voltar");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal tela = new TelaPrincipal(gerente);
				tela.setVisible(true);
			}
		});
		menuBar.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNome.setBounds(10, 84, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblTtuloDoImvel = new JLabel("T\u00EDtulo do Im\u00F3vel:");
		lblTtuloDoImvel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblTtuloDoImvel.setBounds(10, 34, 114, 14);
		contentPane.add(lblTtuloDoImvel);
		
		textField = new JTextField();
		textField.setBounds(134, 32, 290, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(134, 82, 290, 20);
		contentPane.add(textField_1);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nome = textField_1.getText();
				tituloImovel = textField.getText();
				gerente.excluirInteresse(nome, tituloImovel);
			}
		});
		btnOk.setBounds(319, 157, 105, 23);
		contentPane.add(btnOk);
	}

}
