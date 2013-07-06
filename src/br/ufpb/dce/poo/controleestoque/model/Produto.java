package br.ufpb.dce.poo.controleestoque.model;

public class Produto {
	private int codigo;
	private String descricao;
	private int quantidade;
	private float valor;

	public Produto(int codigo, String descricao, int quantidade, float valor) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.valor = valor;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "--------------------------------\n"
				+ "Codigo: " + codigo + "\n"
				+ "Descricao: " + descricao + "\n"
				+ "Quantidade: " + quantidade + "\n"
				+ "Valor: R$ " + valor + "\n"
				+ "--------------------------------";
	}
}