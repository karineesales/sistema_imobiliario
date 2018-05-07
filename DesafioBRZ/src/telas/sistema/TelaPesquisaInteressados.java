package telas.sistema;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sistema.GerenciadorImobiliarioDal;


import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;

public class TelaPesquisaInteressados extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private String busca;

	
	public TelaPesquisaInteressados(GerenciadorImobiliarioDal gerente) {
		setTitle("Busca de Interessados");
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
		
		JRadioButton nome = new JRadioButton("Nome");
		nome.setBounds(25, 32, 109, 23);
		contentPane.add(nome);
		
		JRadioButton email = new JRadioButton("Email");
		email.setBounds(136, 32, 109, 23);
		contentPane.add(email);
		
		JRadioButton titulo = new JRadioButton("T\u00EDtulo do Im\u00F3vel");
		titulo.setBounds(247, 32, 128, 23);
		contentPane.add(titulo);
		
		JLabel lblItemDeBusca = new JLabel("Item de Busca");
		lblItemDeBusca.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblItemDeBusca.setBounds(29, 11, 105, 14);
		contentPane.add(lblItemDeBusca);
		
		textField = new JTextField();
		textField.setBounds(25, 90, 399, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				busca = textField.getText();
				if(nome.isSelected()==true) {
					try {
						JOptionPane.showMessageDialog(null, gerente.imoveisPorInteressado_Nome(busca));
					} catch (HeadlessException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else if(email.isSelected()==true) {
					try {
						JOptionPane.showMessageDialog(null, gerente.imoveisPorInteressado_Email(busca));
					} catch (HeadlessException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else if(titulo.isSelected()==true) {
					try {
						JOptionPane.showMessageDialog(null, gerente.interessadosPorImovel(busca));
					} catch (HeadlessException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnBuscar.setBounds(335, 180, 89, 23);
		contentPane.add(btnBuscar);
	}

}
