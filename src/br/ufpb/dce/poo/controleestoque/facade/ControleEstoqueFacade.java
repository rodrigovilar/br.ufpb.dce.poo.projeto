package br.ufpb.dce.poo.controleestoque.facade;

import java.util.List;

import br.ufpb.dce.poo.controleestoque.controller.ControladorEstoque;
import br.ufpb.dce.poo.controleestoque.exception.FacadeException;
import br.ufpb.dce.poo.controleestoque.exception.ProdutoException;
import br.ufpb.dce.poo.controleestoque.model.Produto;

public class ControleEstoqueFacade {
	private static ControleEstoqueFacade controleEstoqueFacade;
	private ControladorEstoque controladorEstoque;
	
	private ControleEstoqueFacade() {
		controladorEstoque = new ControladorEstoque();
	}
	
	public static ControleEstoqueFacade getInstance() {
		if(controleEstoqueFacade == null)
			controleEstoqueFacade = new ControleEstoqueFacade();
		return controleEstoqueFacade;
	}
	
	public void cadastrarProduto(Produto produto) throws FacadeException {
		try {
			controladorEstoque.cadastrarProduto(produto);
		} catch (ProdutoException pe) {
			throw new FacadeException(pe);
		}
	}
	
	public void removerProduto(int codigo) throws FacadeException {
		try {
			controladorEstoque.descadastrarProduto(codigo);
		} catch (ProdutoException pe) {
			throw new FacadeException(pe);
		}
	}
	
	public Produto buscarProduto(int codigo) throws FacadeException {
		try {
			return controladorEstoque.buscarProduto(codigo);
		} catch (ProdutoException pe) {
			throw new FacadeException(pe);
		}
	}
	
	public List<Produto> listarProdutos() throws FacadeException {
		try {
			return controladorEstoque.listarProdutos();
		} catch (ProdutoException pe) {
			throw new FacadeException(pe);
		}
	}
	
	public int getQuantidadeProduto(int codigo) {
		return 0;
	}
	
	public void reporProduto(int codigo, int quantidade) {
		
	}
	
	public void retirarProduto(int codigo, int quantidade) {
		
	}
	
	public float valorTotalEmEstoque() {
		return 0;
	}
	
	public float valorTotalProduto(int codigo) {
		return 0;
	}
}
