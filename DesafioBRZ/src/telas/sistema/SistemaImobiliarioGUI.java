package telas.sistema;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sistema.GerenciadorImobiliarioDal;

public class SistemaImobiliarioGUI extends JFrame {
	
	public static void main(String[] args) {
		GerenciadorImobiliarioDal gerente;
		gerente = new GerenciadorImobiliarioDal();
		TelaPrincipal frame = new TelaPrincipal(gerente);
		frame.setVisible(true);
		WindowListener fechadorDeJanelaPrincipal = new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		};
		frame.addWindowListener(fechadorDeJanelaPrincipal);
	}

}
