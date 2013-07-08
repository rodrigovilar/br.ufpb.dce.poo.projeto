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
			buscarProduto(produto.getCodigo());
			throw new ProdutoException(
					"Já existe um produto cadastrado com o código informado!");
		} catch (ProdutoException pe) {
			produtos.add(produto);
		}
	}

	/**
	 * Se houver algum produto cadastrado com o codigo informado no parâmetro,
	 * remove este produto da lista.
	 * 
	 * @param codigo
	 *            Código do produto a ser removido.
	 * @throws ProdutoException
	 *             Exceção lançada caso não haja nenhum produto cadastrado com o
	 *             código informado.
	 */
	public void descadastrarProduto(int codigo) throws ProdutoException {
		try {
			produtos.remove(buscarProduto(codigo));
		} catch (ProdutoException pe) {
			throw new ProdutoException(
					"Não foi encontrado produto com o código informado!");
		}
	}

	/**
	 * Procura um produto na lista de produtos cadastrados.
	 * 
	 * @param codigo
	 *            Código do produto a ser pesquisado.
	 * @return O produto que possui o código informado.
	 * @throws ProdutoException
	 *             Exceção lançada caso não haja nenhum produto cadastrado com o
	 *             código informado.
	 */
	public Produto buscarProduto(int codigo) throws ProdutoException {
		for (Produto produto : produtos)
			if (produto.getCodigo() == codigo)
				return produto;

		throw new ProdutoException(
				"Não foi encontrado produto com o código informado!");
	}

	/**
	 * Método para recuperar todos os produtos cadastrados no sistema.
	 * 
	 * @return A lista de produtos cadastrados.
	 * @throws ProdutoException
	 *             Exceção lançado caso não haja nenhum produto cadastrado.
	 */
	public List<Produto> listarProdutos() throws ProdutoException {
		if (produtos.size() > 0)
			return produtos;

		throw new ProdutoException("Não existe nenhum produto cadastrado!");
	}

	/**
	 * Método para obter a quantidade de produtos disponíveis no estoque de um
	 * determinado produto
	 * 
	 * @param codigo
	 *            Código do produto o qual deseja saber sua quantidade
	 *            disponível
	 * @return A quantidade disponível no estoque.
	 * @throws ProdutoException
	 *             Exceção lançada se não foi encontrado nenhum produto com o
	 *             código informado.
	 */
	public int getQuantidadeProduto(int codigo) throws ProdutoException {
		try {
			return buscarProduto(codigo).getQuantidade();
		} catch (ProdutoException pe) {
			throw pe;
		}
	}

	/**
	 * Adiciona uma quantia no estoque de um produto que já está cadastrado.
	 * 
	 * @param codigo
	 *            Código do produto.
	 * @param quantidade
	 *            Quantia a ser adicionada.
	 * @throws ProdutoException
	 *             Exceção pode ser lançada em dois casos: 1) se a quantia a ser
	 *             inserida for menor do que 1; 2) Se não existe nenhum produto
	 *             cadastrado com o código informado.
	 */
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

	/**
	 * Retira uma quantia de um determinado produto do estoque.
	 * 
	 * @param codigo
	 *            Código do produto.
	 * @param quantidade
	 *            Quantia a ser retirada.
	 * @throws ProdutoException
	 *             Exceção pode ser lançada em três casos: 1) se a quantia a ser
	 *             retirada for menor do que 1; 2) Se a quantia a ser retirada
	 *             for maior que a quantia disponível no estoque; 3) Se não
	 *             existe nenhum produto cadastrado com o código informado.
	 */
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

	/**
	 * Soma o valor da multiplicação da quantidade em estoque pelo do valor de
	 * todos os produtos cadastrados.
	 * 
	 * @return Quantia total em estoque.
	 * @throws ProdutoException
	 *             Exceção lançada caso não exista nenhum produto cadastrado.
	 */
	public float getValorTotalEmEstoque() throws ProdutoException {
		if (produtos.size() == 0)
			throw new ProdutoException("Não existe nenhum produto cadastrado!");

		float total = 0;

		for (Produto produto : produtos)
			total += produto.getValor() * produto.getQuantidade();

		return total;
	}

	/**
	 * Multiplica o valor de um determinado produto pela sua quantidade
	 * disponível no estoque.
	 * 
	 * @param codigo
	 *            Código do produto.
	 * @return O valor em estoque do produto com código informado.
	 * @throws ProdutoException
	 *             Exceção lançada se não foi encontrado nenhum produto com o
	 *             código informado.
	 */
	public float getValorTotalProduto(int codigo) throws ProdutoException {
		try {
			Produto produto = buscarProduto(codigo);
			return produto.getValor() * produto.getQuantidade();
		} catch (ProdutoException pe) {
			throw pe;
		}
	}
}
