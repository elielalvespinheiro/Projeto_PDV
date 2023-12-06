package controller;

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
	
	public Produto getProduto(String codigoBarras) {
		return dao.findByCodBarras(codigoBarras);
	}

}
