package br.ufpb.dce.poo.controleestoque.model;

/**
 * Classe concreta para representar o Produto.
 * 
 * @author Gabriela Pimenta
 * 
 */
public class Produto {
	/** Propriedade código. */
	private int codigo;

	/** Propriedade descrição. */
	private String descricao;

	/** Propriedade quantidade. */
	private int quantidade;

	/** Propriedade valor. */
	private float valor;

	/**
	 * Constrói um Produto com o código informado no parâmetro, com uma
	 * descrição padrão, quantidade 0 e valor 0.
	 * 
	 * @param codigo
	 *            Código do produto a ser criado
	 */
	public Produto(int codigo) {
		this(codigo, "Produto sem descrição.", 0, 0f);
	}

	/**
	 * Constrói um Produto com os dados recebidos no parâmetro.
	 * 
	 * @param codigo
	 *            Código do produto a ser criado.
	 * @param descricao
	 *            Descrição do produto a ser criado.
	 * @param quantidade
	 *            Quantidade em estoque do produto a ser criado.
	 * @param valor
	 *            Valor do produto a ser criado.
	 */
	public Produto(int codigo, String descricao, int quantidade, float valor) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.valor = valor;
	}

	/**
	 * Recupera a propriedade código.
	 * 
	 * @return Código do Produto.
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Altera a propriedade código.
	 * 
	 * @param codigo
	 *            Novo código.
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * Recupera a propriedade descrição.
	 * 
	 * @return Descrição do Produto.
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * Altera a propriedade descrição.
	 * 
	 * @param descricao
	 *            Nova descrição.
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * Recupera a propriedade quantidade.
	 * 
	 * @return Quantidade do Produto.
	 */
	public int getQuantidade() {
		return quantidade;
	}

	/**
	 * Altera a propriedade quantidade.
	 * 
	 * @param quantidade
	 *            Nova quantidade.
	 */
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	/**
	 * Recupera a propriedade valor.
	 * 
	 * @return Valor do Produto.
	 */
	public float getValor() {
		return valor;
	}

	/**
	 * Altera a propriedade valor.
	 * 
	 * @param valor
	 *            Novo valor.
	 */
	public void setValor(float valor) {
		this.valor = valor;
	}

	/**
	 * Cria uma string com os dados do produto.
	 * 
	 * @return A string criada com os dados do produto.
	 */
	@Override
	public String toString() {
		return "--------------------------------\n" + "Codigo: " + codigo
				+ "\n" + "Descricao: " + descricao + "\n" + "Quantidade: "
				+ quantidade + "\n" + "Valor: R$ " + valor + "\n"
				+ "--------------------------------";
	}
}