package telas.sistema;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sistema.GerenciadorImobiliarioDal;
import sistema.Imovel;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;

public class TelaEdicaoImovel extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private String tituloImovel;
	private Imovel a;
	private String alteracao;

	
	public TelaEdicaoImovel(GerenciadorImobiliarioDal gerente) {
		setTitle("Edi\u00E7\u00E3o de Im\u00F3vel");
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
		
		JLabel lblTtuloDoImvel = new JLabel("T\u00EDtulo do Im\u00F3vel:");
		lblTtuloDoImvel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblTtuloDoImvel.setBounds(10, 14, 104, 14);
		contentPane.add(lblTtuloDoImvel);
		
		textField = new JTextField();
		textField.setBounds(124, 11, 300, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JRadioButton tit = new JRadioButton("T\u00EDtulo");
		tit.setBounds(23, 86, 59, 23);
		contentPane.add(tit);
		
		JRadioButton pret = new JRadioButton("Pretens\u00E3o");
		pret.setBounds(95, 86, 85, 23);
		contentPane.add(pret);
		
		JRadioButton det = new JRadioButton("Detalhes");
		det.setBounds(182, 86, 75, 23);
		contentPane.add(det);
		
		JRadioButton valor = new JRadioButton("Valor");
		valor.setBounds(265, 86, 59, 23);
		contentPane.add(valor);
		
		JRadioButton quartos = new JRadioButton("Quartos");
		quartos.setBounds(328, 86, 75, 23);
		contentPane.add(quartos);
		
		JButton btnVisualizar = new JButton("Visualizar");
		btnVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tituloImovel = textField.getText();
				try {
					a = gerente.getImovel_Titulo(tituloImovel);
					JOptionPane.showMessageDialog(null, a.toString());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnVisualizar.setBounds(320, 30, 104, 23);
		contentPane.add(btnVisualizar);
		
		JLabel lblAlterar = new JLabel("Alterar");
		lblAlterar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAlterar.setBounds(23, 65, 59, 14);
		contentPane.add(lblAlterar);
		
		JLabel lblNewLabel = new JLabel("Altera\u00E7\u00E3o:");
		lblNewLabel.setBounds(23, 132, 59, 14);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(79, 129, 345, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblApenasParaTtulo = new JLabel("Caso a op\u00E3o escolhida seja Valor, siga o modelo 230.00");
		lblApenasParaTtulo.setForeground(Color.RED);
		lblApenasParaTtulo.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblApenasParaTtulo.setBounds(79, 153, 269, 14);
		contentPane.add(lblApenasParaTtulo);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alteracao = textField_1.getText();
				if(alteracao!=null) {
					if(tit.isSelected()==true) {
						a.setTitulo(alteracao);
					}
					else if(pret.isSelected()==true){
						gerente.editarImovel_Pretensao(tituloImovel, alteracao);;
					}
					else if(det.isSelected()==true) {
						a.setDetalhes(alteracao);
					}
					else if(valor.isSelected()==true) {
						a.setValor(Double.parseDouble(alteracao));
					}
					else if(quartos.isSelected()==true) {
						a.setQntdQuartos(Integer.parseInt(alteracao));
					}
					JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso.");
				}else	{
				 JOptionPane.showMessageDialog(null, "O campo para alteração não foi preenchido.");
				}
			}
		});
		btnOk.setBounds(320, 178, 104, 23);
		contentPane.add(btnOk);
	}
}
