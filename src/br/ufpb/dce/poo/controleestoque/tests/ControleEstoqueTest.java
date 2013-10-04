package br.ufpb.dce.poo.controleestoque.tests;

import java.util.List;

import model.Produto;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import exception.FacadeException;
import facade.ControleEstoqueFacade;

public class ControleEstoqueTest {
	
	private Produto p1;
	private Produto p2;
	private Produto p3;
	private Produto p4;
	private ControleEstoqueFacade facade;

	@Before
	public void setUp() {
		p1 = new Produto(1,"Notebook Ultrafino CCE com Intel Dual Core 2GB 500GB LED 14\" Preto Windows 8",10, 899.00f);
		p2 = new Produto(2,"Geladeira / Refrigerador Brastemp Frost Free Ative Inverse BRE50 Inox 422 Litros",5, 2699.00f);
		p3 = new Produto(3,"Smart TV 3D LED 47\" LG 47LA6200 FULL HD 3 HDMI 3 USB Wi-fi 120Hz + 4 ”culos 3D",1, 2969.10f);
		p4 = new Produto(4, "Purificador de ¡gua Unilever Pureit Compact Azul",1, 199.00f);

		facade = new ControleEstoqueFacade();
		try {
			facade.cadastrarProduto(p1);
			facade.cadastrarProduto(p2);
			facade.cadastrarProduto(p3);
			facade.cadastrarProduto(p4);
		} catch (FacadeException e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testCadastrarProduto(){
		Produto p5 = new Produto(5,"Smartphone Samsung Galaxy Ace Preto, Desbloqueado Vivo, GSM, Android, C‚mera de 5MP, Tela Touchscreen 3.5\", 3G, Wi-Fi, Bluetooth e Cart„o de MemÛria 2GB",3, 499.00f);
		try {
			facade.cadastrarProduto(p5);
			Assert.assertEquals(facade.listarProdutos().size(), 5);
			Assert.assertTrue(facade.buscarProduto(5).getCodigo() == 5);
			Assert.assertEquals(facade.buscarProduto(5).getDescricao(),"Smartphone Samsung Galaxy Ace Preto, Desbloqueado Vivo, GSM, Android, C‚mera de 5MP, Tela Touchscreen 3.5\", 3G, Wi-Fi, Bluetooth e Cart„o de MemÛria 2GB");
			Assert.assertEquals(facade.buscarProduto(5).getQuantidade(), 3);
			Assert.assertEquals(facade.buscarProduto(5).getValor(), 499.00f, 0.1);
			Assert.assertTrue(facade.buscarProduto(5).equals(p5));
		} catch (FacadeException e) {
			Assert.fail(e.getMessage());
		}
		
		Produto p6 = new Produto(6,"Smartphone Samsung Galaxy Ace Preto, Desbloqueado Vivo, GSM, Android, C‚mera de 5MP, Tela Touchscreen 3.5\", 3G, Wi-Fi, Bluetooth e Cart„o de MemÛria 2GB",2, 499.00f);
		try {
			facade.cadastrarProduto(p6);
			Assert.assertEquals(facade.listarProdutos().size(), 6);
			Assert.assertTrue(facade.buscarProduto(6).getCodigo() == 6);
			Assert.assertEquals(facade.buscarProduto(6).getDescricao(),"Smartphone Samsung Galaxy Ace Preto, Desbloqueado Vivo, GSM, Android, C‚mera de 5MP, Tela Touchscreen 3.5\", 3G, Wi-Fi, Bluetooth e Cart„o de MemÛria 2GB");
			Assert.assertEquals(facade.buscarProduto(6).getQuantidade(), 2);
			Assert.assertEquals(facade.buscarProduto(6).getValor(), 499.00f, 0.1);
			Assert.assertTrue(facade.buscarProduto(6).equals(p6));
		} catch (FacadeException e) {
			Assert.fail(e.getMessage());
		}
		
		Produto p7 = new Produto(7,"Sof· de Canto Chicago - Chenille Preto - Gazin", 1, 799.90f);
		try {
			facade.cadastrarProduto(p7);
			Assert.assertEquals(facade.listarProdutos().size(), 7);
			Assert.assertTrue(facade.buscarProduto(7).getCodigo() == 7);
			Assert.assertEquals(facade.buscarProduto(7).getDescricao(),"Sof· de Canto Chicago - Chenille Preto - Gazin");
			Assert.assertEquals(facade.buscarProduto(7).getQuantidade(), 1);
			Assert.assertEquals(facade.buscarProduto(7).getValor(), 799.90f, 0.1);
			Assert.assertTrue(facade.buscarProduto(7).equals(p7));
		} catch (FacadeException e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void testRemover(){
		try {
			facade.remover(1);
			Assert.assertEquals(facade.listarProdutos().size(), 3);
		} catch (FacadeException e1) {
			Assert.fail(e1.getMessage());
		}
		try {
			facade.remover(5);
			Assert.fail("devia lanÁa uma execeÁ„o");
		} catch (FacadeException e1) {
			// tem que lanÁa a exceÁ„o por que o valor informado n„o existe
		}
		try{
			facade.remover(-1);
			Assert.fail("devia lanÁa uma execeÁ„o");
		}catch(FacadeException e){
			
		}
		try {
			facade.remover(4);
			Assert.assertEquals(facade.listarProdutos().size(), 2);
		} catch (FacadeException e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testBuscarProduto(){
		Produto produto = null;
		try {
			produto = facade.buscarProduto(5);
			Assert.fail("deveria ter lanÁado uma exceÁ„o");
		} catch (FacadeException e) {
			Assert.assertNull(produto);
		}
		try {
			produto = facade.buscarProduto(1);
			Assert.assertEquals(899.00f, produto.getValor(), 0.1);
			Assert.assertEquals(1, produto.getCodigo());
			Assert.assertEquals("Notebook Ultrafino CCE com Intel Dual Core 2GB 500GB LED 14\" Preto Windows 8", produto.getDescricao());
			Assert.assertEquals(10, produto.getQuantidade());
			Assert.assertTrue(facade.buscarProduto(1).equals(this.p1));
		} catch (FacadeException e) {
			Assert.fail(e.getMessage());
		}
		try {
			produto = facade.buscarProduto(2);
			Assert.assertEquals(2699.00f,produto.getValor(), 0.1);
			Assert.assertEquals(2, produto.getCodigo());
			Assert.assertEquals("Geladeira / Refrigerador Brastemp Frost Free Ative Inverse BRE50 Inox 422 Litros", produto.getDescricao());
			Assert.assertEquals(5, produto.getQuantidade());
			Assert.assertTrue(facade.buscarProduto(2).equals(this.p2));
		} catch (FacadeException e) {
			Assert.fail(e.getMessage());
		}
		try {
			produto = facade.buscarProduto(4);
			Assert.assertEquals(199.00f,produto.getValor(), 0.1);
			Assert.assertEquals(4, produto.getCodigo());
			Assert.assertEquals("Purificador de ¡gua Unilever Pureit Compact Azul", produto.getDescricao());
			Assert.assertEquals(1, produto.getQuantidade());
			Assert.assertTrue(facade.buscarProduto(4).equals(this.p4));
		} catch (FacadeException e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void testListarProdutos() {
		List<Produto> produtos;
		try {
			produtos = facade.listarProdutos();
			Assert.assertEquals(4, produtos.size());
		} catch (FacadeException e) {
			Assert.fail(e.getMessage());
		}
		try {
			facade.remover(1);
			produtos = facade.listarProdutos();
			Assert.assertEquals(3, produtos.size());
		} catch (FacadeException e) {
			Assert.fail(e.getMessage());
		}
		try {
			facade.remover(2);
			produtos = facade.listarProdutos();
			Assert.assertEquals(2, produtos.size());
		} catch (FacadeException e) {
			Assert.fail(e.getMessage());
		}
		try {
			facade.remover(3);
			produtos = facade.listarProdutos();
			Assert.assertEquals(1, produtos.size());
		} catch (FacadeException e) {
			Assert.fail(e.getMessage());
		}
		try {
			facade.remover(4);
			produtos = facade.listarProdutos();
			Assert.fail("deveria ter lanÁado uma exceÁ„o");
		} catch (FacadeException e) {
			// lanÁa a exceÁ„o por que a lista esta vazia
		}
	}

	@Test
	public void testGetQuantidadeProduto() {
		try {
			Assert.assertEquals(10, facade.getQuantidadeProduto(1));
		} catch (FacadeException e) {
			Assert.fail(e.getMessage());
		}
		try {
			
			facade.getQuantidadeProduto(5);
			Assert.fail("era para lanÁa exceÁ„o");
		} catch (FacadeException e) {
			// n„o È para lanÁa exceÁ„o por que o valor n„o È valido
		}
		try {
			Assert.assertEquals(5, facade.getQuantidadeProduto(2));
		} catch (FacadeException e) {
			Assert.fail(e.getMessage());
		}
		try {
			Assert.assertEquals(1, facade.getQuantidadeProduto(4));
		} catch (FacadeException e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testReporProduto() {
		try {
			Assert.assertEquals(10, facade.getQuantidadeProduto(1));
			Assert.assertTrue(facade.buscarProduto(1).equals(this.p1));
		} catch (FacadeException e) {
			Assert.fail(e.getMessage());
		}
		try {
			facade.reporProduto(1, 5);
			Assert.assertEquals(15, facade.getQuantidadeProduto(1));
			Assert.assertTrue(facade.buscarProduto(1).equals(this.p1));
		} catch (FacadeException e) {
			Assert.fail(e.getMessage());
		}
		try {
			facade.reporProduto(10, 5);
			Assert.fail("deveria ter lanÁado uma exceÁ„o");
		} catch (FacadeException e) {
			// È para lanÁa uma exceÁ„o
		}
		try {
			Assert.assertEquals(5, facade.getQuantidadeProduto(2));
			Assert.assertTrue(facade.buscarProduto(2).equals(this.p2));
		} catch (FacadeException e) {
			Assert.fail(e.getMessage());
		}
		try {
			facade.reporProduto(2, 0);
			Assert.assertEquals(5, facade.getQuantidadeProduto(2));
			Assert.assertTrue(facade.buscarProduto(2).equals(this.p2));
		} catch (FacadeException e1) {
			Assert.fail(e1.getMessage());
		}
		try {
			facade.reporProduto(4, 1);
			Assert.assertEquals(2, facade.getQuantidadeProduto(4));
			Assert.assertTrue(facade.buscarProduto(4).equals(this.p4));
		} catch (FacadeException e1) {
			Assert.fail(e1.getMessage());
		}
		try {
			facade.reporProduto(3, -1);
			Assert.assertEquals(1, facade.getQuantidadeProduto(3));
			Assert.fail("deveria ter lanÁado uma exceÁ„o");
		} catch (FacadeException e1) {
			// È para lanÁa uma exceÁ„o
		}
		try {
			Assert.assertEquals(2, facade.getQuantidadeProduto(4));
			Assert.assertTrue(facade.buscarProduto(4).equals(this.p4));
		} catch (FacadeException e) {
			Assert.fail(e.getMessage());
		}
		try {
			facade.reporProduto(4, 1);
			Assert.assertEquals(3, facade.getQuantidadeProduto(4));
		} catch (FacadeException e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testRetirarProduto() {
		try {
			Assert.assertEquals(10, facade.getQuantidadeProduto(1));
		} catch (FacadeException e) {
			Assert.fail(e.getMessage());
		}
		try {
			facade.retirarProduto(1, 5);
			Assert.assertEquals(5, facade.getQuantidadeProduto(1));
		} catch (FacadeException e) {
			Assert.fail(e.getMessage());
		}
		try {
			facade.retirarProduto(2, 0);
			Assert.assertEquals(5, facade.getQuantidadeProduto(2));
		} catch (FacadeException e) {
			Assert.fail(e.getMessage());
		}
		try {
			facade.retirarProduto(4, 1);
			Assert.assertEquals(0, facade.getQuantidadeProduto(4));
		} catch (FacadeException e) {
			Assert.fail(e.getMessage());
		}
		try {
			facade.retirarProduto(3, -1);
			Assert.fail("deveria ter lanÁado uma exceÁ„o");
		} catch (FacadeException e) {
			// È para lanÁa uma exceÁ„o
		}
	}

	@Test
	public void testValorTotalEmEstoque() {
		try {
			Assert.assertEquals(25653.1f, facade.getValorTotalEmEstoque(), 0.1);
		} catch (FacadeException e) {
			Assert.fail(e.getMessage());
		}
		Produto p5 = new Produto(5,"Smartphone Samsung Galaxy Ace Preto, Desbloqueado Vivo, GSM, Android, C‚mera de 5MP, Tela Touchscreen 3.5\", 3G, Wi-Fi, Bluetooth e Cart„o de MemÛria 2GB",3, 499.00f);
		try {
			facade.cadastrarProduto(p5);
			Assert.assertEquals(27150.1f, facade.getValorTotalEmEstoque(), 0.1);
		} catch (FacadeException e) {
			Assert.fail(e.getMessage());
		}
		try {
			facade.remover(1);
			Assert.assertEquals(18160.1f, facade.getValorTotalEmEstoque(), 0.1);
		} catch (FacadeException e) {
			Assert.fail(e.getMessage());
		}
		try {
			facade.remover(2);
			Assert.assertEquals(4665.1f, facade.getValorTotalEmEstoque(), 0.1);
		} catch (FacadeException e) {
			Assert.fail(e.getMessage());
		}
		try {
			facade.remover(3);
			Assert.assertEquals(1696.0f, facade.getValorTotalEmEstoque(), 0.1);
		} catch (FacadeException e) {
			Assert.fail(e.getMessage());
		}
		try {
			facade.remover(4);
			Assert.assertEquals(1497f, facade.getValorTotalEmEstoque(), 0.1);
		} catch (FacadeException e) {
			Assert.fail(e.getMessage());
		}
		try {
			facade.remover(5);
			//Assert.fail("deveria ter lanÁado uma exceÁ„o");
		} catch (FacadeException e) {
			Assert.fail(e.getMessage());
			// era para lanÁa exceÁ„o por que o valor da lista È 0
		}
	}

	@Test
	public void testValorTotalProduto() {
		try {
			Assert.assertEquals(8990f, facade.getValorTotalProduto(1), 0.1);
		} catch (FacadeException e) {
			Assert.fail(e.getMessage());
		}
		Produto p5 = new Produto(5,"Smartphone Samsung Galaxy Ace Preto, Desbloqueado Vivo, GSM, Android, C‚mera de 5MP, Tela Touchscreen 3.5\", 3G, Wi-Fi, Bluetooth e Cart„o de MemÛria 2GB",3, 499.00f);
		try {
			facade.cadastrarProduto(p5);
		} catch (FacadeException e) {
			Assert.fail(e.getMessage());
		}
		try {
			Assert.assertEquals(1497.00f, facade.getValorTotalProduto(5), 0.1);
		} catch (FacadeException e) {
			Assert.fail(e.getMessage());
		}
		try {
			Assert.assertEquals(8990.0f, facade.getValorTotalProduto(1), 0.1);
		} catch (FacadeException e) {
			Assert.fail(e.getMessage());
		}
		try {
			Assert.assertEquals(13495.0f, facade.getValorTotalProduto(2), 0.1);
		} catch (FacadeException e) {
			Assert.fail(e.getMessage());
		}
		try {
			Assert.assertEquals(2969.1f, facade.getValorTotalProduto(3), 0.1);
		} catch (FacadeException e) {
			Assert.fail(e.getMessage());
		}
		try {
			Assert.assertEquals(199.0f, facade.getValorTotalProduto(4), 0.1);
		} catch (FacadeException e) {
			Assert.fail(e.getMessage());
		}
		try {
			facade.getValorTotalProduto(6);
			Assert.fail("deveria ter lanÁado a exceÁ„o");
		} catch (FacadeException e) {
			// È para lanÁa a exceÁ„o
		}
	}
}
