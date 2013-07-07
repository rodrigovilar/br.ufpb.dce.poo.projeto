package br.ufpb.dce.poo.controleestoque.model;

/**
 * Classe concreta para representar o Produto.
 * 
 * @author Gabriela Pimenta
 * 
 */
public class Produto {
	/** Propriedade codigo. */
	private int codigo;

	/** Propriedade descricao. */
	private String descricao;

	/** Propriedade quantidade. */
	private int quantidade;

	/** Propriedade valor. */
	private float valor;

	/**
	 * Constroi um Produto com o codigo informado no parametro, com uma
	 * descricao padrao, quantidade 0 e valor 0.
	 * 
	 * @param codigo
	 *            Codigo do produto a ser criado
	 */
	public Produto(int codigo) {
		this(codigo, "Produto sem descricao.", 0, 0f);
	}

	/**
	 * Constroi um Produto com os dados recebidos no parametro.
	 * 
	 * @param codigo
	 *            Codigo do produto a ser criado.
	 * @param descricao
	 *            Descricao do produto a ser criado.
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
	 * Recupera a propriedade codigo.
	 * 
	 * @return Codigo do Produto.
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Altera a propriedade codigo.
	 * 
	 * @param codigo
	 *            Novo codigo.
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * Recupera a propriedade descricao.
	 * 
	 * @return Descricao do Produto.
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * Altera a propriedade descricao.
	 * 
	 * @param descricao
	 *            Nova descricao.
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