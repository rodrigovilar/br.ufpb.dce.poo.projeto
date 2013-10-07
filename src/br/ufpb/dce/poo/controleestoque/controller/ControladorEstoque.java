package br.ufpb.dce.poo.controleestoque.controller;

import java.util.ArrayList;
import java.util.List;

import br.ufpb.dce.poo.controleestoque.exception.ProdutoException;
import br.ufpb.dce.poo.controleestoque.model.Produto;

/**
 * Esta classe È respons·vel por gerenciar os produtos do estoque. Suas
 * funcionalidades s„o: Cadastrar um novo produto, buscar produto, remover
 * produto, entre outas.
 * 
 * @author Nayanne Soares e Gabriela Pimenta
 * 
 */
public class ControladorEstoque {
	/** A lista de produtos cadastrados no sistema */
	private List<Produto> produtos;

	/**
	 * ConstrÛi o ControladorEstoque inicializando a lista de produtos.
	 */
	public ControladorEstoque() {
		produtos = new ArrayList<Produto>();
	}

	/**
	 * Se n„o existe nenhum produto cadastrado com os dados do produto a ser
	 * inserido, insere o novo produto na lista.
	 * 
	 * @param produto
	 *            Produto a ser cadastrado
	 * @throws ProdutoException
	 *             ExceÁ„o lanÁado caso haja algum produto cadastrado com os
	 *             dados informados.
	 */
	public void cadastrarProduto(Produto produto) throws ProdutoException {
		Produto prod = null;

		try {
			prod = buscarProduto(produto.getCodigo());
		} catch (ProdutoException pe) {
			produtos.add(produto);
		}

		if (prod != null)
			throw new ProdutoException(
					"J· existe um produto cadastrado com o cÛdigo informado!");
	}

	/**
	 * Se houver algum produto cadastrado com o codigo informado no par‚metro,
	 * remove este produto da lista.
	 * 
	 * @param codigo
	 *            CÛdigo do produto a ser removido.
	 * @throws ProdutoException
	 *             ExceÁ„o lanÁada caso n„o haja nenhum produto cadastrado com o
	 *             cÛdigo informado.
	 */
	public void remover(int codigo) throws ProdutoException {
		Produto prod = null;

		if(codigo < 0)
			throw new ProdutoException("CÛdigo inv·lido. Valor informado È menor que 0.");

		try {
			prod = buscarProduto(codigo);
		} catch (ProdutoException pe) {
			throw pe;
		}

		if(prod != null)
			produtos.remove(prod);
	}

	/**
	 * Procura um produto na lista de produtos cadastrados.
	 * 
	 * @param codigo
	 *            CÛdigo do produto a ser pesquisado.
	 * @return O produto que possui o cÛdigo informado.
	 * @throws ProdutoException
	 *             ExceÁ„o lanÁada caso n„o haja nenhum produto cadastrado com o
	 *             cÛdigo informado.
	 */
	public Produto buscarProduto(int codigo) throws ProdutoException {
		for (Produto produto : produtos){
			if (produto.getCodigo() == codigo){
				return produto;
			}
		}

		throw new ProdutoException("N„o foi encontrado produto com o cÛdigo informado!");
	}

	/**
	 * MÈtodo para recuperar todos os produtos cadastrados no sistema.
	 * 
	 * @return A lista de produtos cadastrados.
	 * @throws ProdutoException
	 *             ExceÁ„o lanÁado caso n„o haja nenhum produto cadastrado.
	 */
	public List<Produto> listarProdutos() throws ProdutoException {
		if (produtos.size() > 0)
			return produtos;

		throw new ProdutoException("N„o existe nenhum produto cadastrado!");
	}

	/**
	 * MÈtodo para obter a quantidade de produtos disponÌveis no estoque de um
	 * determinado produto
	 * 
	 * @param codigo
	 *            CÛdigo do produto o qual deseja saber sua quantidade
	 *            disponÌvel
	 * @return A quantidade disponÌvel no estoque.
	 * @throws ProdutoException
	 *             ExceÁ„o lanÁada se n„o foi encontrado nenhum produto com o
	 *             cÛdigo informado.
	 */
	public int getQuantidadeProduto(int codigo) throws ProdutoException {
		Produto prod = null;

		try {
			prod = buscarProduto(codigo);
		} catch (ProdutoException pe) {
			throw pe;
		}

		return prod.getQuantidade();
	}

	/**
	 * Adiciona uma quantia no estoque de um produto que j· est· cadastrado.
	 * 
	 * @param codigo
	 *            CÛdigo do produto.
	 * @param quantidade
	 *            Quantia a ser adicionada.
	 * @throws ProdutoException
	 *             ExceÁ„o pode ser lanÁada em dois casos: 1) se a quantia a ser
	 *             inserida for menor do que 1; 2) Se n„o existe nenhum produto
	 *             cadastrado com o cÛdigo informado.
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
	 *            CÛdigo do produto.
	 * @param quantidade
	 *            Quantia a ser retirada.
	 * @throws ProdutoException
	 *             ExceÁ„o pode ser lanÁada em trÍs casos: 1) se a quantia a ser
	 *             retirada for menor do que 1; 2) Se a quantia a ser retirada
	 *             for maior que a quantia disponÌvel no estoque; 3) Se n„o
	 *             existe nenhum produto cadastrado com o cÛdigo informado.
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
						"Quantidade a ser retira È maior que a quantidade disponÌvel!");
		} catch (ProdutoException pe) {
			throw pe;
		}
	}

	/**
	 * Soma o valor da multiplicaÁ„o da quantidade em estoque pelo do valor de
	 * todos os produtos cadastrados.
	 * 
	 * @return Quantia total em estoque.
	 * @throws ProdutoException
	 *             ExceÁ„o lanÁada caso n„o exista nenhum produto cadastrado.
	 */
	public float getValorTotalEmEstoque() throws ProdutoException {
		if (produtos.size() == 0)
			throw new ProdutoException("N„o existe nenhum produto cadastrado!");

		float total = 0;

		for (Produto produto : produtos)
			total += produto.getValor() * produto.getQuantidade();

		return total;
	}

	/**
	 * Multiplica o valor de um determinado produto pela sua quantidade
	 * disponÌvel no estoque.
	 * 
	 * @param codigo
	 *            CÛdigo do produto.
	 * @return O valor em estoque do produto com cÛdigo informado.
	 * @throws ProdutoException
	 *             ExceÁ„o lanÁada se n„o foi encontrado nenhum produto com o
	 *             cÛdigo informado.
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
