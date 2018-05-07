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
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class TelaCadastroInteresse extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private String nome;
	private String email;
	private String titulo;

	
	public TelaCadastroInteresse(GerenciadorImobiliarioDal gerente) {
		setTitle("Cadastro de Interesse");
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
		
		JLabel lblNewLabel = new JLabel("Interessado");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 138, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNome.setBounds(10, 41, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblEmail.setBounds(10, 75, 46, 14);
		contentPane.add(lblEmail);
		
		textField = new JTextField();
		textField.setBounds(66, 39, 297, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(66, 73, 297, 20);
		contentPane.add(textField_1);
		
		JLabel lblImvel = new JLabel("Im\u00F3vel");
		lblImvel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblImvel.setBounds(10, 117, 138, 14);
		contentPane.add(lblImvel);
		
		JLabel lblTtulo = new JLabel("T\u00EDtulo:");
		lblTtulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblTtulo.setBounds(10, 156, 46, 14);
		contentPane.add(lblTtulo);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(66, 154, 297, 20);
		contentPane.add(textField_2);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nome = textField.getText();
				email = textField_1.getText();
				titulo = textField_2.getText();
				try {
					gerente.cadastrarInteresse(nome, email, titulo);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				
				
			}
		});
		btnNewButton.setBounds(309, 206, 115, 23);
		contentPane.add(btnNewButton);
	}

}
