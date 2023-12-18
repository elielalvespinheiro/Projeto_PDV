package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView extends JFrame{
	
	public LoginView() {
		iniciarTela();
	}
	
	public void iniciarTela() {
		setTitle("LOGIN");
		setResizable(false);
		setBounds(100, 100, 380, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 380, 350);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel labelLogin = new JLabel("Login");
		labelLogin.setBounds(10, 62, 46, 20);
		panel.add(labelLogin);
		
		JTextField tfLogin = new JTextField();
		tfLogin.setBounds(10, 87, 345, 35);
		tfLogin.setFont(new Font(null, 0, 16));
		panel.add(tfLogin);
		tfLogin.setColumns(10);
		
		JLabel labelSenha = new JLabel("Senha");
		labelSenha.setBounds(10, 130, 46, 20);
		panel.add(labelSenha);
		
		JPasswordField tfSenha = new JPasswordField();
		tfSenha.setBounds(10, 155, 345, 35);
		tfSenha.setFont(new Font(null, 0, 16));
		panel.add(tfSenha);
		tfSenha.setColumns(10);
		
	}
	
}
