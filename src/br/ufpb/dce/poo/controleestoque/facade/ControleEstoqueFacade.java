package br.ufpb.dce.poo.controleestoque.facade;

import java.util.List;

import br.ufpb.dce.poo.controleestoque.controller.ControladorEstoque;
import br.ufpb.dce.poo.controleestoque.exception.FacadeException;
import br.ufpb.dce.poo.controleestoque.exception.ProdutoException;
import br.ufpb.dce.poo.controleestoque.model.Produto;

/**
 * 
 * 
 * @author Nayanne Soares e Gabriela Pimenta
 *
 */
public class ControleEstoqueFacade {
	/**  */
	private static ControleEstoqueFacade controleEstoqueFacade;
	
	/**  */
	private ControladorEstoque controladorEstoque;
	
	/**
	 * 
	 */
	private ControleEstoqueFacade() {
		controladorEstoque = new ControladorEstoque();
	}
	
	/**
	 * 
	 * @return
	 */
	public static ControleEstoqueFacade getInstance() {
		if(controleEstoqueFacade == null)
			controleEstoqueFacade = new ControleEstoqueFacade();
		return controleEstoqueFacade;
	}
	
	/**
	 * 
	 * @param produto
	 * @throws FacadeException
	 */
	public void cadastrarProduto(Produto produto) throws FacadeException {
		try {
			controladorEstoque.cadastrarProduto(produto);
		} catch (ProdutoException pe) {
			throw new FacadeException(pe);
		}
	}
	
	/**
	 * 
	 * @param codigo
	 * @throws FacadeException
	 */
	public void removerProduto(int codigo) throws FacadeException {
		try {
			controladorEstoque.descadastrarProduto(codigo);
		} catch (ProdutoException pe) {
			throw new FacadeException(pe);
		}
	}
	/**
	 * 
	 * @param codigo
	 * @return
	 * @throws FacadeException
	 */
	public Produto buscarProduto(int codigo) throws FacadeException {
		try {
			return controladorEstoque.buscarProduto(codigo);
		} catch (ProdutoException pe) {
			throw new FacadeException(pe);
		}
	}
	
	/**
	 * 
	 * @return
	 * @throws FacadeException
	 */
	public List<Produto> listarProdutos() throws FacadeException {
		try {
			return controladorEstoque.listarProdutos();
		} catch (ProdutoException pe) {
			throw new FacadeException(pe);
		}
	}
	
	/**
	 * 
	 * @param codigo
	 * @return
	 * @throws FacadeException
	 */
	public int getQuantidadeProduto(int codigo) throws FacadeException {
		try {
			return controladorEstoque.getQuantidadeProduto(codigo);
		} catch (ProdutoException pe) {
			throw new FacadeException(pe);
		}
	}
	/**
	 * 
	 * @param codigo
	 * @param quantidade
	 * @throws FacadeException
	 */
	public void reporProduto(int codigo, int quantidade) throws FacadeException {
		try {
			controladorEstoque.reporProduto(codigo, quantidade);
		} catch (ProdutoException pe) {
			throw new FacadeException(pe);
		}
	}
	
	/**
	 * 
	 * @param codigo
	 * @param quantidade
	 * @throws FacadeException
	 */
	public void retirarProduto(int codigo, int quantidade) throws FacadeException {
		try {
			controladorEstoque.retirarProduto(codigo, quantidade);
		} catch (ProdutoException pe) {
			throw new FacadeException(pe);
		}
	}
	
	/**
	 * 
	 * @return
	 * @throws FacadeException
	 */
	public float getValorTotalEmEstoque() throws FacadeException {
		try {
			return controladorEstoque.getValorTotalEmEstoque();
		} catch (ProdutoException pe) {
			throw new FacadeException(pe);
		}
	}
	
	/**
	 * 
	 * @param codigo
	 * @return
	 * @throws FacadeException
	 */
	public float getValorTotalProduto(int codigo) throws FacadeException {
		try {
			return controladorEstoque.getValorTotalProduto(codigo);
		} catch (ProdutoException pe) {
			throw new FacadeException(pe);
		}
	}
}