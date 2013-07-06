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
		
	}
	
	public void descadastrarProduto(int codigo) {
		
	}
	
	public Produto buscarProduto(int codigo) {
		return null;
	}
	
	public List<Produto> listarProdutos() {
		return null;
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