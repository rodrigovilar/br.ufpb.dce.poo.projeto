package br.ufpb.dce.poo.controleestoque.exception;

/**
 * Exceção lançada quando ocorre algum erro na fachada do sistema.
 * Só ocorre quando o gerenciador de produtos lança a exceção
 * ProdutoException.
 * 
 * @author Nayanne Soares
 *
 */
public class FacadeException extends Exception {
  /**
   * Construtor da FacadeException, que recebe uma excecao por
   * parâmetro, que foi a exceção lançada pelo Gerenciador antes
   * de chegar na fachada.
   * 
   * @param e Exceção que ocorreu no Gerenciador de Produtos.
   */
  public FacadeException(Exception e) {
		super(e);
	}
}
