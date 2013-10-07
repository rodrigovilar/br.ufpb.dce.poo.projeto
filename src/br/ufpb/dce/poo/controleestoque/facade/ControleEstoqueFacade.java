package br.ufpb.dce.poo.controleestoque.facade;

import java.util.List;

import br.ufpb.dce.poo.controleestoque.controller.ControladorEstoque;
import br.ufpb.dce.poo.controleestoque.exception.FacadeException;
import br.ufpb.dce.poo.controleestoque.exception.ProdutoException;
import br.ufpb.dce.poo.controleestoque.model.Produto;

/**
 * Fachada do Sistema.
 * 
 * @author Nayanne Soares e Gabriela Pimenta
 *
 */
public class ControleEstoqueFacade {

	/** objeto controladorEstoque. */
	private ControladorEstoque controladorEstoque;

	/**
	 * Construtor padr„o da fachada que inicializa o objeto controladorEstoque.
	 */
	public ControleEstoqueFacade() {
		controladorEstoque = new ControladorEstoque();
	}

	/**
	 * Chama o mÈtodo do controladorEstoque para cadastrar um novo produto.
	 * 
	 * @param produto Produto a ser adicionado.
	 * @throws FacadeException ExceÁ„o lanÁada se ocorreu algum erro no controlador.
	 */
	public void cadastrarProduto(Produto produto) throws FacadeException {
		try {
			controladorEstoque.cadastrarProduto(produto);
		} catch (ProdutoException pe) {
			throw new FacadeException(pe);
		}
	}

	/**
	 * Chama o mÈtodo do controladorEstoque para descadastrar um produto.
	 * 
	 * @param codigo CÛdigo do produto a ser descadastrado.
	 * @throws FacadeException ExceÁ„o lanÁada se ocorreu algum erro no controlador.
	 */
	public void remover(int codigo) throws FacadeException {
		try {
			controladorEstoque.remover(codigo);
		} catch (ProdutoException pe) {
			throw new FacadeException(pe);
		}
	}
	/**
	 * Chama o mÈtodo do controladorEstoque para buscar um produto.
	 * 
	 * @param codigo CÛdigo do produto a ser procurado.
	 * @return O produto encontrado pelo controlador.
	 * @throws FacadeException ExceÁ„o lanÁada se ocorreu algum erro no controlador.
	 */
	public Produto buscarProduto(int codigo) throws FacadeException {
		try {
			return controladorEstoque.buscarProduto(codigo);
		} catch (ProdutoException pe) {
			throw new FacadeException(pe);
		}
	}

	/**
	 * Chama o mÈtodo do controladorEstoque para recuperar todos os produtos cadastrados.
	 * 
	 * @return A lista de produtos cadastradas no controlador.
	 * @throws FacadeException ExceÁ„o lanÁada se ocorreu algum erro no controlador.
	 */
	public List<Produto> listarProdutos() throws FacadeException {
		try {
			return controladorEstoque.listarProdutos();
		} catch (ProdutoException pe) {
			throw new FacadeException(pe);
		}
	}

	/**
	 * Chama o mÈtodo do controladorEstoque para recuperar a quantidade em estoque de
	 * um determinado produto.
	 * 
	 * @param codigo CÛdigo do produto o qual se deseja saber a quantidade disponÌvel
	 * no estoque.
	 * @return A quantidade disponÌvel.
	 * @throws FacadeException ExceÁ„o lanÁada se ocorreu algum erro no controlador.
	 */
	public int getQuantidadeProduto(int codigo) throws FacadeException {
		try {
			return controladorEstoque.getQuantidadeProduto(codigo);
		} catch (ProdutoException pe) {
			throw new FacadeException(pe);
		}
	}
	/**
	 * Chama o mÈtodo do controladorEstoque para repor um certa quantia de um determinado
	 * produto no estoque.
	 * 
	 * @param codigo CÛdigo do produto o qual se deseja repor.
	 * @param quantidade Quantidade a ser acrescentada no estoque.
	 * @throws FacadeException ExceÁ„o lanÁada se ocorreu algum erro no controlador.
	 */
	public void reporProduto(int codigo, int quantidade) throws FacadeException {
		try {
			controladorEstoque.reporProduto(codigo, quantidade);
		} catch (ProdutoException pe) {
			throw new FacadeException(pe);
		}
	}

	/**
	 * Chama o mÈtodo do controladorEstoque para retirar uma determinada quantia do estoque
	 * de um determinado produto.
	 * 
	 * @param codigo CÛdigo do produto a ser retirado.
	 * @param quantidade Quantidade que se deseja retirar.
	 * @throws FacadeException ExceÁ„o lanÁada se ocorreu algum erro no controlador
	 */
	public void retirarProduto(int codigo, int quantidade) throws FacadeException {
		try {
			controladorEstoque.retirarProduto(codigo, quantidade);
		} catch (ProdutoException pe) {
			throw new FacadeException(pe);
		}
	}

	/**
	 * Chama o mÈtodo do controladorEstoque para obter o valor total em produtos no estoque.
	 * 
	 * @return Valor total do estoque.
	 * @throws FacadeException ExceÁ„o lanÁada se ocorreu algum erro no controlador
	 */
	public float getValorTotalEmEstoque() throws FacadeException {
		try {
			return controladorEstoque.getValorTotalEmEstoque();
		} catch (ProdutoException pe) {
			throw new FacadeException(pe);
		}
	}

	/**
	 * Chama o mÈtodo do controladorEstoque que retorna o valor total no estoque de um determinado
	 * produto. … o resultado da multiplicaÁ„o do seu valor pela sua quantidade disponÌvel.
	 * 
	 * @param codigo CÛdigo do produto.
	 * @return O valor total em estoque do produto.
	 * @throws FacadeException ExceÁ„o lanÁada se ocorreu algum erro no controlador.
	 */
	public float getValorTotalProduto(int codigo) throws FacadeException {
		try {
			return controladorEstoque.getValorTotalProduto(codigo);
		} catch (ProdutoException pe) {
			throw new FacadeException(pe);
		}
	}
}
