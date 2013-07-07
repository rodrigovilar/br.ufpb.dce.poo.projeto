package br.ufpb.dce.poo.controleestoque.exception;

/**
 * Excecao lancada quando ocorre algum erro no gerenciamento dos produtos,
 * exemplo:
 * i) Adicionar um produto com codigo ja cadastrado;
 * ii) Buscar um produto com codigo nao cadastrado;
 * iii) Remover um produto com codigo nao cadastrado.
 * 
 * @author Gabriela Pimenta
 * 
 */
public class ProdutoException extends Exception {
	/**
	 * Construtor padrao da excecao ProdutoException.
	 */
	public ProdutoException() {
	}

	/**
	 * Constroi um ProdutoException com uma mensagem.
	 * 
	 * @param mensagem
	 *            Mensagem da excecao construida.
	 */
	public ProdutoException(String mensagem) {
		super(mensagem);
	}
}