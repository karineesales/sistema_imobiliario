package telas.sistema;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sistema.GerenciadorImobiliarioDal;


import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.Canvas;
import java.awt.Window.Type;
import java.awt.Scrollbar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;

	

	public TelaPrincipal(GerenciadorImobiliarioDal gerente) {
		setTitle("Sistema Imobili\u00E1rio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCadastro = new JMenu("Cadastro");
		menuBar.add(mnCadastro);
		
		JMenuItem mntmNovoImvel = new JMenuItem("Novo Im\u00F3vel");
		mntmNovoImvel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroImovel telaCad = new TelaCadastroImovel(gerente);
				telaCad.setVisible(true);
			}
		});
		mnCadastro.add(mntmNovoImvel);
		
		JMenuItem mntmNovoInteresse = new JMenuItem("Novo Interesse");
		mntmNovoInteresse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroInteresse telaCadI = new TelaCadastroInteresse(gerente);
				telaCadI.setVisible(true);
			}
		});
		mnCadastro.add(mntmNovoInteresse);
		
		JMenu mnEdio = new JMenu("Edi\u00E7\u00E3o");
		menuBar.add(mnEdio);
		
		JMenuItem mntmImvel = new JMenuItem("Im\u00F3vel");
		mntmImvel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEdicaoImovel tela = new TelaEdicaoImovel(gerente);
				tela.setVisible(true);
			}
		});
		mnEdio.add(mntmImvel);
		
		JMenu mnExcluso = new JMenu("Exclus\u00E3o");
		menuBar.add(mnExcluso);
		
		JMenuItem mntmImvel_1 = new JMenuItem("Im\u00F3vel");
		mntmImvel_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaExclusaoImovel tela = new TelaExclusaoImovel(gerente);
				tela.setVisible(true);
			}
		});
		mnExcluso.add(mntmImvel_1);
		
		JMenuItem mntmInteresse = new JMenuItem("Interesse");
		mntmInteresse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaExclusaoInteresse tela = new TelaExclusaoInteresse(gerente);
				tela.setVisible(true);
			}
		});
		mnExcluso.add(mntmInteresse);
		
		JMenu mnPesquisar = new JMenu("Pesquisar");
		menuBar.add(mnPesquisar);
		
		JMenuItem mntmInteressados = new JMenuItem("Interessados");
		mntmInteressados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPesquisaInteressados telaP = new TelaPesquisaInteressados(gerente);
				telaP.setVisible(true);
			}
		});
		mnPesquisar.add(mntmInteressados);
		
		JMenuItem mntmImvel_2 = new JMenuItem("Im\u00F3vel");
		mntmImvel_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPesquisaImovel telaI = new TelaPesquisaImovel(gerente);
				telaI.setVisible(true);
			}
		});
		mnPesquisar.add(mntmImvel_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
