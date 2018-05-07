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
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;

public class TelaPesquisaImovel extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private String busca;
	private double valorInicial;
	private double valorFinal;

	
	public TelaPesquisaImovel(GerenciadorImobiliarioDal gerente) {
		setTitle("Busca de Im\u00F3veis");
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
		
		JLabel lblItemDeBusca = new JLabel("Item de Busca:");
		lblItemDeBusca.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblItemDeBusca.setBounds(10, 21, 100, 14);
		contentPane.add(lblItemDeBusca);
		
		JRadioButton tit = new JRadioButton("T\u00EDtulo");
		tit.setBounds(10, 47, 61, 23);
		contentPane.add(tit);
		
		JRadioButton pret = new JRadioButton("Pretens\u00E3o");
		pret.setBounds(84, 47, 100, 23);
		contentPane.add(pret);
		
		JRadioButton qts = new JRadioButton("Quartos");
		qts.setBounds(192, 47, 83, 23);
		contentPane.add(qts);
		
		JRadioButton fPreco = new JRadioButton("Faixa de Pre\u00E7o");
		fPreco.setBounds(285, 47, 132, 23);
		contentPane.add(fPreco);
		
		textField = new JTextField();
		textField.setBounds(10, 93, 414, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPreencherEsteCampo = new JLabel("Preencher este campo apenas para os itens T\u00EDtulo, Pretens\u00E3o e Quartos.");
		lblPreencherEsteCampo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblPreencherEsteCampo.setForeground(Color.RED);
		lblPreencherEsteCampo.setBounds(10, 114, 414, 14);
		contentPane.add(lblPreencherEsteCampo);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 171, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(149, 171, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblFaixaDePreo = new JLabel("Faixa de Pre\u00E7o");
		lblFaixaDePreo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblFaixaDePreo.setBounds(10, 146, 100, 14);
		contentPane.add(lblFaixaDePreo);
		
		JLabel lblValorFinal = new JLabel("Valor Final");
		lblValorFinal.setBounds(149, 193, 61, 14);
		contentPane.add(lblValorFinal);
		
		JLabel lblNewLabel = new JLabel("Valor Inicial");
		lblNewLabel.setBounds(10, 193, 86, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				busca = textField.getText();
				String buscaT = "Imóveis encontrados\n";
				List<Imovel> lista = new ArrayList<Imovel>();
				if(tit.isSelected()==true) {
					try {
						JOptionPane.showMessageDialog(null, gerente.pesquisarImovel_Titulo(busca));
					} catch (HeadlessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else if(pret.isSelected()==true) {
					try {
						JOptionPane.showMessageDialog(null, gerente.pesquisarImovel_Pretensao(busca));
					} catch (HeadlessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else if(qts.isSelected()==true) {
					try {
						JOptionPane.showMessageDialog(null, gerente.pesquisarImovel_QntdQuartos(Integer.parseInt(busca)));
					} catch (HeadlessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else if(fPreco.isSelected()==true) {
					valorInicial = Double.parseDouble(textField_1.getText());
					valorFinal = Double.parseDouble(textField_2.getText());
					try {
						JOptionPane.showMessageDialog(null, gerente.pesquisarImovel_FaixaDePreco(valorInicial, valorFinal));
					} catch (HeadlessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnBuscar.setBounds(302, 206, 122, 23);
		contentPane.add(btnBuscar);
		
		JLabel lblExemploDePreenchimento = new JLabel("Exemplo de preenchimento: 230.00");
		lblExemploDePreenchimento.setForeground(Color.RED);
		lblExemploDePreenchimento.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblExemploDePreenchimento.setBounds(247, 174, 177, 14);
		contentPane.add(lblExemploDePreenchimento);
	}

}
