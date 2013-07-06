package br.ufpb.dce.poo.controleestoque.exception;

public class ProdutoException extends Exception {
	public ProdutoException() { }
	
	public ProdutoException(String mensagem) {
		super(mensagem);
	}
}