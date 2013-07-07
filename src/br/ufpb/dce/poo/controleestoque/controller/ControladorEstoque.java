package br.ufpb.dce.poo.controleestoque.controller;

import java.util.ArrayList;
import java.util.List;

import br.ufpb.dce.poo.controleestoque.exception.ProdutoException;
import br.ufpb.dce.poo.controleestoque.model.Produto;

/**
 * Esta classe é responsável por gerenciar os produtos do estoque. Suas
 * funcionalidades são: Cadastrar um novo produto, buscar produto, remover
 * produto, entre outas.
 * 
 * @author Nayanne Soares e Gabriela Pimenta
 * 
 */
public class ControladorEstoque {
	/** A lista de produtos cadastrados no sistema */
	private List<Produto> produtos;

	/**
	 * Constrói o ControladorEstoque inicializando a lista de produtos.
	 */
	public ControladorEstoque() {
		produtos = new ArrayList<Produto>();
	}

	/**
	 * Se não existe nenhum produto cadastrado com os dados do produto a ser
	 * inserido, insere o novo produto na lista.
	 * 
	 * @param produto
	 *            Produto a ser cadastrado
	 * @throws ProdutoException
	 *             Exceção lançado caso haja algum produto cadastrado com os
	 *             dados informados.
	 */
	public void cadastrarProduto(Produto produto) throws ProdutoException {
		try {
			if (buscarProduto(produto.getCodigo()) == null)
				produtos.add(produto);
		} catch (ProdutoException pe) {
			throw new ProdutoException(
					"Já existe um produto cadastrado com o código informado!");
		}
	}

	/**
	 * 
	 * @param codigo
	 * @throws ProdutoException
	 */
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

	public int getQuantidadeProduto(int codigo) throws ProdutoException {
		try {
			return buscarProduto(codigo).getQuantidade();
		} catch (ProdutoException pe) {
			throw pe;
		}
	}

	public void reporProduto(int codigo, int quantidade)
			throws ProdutoException {
		try {
			Produto produto = buscarProduto(codigo);
			if (quantidade < 0)
				throw new ProdutoException("Quantidade menor que 1!");
			produto.setQuantidade(produto.getQuantidade() + quantidade);
		} catch (ProdutoException pe) {
			throw pe;
		}
	}

	public void retirarProduto(int codigo, int quantidade)
			throws ProdutoException {
		try {
			Produto produto = buscarProduto(codigo);
			if (quantidade < 0)
				throw new ProdutoException("Quantidade menor que 1!");
			else if (quantidade <= produto.getQuantidade())
				produto.setQuantidade(produto.getQuantidade() - quantidade);
			else
				throw new ProdutoException(
						"Quantidade a ser retira é maior que a quantidade disponível!");
		} catch (ProdutoException pe) {
			throw pe;
		}
	}

	public float getValorTotalEmEstoque() throws ProdutoException {
		if (produtos.size() == 0)
			throw new ProdutoException("Não existe nenhum produto cadastrado!");

		float total = 0;

		for (Produto produto : produtos)
			total += produto.getValor();

		return total;
	}

	public float getValorTotalProduto(int codigo) throws ProdutoException {
		try {
			Produto produto = buscarProduto(codigo);
			return produto.getValor() * produto.getQuantidade();
		} catch (ProdutoException pe) {
			throw pe;
		}
	}
}