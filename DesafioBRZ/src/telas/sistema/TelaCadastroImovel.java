package telas.sistema;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sistema.GerenciadorImobiliarioDal;
import sistema.TipoDeImovel;

import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import java.awt.Color;

public class TelaCadastroImovel extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private String tipo;
	private String titulo;
	private String pretensao;
	private String detalhes;
	private int qntdQuartos;
	private double valor;

	
	public TelaCadastroImovel(GerenciadorImobiliarioDal gerente) {
		setTitle("Cadastro de Im\u00F3vel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTipoDeImvel = new JLabel("Tipo de Im\u00F3vel:");
		lblTipoDeImvel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblTipoDeImvel.setBounds(10, 22, 94, 20);
		contentPane.add(lblTipoDeImvel);
		
		JRadioButton rdbtnCasa = new JRadioButton("Casa");
		rdbtnCasa.setBounds(125, 22, 55, 23);
		contentPane.add(rdbtnCasa);
		
		
		JRadioButton rdbtnApartamento = new JRadioButton("Apartamento");
		rdbtnApartamento.setBounds(182, 22, 109, 23);
		contentPane.add(rdbtnApartamento);
		
		JRadioButton rdbtnLoja = new JRadioButton("Loja");
		rdbtnLoja.setBounds(292, 22, 66, 23);
		contentPane.add(rdbtnLoja);
		
		JRadioButton rdbtnTerreno = new JRadioButton("Terreno");
		rdbtnTerreno.setBounds(360, 22, 109, 23);
		contentPane.add(rdbtnTerreno);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 21);
		contentPane.add(menuBar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Voltar");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal tela = new TelaPrincipal(gerente);
				tela.setVisible(true);
			}
		});
		menuBar.add(mntmNewMenuItem);
		
		JLabel lblTtulo = new JLabel("T\u00EDtulo:");
		lblTtulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblTtulo.setBounds(10, 54, 46, 14);
		contentPane.add(lblTtulo);
		
		textField = new JTextField();
		textField.setBounds(93, 53, 320, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPretenso = new JLabel("Pretens\u00E3o:");
		lblPretenso.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblPretenso.setBounds(10, 85, 80, 14);
		contentPane.add(lblPretenso);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(93, 84, 320, 20);
		contentPane.add(textField_1);
		
		JLabel lblDetalhes = new JLabel("Detalhes:");
		lblDetalhes.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblDetalhes.setBounds(10, 122, 80, 14);
		contentPane.add(lblDetalhes);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(93, 121, 320, 20);
		contentPane.add(textField_2);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblValor.setBounds(10, 155, 80, 14);
		contentPane.add(lblValor);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(93, 154, 320, 20);
		contentPane.add(textField_3);
		
		JLabel lblQuartos = new JLabel("Quartos:");
		lblQuartos.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblQuartos.setBounds(10, 186, 80, 14);
		contentPane.add(lblQuartos);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(93, 185, 320, 20);
		contentPane.add(textField_4);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnCasa.isSelected()){
					tipo = "casa";
				}
				else if(rdbtnApartamento.isSelected()){
					tipo = "apartamento";
				}
				else if(rdbtnLoja.isSelected()){
					tipo = "loja";
				}
				else if(rdbtnTerreno.isSelected()){
					tipo = "terreno";
				}
				
				titulo = textField.getText();
				pretensao = textField_1.getText();
				detalhes = textField_2.getText();
				valor = Double.parseDouble(textField_3.getText());
				qntdQuartos = Integer.parseInt(textField_4.getText());
				gerente.cadastraImovel(tipo, pretensao, titulo, detalhes, valor, qntdQuartos);
			}
		});
		btnCadastrar.setBounds(292, 227, 121, 23);
		contentPane.add(btnCadastrar);
		
		JLabel lblParaValorSiga = new JLabel("Para valor, siga o modelo 230.00");
		lblParaValorSiga.setForeground(Color.RED);
		lblParaValorSiga.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblParaValorSiga.setBounds(58, 231, 172, 14);
		contentPane.add(lblParaValorSiga);
	}
}
