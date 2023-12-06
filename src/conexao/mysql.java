package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class mysql {
	
	Connection connect = null;     
	
	public Connection conectar() { 
        try {   
            Class.forName("com.mysql.jdbc.Driver");
            connect = 
            	DriverManager.getConnection("jdbc:mysql://localhost:3306/coema", "root", ""); 
        } catch (Exception e) {
        	e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao BANCO: coema");
        }
            return connect;
    } 

}
