package br.ufpb.dce.poo.controleestoque;

import java.util.List;

import br.ufpb.dce.poo.controleestoque.controller.ControladorEstoque;
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
	
	public void cadastrarProduto(Produto produto) {
		controladorEstoque.cadastrarProduto(produto);
	}
	
	public void descadastrarProduto(int codigo) {
		controladorEstoque.descadastrarProduto(codigo);
	}
	
	public Produto buscarProduto(int codigo) {
		return controladorEstoque.buscarProduto(codigo);
	}
	
	public List<Produto> listarProdutos() {
		return controladorEstoque.listarProdutos();
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