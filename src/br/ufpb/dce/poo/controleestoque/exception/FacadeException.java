package br.ufpb.dce.poo.controleestoque.exception;

/**
 * ExceÁ„o lanÁada quando ocorre algum erro na fachada do sistema.
 * SÛ ocorre quando o gerenciador de produtos lanÁa a exceÁ„o
 * ProdutoException.
 * 
 * @author Nayanne Soares
 *
 */
public class FacadeException extends Exception {
  /**
   * Construtor da FacadeException, que recebe uma excecao por
   * par‚metro, que foi a exceÁ„o lanÁada pelo Gerenciador antes
   * de chegar na fachada.
   * 
   * @param e ExceÁ„o que ocorreu no Gerenciador de Produtos.
   */
  public FacadeException(Exception e) {
		super(e);
	}
}
