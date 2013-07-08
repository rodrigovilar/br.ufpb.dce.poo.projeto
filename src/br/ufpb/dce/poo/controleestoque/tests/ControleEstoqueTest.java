package br.ufpb.dce.poo.controleestoque.tests;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import br.ufpb.dce.poo.controleestoque.exception.FacadeException;
import br.ufpb.dce.poo.controleestoque.facade.ControleEstoqueFacade;
import br.ufpb.dce.poo.controleestoque.model.Produto;

public class ControleEstoqueTest {
	private Produto p1, p2, p3;
	private ControleEstoqueFacade facade;

	@Before
	public void setUp() throws FacadeException {
		p1 = new Produto(
				1,
				"Notebook Ultrafino CCE com Intel Dual Core 2GB 500GB LED 14\" Preto Windows 8",
				10, 899.00f);
		p2 = new Produto(
				2,
				"Geladeira / Refrigerador Brastemp Frost Free Ative Inverse BRE50 Inox 422 Litros",
				5, 2699.00f);
		p3 = new Produto(
				3,
				"Smart TV 3D LED 47\" LG 47LA6200 FULL HD 3 HDMI 3 USB Wi-fi 120Hz + 4 Óculos 3D",
				1, 2969.10f);

		facade = new ControleEstoqueFacade();
		facade.cadastrarProduto(p1);
		facade.cadastrarProduto(p2);
		facade.cadastrarProduto(p3);
	}

	@Test
	public void testCadastrarProduto() throws FacadeException {
		Produto p4 = new Produto(
				4,
				"Smartphone Samsung Galaxy Ace Preto, Desbloqueado Vivo, GSM, Android, Câmera de 5MP, Tela Touchscreen 3.5\", 3G, Wi-Fi, Bluetooth e Cartão de Memória 2GB",
				3, 499.00f);
		facade.cadastrarProduto(p4);
		Assert.assertEquals(facade.listarProdutos().size(), 4);
	}

	@Test(expected = FacadeException.class)
	public void testDescadastrarProduto() throws FacadeException {
		facade.descadastrarProduto(4);
		Assert.assertEquals("", facade.listarProdutos().size(), 6);
	}

	@Test
	public void testBuscarProduto() throws FacadeException {
		Assert.assertEquals(899.00f, facade.buscarProduto(1).getValor());
	}

	@Test
	public void testListarProdutos() throws FacadeException {
		Assert.assertEquals(3, facade.listarProdutos().size());
	}

	@Test
	public void testGetQuantidadeProduto() throws FacadeException {
		Assert.assertEquals(10, facade.buscarProduto(1).getQuantidade());
	}

	@Test
	public void testReporProduto() throws FacadeException {
		Assert.assertEquals(10, facade.buscarProduto(1).getQuantidade());
		facade.reporProduto(1, 5);
		Assert.assertEquals(15, facade.buscarProduto(1).getQuantidade());
	}

	@Test
	public void testRetirarProduto() throws FacadeException {
		Assert.assertEquals(10, facade.buscarProduto(1).getQuantidade());
		facade.retirarProduto(1, 5);
		Assert.assertEquals(5, facade.buscarProduto(1).getQuantidade());
	}

	@Test
	public void testValorTotalEmEstoque() throws FacadeException {
		Assert.assertEquals(25454.1f, facade.getValorTotalEmEstoque());
	}

	@Test
	public void testValorTotalProduto() throws FacadeException {
		Assert.assertEquals(8990f, facade.getValorTotalProduto(1));
	}
}