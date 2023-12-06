package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UsuarioView {
	
	public UsuarioView() {
		iniciarTela();
	}
	
	public void iniciarTela() {
		JFrame frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 769, 387);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 753, 348);
		frame.add(panel);
		panel.setLayout(null);
		
		JLabel nome = new JLabel("Nome");
		nome.setFont(new Font("Calibri", Font.PLAIN, 26));
		nome.setBounds(10, 11, 149, 40);
		panel.add(nome);
		
		JLabel id = new JLabel("ID:");
		id.setBounds(10, 62, 46, 14);
		panel.add(id);
		
		JTextField tfId = new JTextField();
		tfId.setEditable(false);
		tfId.setBounds(10, 87, 86, 27);
		panel.add(tfId);
		tfId.setColumns(10);
		
		JTextField tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(106, 87, 249, 27);
		panel.add(tfNome);
		
	}
	
}
