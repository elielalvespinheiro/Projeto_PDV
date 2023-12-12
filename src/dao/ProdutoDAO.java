package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
	
	public boolean delete(int id) {
        try {
        	String sql = "DELETE FROM tbl_produto WHERE id = " + id; 
        	pst = cn.prepareStatement(sql); 
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
	
	public boolean update(Produto produto) {
        try {
        	String sql = "UPDATE tbl_produto SET "
        			+ "nome='" + produto.getNome() + "', "
        			+ "valor='" + produto.getValor() + "', "
        			+ "departamento= '" + produto.getDepartamento() + "', "
        			+ "cod_barras='" + produto.getCodBarras() + "', "
        			+ "quantidade='" + produto.getQuantidade() + "' "
        			+ "WHERE id = '" + produto.getId() + "';"; 
        	pst = cn.prepareStatement(sql);
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
	
	public Produto findById(int id) {
		try {
			String sql = "SELECT * FROM tbl_produto WHERE id = " + id;
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
	
	public List<Produto> findAll() {
		try {
			Produto produto = new Produto();
			List<Produto> lista = new ArrayList<>();
			String sql = "SELECT * FROM tbl_produto";
			pst = cn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				produto = new Produto();
				produto.setId(rs.getInt(1));
				produto.setNome(rs.getString(2));
				produto.setDepartamento(rs.getString(3));
				produto.setValor(rs.getDouble(4));
				produto.setQuantidade(rs.getInt(5));
				produto.setCodBarras(rs.getString(6));
				lista.add(produto);
			}
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
            return null;
		}
	}
	
	public List<Produto> findAll(String nome) {
		try {
			Produto produto = new Produto();
			List<Produto> lista = new ArrayList<>();
			String sql = "SELECT * FROM tbl_produto WHERE nome LIKE %" + nome + "%";
			pst = cn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				produto = new Produto();
				produto.setId(rs.getInt(1));
				produto.setNome(rs.getString(2));
				produto.setDepartamento(rs.getString(3));
				produto.setValor(rs.getDouble(4));
				produto.setQuantidade(rs.getInt(5));
				produto.setCodBarras(rs.getString(6));
				lista.add(produto);
			}
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
            return null;
		}
	}
	
	public List<Produto> findAllCodBarras(String codBarras) {
		try {
			Produto produto = new Produto();
			List<Produto> lista = new ArrayList<>();
			String sql = "SELECT * FROM tbl_produto WHERE COD_BARRAS LIKE %" + codBarras + "%";
			pst = cn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				produto = new Produto();
				produto.setId(rs.getInt(1));
				produto.setNome(rs.getString(2));
				produto.setDepartamento(rs.getString(3));
				produto.setValor(rs.getDouble(4));
				produto.setQuantidade(rs.getInt(5));
				produto.setCodBarras(rs.getString(6));
				lista.add(produto);
			}
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
            return null;
		}
	}
	
}
