package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import conexao.mysql;
import model.Produto;

public class ProdutoDAO extends mysql {

	Connection cn = this.conectar(); 
    ResultSet rs = null;
    PreparedStatement pst = null;
	
	public int save(Produto produto) {
        try {
        	//Criar sql do banco
        	String sql = "INSERT INTO tbl_produto (nome, valor, departamento, cod_barras, quantidade) VALUES (?, ?, ?, ?, ?)"; 
        	//Preparar
        	pst = cn.prepareStatement(sql); 
        	//pst.setInt(1, produto.getId());
            pst.setString(1, produto.getNome());
            pst.setDouble(2, produto.getValor());
            pst.setString(3, produto.getDepartamento());
            pst.setString(4, produto.getCodBarras());
            pst.setInt(5, produto.getQuantidade());
            
            //executeQuery() é para realizar atualizações e inserções de registro.
            Integer p = pst.executeUpdate();
           
            if(p != null) {  
            	return 1;
            }
            
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } 
    }
	
	public boolean update(Produto produto) {
        try {
        	//Criar sql do banco
        	String sql = "UPDATE tbl_produto SET "
        			+ "id=" + produto.getId() + ", "
        			+ "nome=" + produto.getNome() + ", "
        			+ "valor=" + produto.getValor() + ", "
        			+ "departamento= " + produto.getDepartamento() + ", "
        			+ "cod_barras=" + produto.getCodBarras() + ", "
        			+ "quantidade=" + produto.getQuantidade() + " "
        			+ "WHERE id = " + produto.getId(); 
        	//Preparar
        	pst = cn.prepareStatement(sql);
            //executeQuery() é para realizar atualizações e inserções de registro.
            Integer p = pst.executeUpdate();
           
            if(p != null) {  
            	return true;
            }
            
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } 
    }
	
	//Trazer o produto.
	public Produto findByCodBarras(String codigoBarras) {
		try {
			String sql = "SELECT * FROM tbl_produto WHERE COD_BARRAS = " + codigoBarras;
			pst = cn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				Produto produto = new Produto();
				produto.setId(rs.getInt(1));
				produto.setNome(rs.getString(2));
				produto.setDepartamento(rs.getString(3));
				produto.setValor(rs.getDouble(4));
				produto.setQuantidade(rs.getInt(5));
				produto.setCodBarras(rs.getString(6));
				return produto;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
            return null;
		}
	}
	
}



//while(){
//o = new Sale();
//o.setId(getResultSet().getInt(1));
//}
