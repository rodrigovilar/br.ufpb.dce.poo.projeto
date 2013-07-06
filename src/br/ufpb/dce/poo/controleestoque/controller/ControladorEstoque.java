package br.ufpb.dce.poo.controleestoque.controller;

import java.util.ArrayList;
import java.util.List;

import br.ufpb.dce.poo.controleestoque.exception.ProdutoException;
import br.ufpb.dce.poo.controleestoque.model.Produto;

public class ControladorEstoque {
	private List<Produto> produtos;

	public ControladorEstoque() {
		produtos = new ArrayList<Produto>();
	}

	public void cadastrarProduto(Produto produto) throws ProdutoException {
		try {
			if (buscarProduto(produto.getCodigo()) == null)
				produtos.add(produto);
		} catch (ProdutoException pe) {
			throw new ProdutoException(
					"Já existe um produto cadastrado com o código informado!");
		}
	}

	public void descadastrarProduto(int codigo) throws ProdutoException {
		Produto produto = buscarProduto(codigo);

		if (produto != null)
			produtos.remove(produto);

		throw new ProdutoException(
				"Não foi encontrado produto com o código informado!");
	}

	public Produto buscarProduto(int codigo) throws ProdutoException {
		for (Produto produto : produtos)
			if (produto.getCodigo() == codigo)
				return produto;

		throw new ProdutoException(
				"Não foi encontrado produto com o código informado!");
	}

	public List<Produto> listarProdutos() throws ProdutoException {
		if (produtos.size() > 0)
			return produtos;
		
		throw new ProdutoException("Não existe nenhum produto cadastrado!");
	}

	public int getQuantidadeProduto(int codigo) throws ProdutoException{
		Produto produto;
		
		try {
			produto = buscarProduto(codigo);
		} catch (ProdutoException pe) {
			throw pe;
		}

		return produto.getQuantidade();
	}
}
