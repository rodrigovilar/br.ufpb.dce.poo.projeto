package br.ufpb.dce.poo.controleestoque.controller;

import java.util.ArrayList;
import java.util.List;

import br.ufpb.dce.poo.controleestoque.model.Produto;

public class ControladorEstoque {
	private List<Produto> produtos;

	public ControladorEstoque() {
		produtos = new ArrayList<Produto>();
	}

	public void cadastrarProduto(Produto produto) {
		if (buscarProduto(produto.getCodigo()) == null)
			produtos.add(produto);
	}

	public void descadastrarProduto(int codigo) {
		Produto produto = buscarProduto(codigo);

		if (produto != null)
			produtos.remove(produto);
	}

	public Produto buscarProduto(int codigo) {
		for (Produto produto : produtos)
			if (produto.getCodigo() == codigo)
				return produto;

		return null;
	}

	public List<Produto> listarProdutos() {
		return produtos;
	}
}