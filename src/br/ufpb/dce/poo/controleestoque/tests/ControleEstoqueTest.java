package br.ufpb.dce.poo.controleestoque.tests;

import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import br.ufpb.dce.poo.controleestoque.exception.FacadeException;
import br.ufpb.dce.poo.controleestoque.facade.ControleEstoqueFacade;
import br.ufpb.dce.poo.controleestoque.model.Produto;

public class ControleEstoqueTest {
	private Produto p1;
	private Produto p2;
	private Produto p3;
	private Produto p4;
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
		p4 = new Produto(4, "Purificador de Água Unilever Pureit Compact Azul",
				1, 199.00f);

		facade = new ControleEstoqueFacade();
		facade.cadastrarProduto(p1);
		facade.cadastrarProduto(p2);
		facade.cadastrarProduto(p3);
		facade.cadastrarProduto(p4);
	}

	@Test(expected = FacadeException.class)
	public void testCadastrarProduto() throws FacadeException {
		Produto p5 = new Produto(
				5,
				"Smartphone Samsung Galaxy Ace Preto, Desbloqueado Vivo, GSM, Android, Câmera de 5MP, Tela Touchscreen 3.5\", 3G, Wi-Fi, Bluetooth e Cartão de Memória 2GB",
				3, 499.00f);
		facade.cadastrarProduto(p5);
		Assert.assertEquals(facade.listarProdutos().size(), 5);

		Produto p6 = new Produto(
				6,
				"Smartphone Samsung Galaxy Ace Preto, Desbloqueado Vivo, GSM, Android, Câmera de 5MP, Tela Touchscreen 3.5\", 3G, Wi-Fi, Bluetooth e Cartão de Memória 2GB",
				2, 499.00f);
		facade.cadastrarProduto(p6);
		Assert.assertEquals(facade.listarProdutos().size(), 6);

		Produto p7 = new Produto(6,
				"Sofá de Canto Chicago - Chenille Preto - Gazin", 1, 799.90f);
		facade.cadastrarProduto(p7);
		Assert.assertEquals(facade.listarProdutos().size(), 6);
	}

	@Test(expected = FacadeException.class)
	public void testDescadastrarProduto() throws FacadeException {
		facade.descadastrarProduto(1);
		Assert.assertEquals(facade.listarProdutos().size(), 3);
		
		facade.descadastrarProduto(5);
		Assert.assertEquals(facade.listarProdutos().size(), 3);

		facade.descadastrarProduto(-1);
		Assert.assertEquals(facade.listarProdutos().size(), 3);
		
		facade.descadastrarProduto(4);
		Assert.assertEquals(facade.listarProdutos().size(), 2);
	}

	@Test(expected = FacadeException.class)
	public void testBuscarProduto() throws FacadeException {
		Produto produto = facade.buscarProduto(1);
		Assert.assertEquals(899.00f, produto.getValor());

		produto = null;
		produto = facade.buscarProduto(5);
		Assert.assertNull(produto);

		produto = facade.buscarProduto(2);
		Assert.assertEquals(5, produto.getQuantidade());
		
		produto = facade.buscarProduto(4);
		Assert.assertEquals(1, produto.getQuantidade());
	}

	@Test(expected = FacadeException.class)
	public void testListarProdutos() throws FacadeException {
		List<Produto> produtos = facade.listarProdutos();
		Assert.assertEquals(4, produtos.size());

		facade.descadastrarProduto(1);
		produtos = facade.listarProdutos();
		Assert.assertEquals(3, produtos.size());

		facade.descadastrarProduto(2);
		produtos = facade.listarProdutos();
		Assert.assertEquals(2, produtos.size());

		facade.descadastrarProduto(3);
		produtos = facade.listarProdutos();
		Assert.assertEquals(1, produtos.size());
		
		facade.descadastrarProduto(4);
		produtos = facade.listarProdutos();
		Assert.assertEquals(0, produtos.size());
	}

	@Test(expected = FacadeException.class)
	public void testGetQuantidadeProduto() throws FacadeException {
		Assert.assertEquals(10, facade.getQuantidadeProduto(1));
		Assert.assertEquals(10, facade.getQuantidadeProduto(5));
		Assert.assertEquals(5, facade.getQuantidadeProduto(2));
		Assert.assertEquals(1, facade.getQuantidadeProduto(4));
	}

	@Test(expected = FacadeException.class)
	public void testReporProduto() throws FacadeException {
		Assert.assertEquals(10, facade.getQuantidadeProduto(1));
		facade.reporProduto(1, 5);
		Assert.assertEquals(15, facade.getQuantidadeProduto(1));

		Assert.assertEquals(5, facade.getQuantidadeProduto(2));
		facade.reporProduto(2, 0);
		Assert.assertEquals(5, facade.getQuantidadeProduto(2));

		facade.reporProduto(4, 1);
		Assert.assertEquals(2, facade.getQuantidadeProduto(4));

		facade.reporProduto(3, -1);
		Assert.assertEquals(1, facade.getQuantidadeProduto(3));
		
		Assert.assertEquals(1, facade.getQuantidadeProduto(4));
		facade.reporProduto(4, 1);
		Assert.assertEquals(3, facade.getQuantidadeProduto(4));
	}

	@Test(expected = FacadeException.class)
	public void testRetirarProduto() throws FacadeException {
		Assert.assertEquals(10, facade.getQuantidadeProduto(1));
		facade.retirarProduto(1, 5);
		Assert.assertEquals(5, facade.getQuantidadeProduto(1));

		Assert.assertEquals(5, facade.getQuantidadeProduto(2));
		facade.retirarProduto(2, 0);
		Assert.assertEquals(5, facade.getQuantidadeProduto(2));

		facade.retirarProduto(4, 1);
		Assert.assertEquals(0, facade.getQuantidadeProduto(4));

		facade.retirarProduto(3, -1);
		Assert.assertEquals(1, facade.getQuantidadeProduto(3));
	}

	@Test(expected = FacadeException.class)
	public void testValorTotalEmEstoque() throws FacadeException {
		Assert.assertEquals(25653.1f, facade.getValorTotalEmEstoque());

		Produto p5 = new Produto(
				5,
				"Smartphone Samsung Galaxy Ace Preto, Desbloqueado Vivo, GSM, Android, Câmera de 5MP, Tela Touchscreen 3.5\", 3G, Wi-Fi, Bluetooth e Cartão de Memória 2GB",
				3, 499.00f);
		facade.cadastrarProduto(p5);
		Assert.assertEquals(27150.1f, facade.getValorTotalEmEstoque());

		facade.descadastrarProduto(1);
		Assert.assertEquals(18160.1f, facade.getValorTotalEmEstoque());

		facade.descadastrarProduto(2);
		Assert.assertEquals(4665.1f, facade.getValorTotalEmEstoque());

		facade.descadastrarProduto(3);
		Assert.assertEquals(1696.0f, facade.getValorTotalEmEstoque());

		facade.descadastrarProduto(4);
		Assert.assertEquals(1497f, facade.getValorTotalEmEstoque());
		
		facade.descadastrarProduto(5);
		Assert.assertEquals(0f, facade.getValorTotalEmEstoque());
	}

	@Test(expected = FacadeException.class)
	public void testValorTotalProduto() throws FacadeException {
		Assert.assertEquals(8990f, facade.getValorTotalProduto(1));

		Produto p5 = new Produto(
				5,
				"Smartphone Samsung Galaxy Ace Preto, Desbloqueado Vivo, GSM, Android, Câmera de 5MP, Tela Touchscreen 3.5\", 3G, Wi-Fi, Bluetooth e Cartão de Memória 2GB",
				3, 499.00f);
		facade.cadastrarProduto(p5);
		Assert.assertEquals(1497.00f, facade.getValorTotalProduto(5));

		Assert.assertEquals(8990.0f, facade.getValorTotalProduto(1));
		Assert.assertEquals(13495.0f, facade.getValorTotalProduto(2));
		Assert.assertEquals(2969.1f, facade.getValorTotalProduto(3));
		Assert.assertEquals(199.0f, facade.getValorTotalProduto(4));
		
		Assert.assertEquals(0, facade.getValorTotalProduto(6));
	}
}
