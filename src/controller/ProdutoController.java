package controller;

import java.util.List;

import dao.ProdutoDAO;
import model.Produto;

public class ProdutoController {
	
	ProdutoDAO dao = new ProdutoDAO();
	
	public int salvarProduto(Produto produto) {
		return dao.save(produto);
	}
	
	public boolean editarProduto(Produto produto) {
		return dao.update(produto);
	}
	
	public Produto getProdutoCodBarras(String codigoBarras) {
		return dao.findByCodBarras(codigoBarras);
	}
	
	public Produto getProduto(int id) {
		return dao.findById(id);
	}
	
	public List<Produto> getProduto() {
		return dao.findAll();
	}
	
	public List<Produto> getProdutoNome(String nome) {
		return dao.findAll(nome);
	}
	
	public List<Produto> getProdutoCodBarrasLista(String codBarras) {
		return dao.findAllCodBarras(codBarras);
	}
	
	public Boolean delete(int id) {
		return dao.delete(id);
	}

}
