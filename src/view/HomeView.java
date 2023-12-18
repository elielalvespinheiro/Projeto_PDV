package view;

import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JToolBar;
import java.awt.Canvas;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;

public class HomeView extends JFrame {

	public HomeView() {
		initialize();
	}

	private void initialize() {
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("HOME");
        //setExtendedState(6);
        //setUndecorated(true);
        
		setResizable(false);
		setBounds(100, 100, 657, 392);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 0, 641, 353);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 641, 22);
		panel_1.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Cadastro");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Produto");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdutoView window = new ProdutoView();
				window.frame.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnBalcoDeVendas = new JMenu("Balcão de vendas");
		menuBar.add(mnBalcoDeVendas);
		
		JMenuItem mntmPdv = new JMenuItem("PDV");
		mnBalcoDeVendas.add(mntmPdv);
		
		Label label = new Label("SUA LOGO AQUI");
		label.setBounds(265, 154, 97, 22);
		panel_1.add(label);
	}
}
