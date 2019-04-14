package venda.java;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Scanner leitor = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<Produto> ListProdutos = new ArrayList<>();
		ArrayList<Vendedor> ListVendedor = new ArrayList<>();
		ArrayList<Venda> ListVendas = new ArrayList<>();
		int opcao;
		
		do {
			System.out.println(
					"Digite: \n 1 - Criar produto. \n 2 - Criar vendedor \n 3 - Exibir lista de produtos. \n 4 - Exibir lista de vendedor. \n 5 - Realizar Venda. \n 6 - Listar Vendas");
			opcao = leitor.nextInt();
			switch (opcao) {
			case 1:
				ListProdutos.add(criarProduto());
				break;
			case 2:
				ListVendedor.add(criarVendedor());
				break;

			case 3:
				exibirListaProdutos(ListProdutos);
				break;

			case 4:
				exibirListaVendedor(ListVendedor);
				break;
				
			case 5:
				ListVendas.add(realizarVenda(ListProdutos, ListVendedor));
				break;
			case 6:
				exibirListaVendas(ListVendas);
				break;
			}
		} while (opcao != 0);
	}

	static public Produto criarProduto() {
		System.out.println("Informe o código do produto: ");
		int codigo = leitor.nextInt();
		String lixo = leitor.nextLine();
		System.out.println("Informe a descrição do produto: ");
		String descricao = leitor.nextLine();
		System.out.println("Informe o valor da venda: ");
		float valorVenda = leitor.nextFloat();
		System.out.println("Informe o valor do custo: ");
		float valorCusto = leitor.nextFloat();
		lixo = leitor.nextLine();
		System.out.println("O produto está em promoção?\n Sim \n Não ");
		String promocao = leitor.nextLine();
		Produto produto = new Produto(codigo, descricao, valorVenda, valorCusto, promocao);
		return produto;
	}

	static public Vendedor criarVendedor() {
		String lixo = leitor.nextLine();
		System.out.println("Informe o seu nome: ");
		String nome = leitor.nextLine();
		System.out.println("Informe o código: ");
		int codigo = leitor.nextInt();
		System.out.println("Informe a sua comissão: ");
		float comissao = leitor.nextFloat();
		lixo = leitor.nextLine();
		System.out.println("Informe o seu endereço: ");
		String endereco = leitor.nextLine();
		Vendedor vendedor = new Vendedor(nome, endereco, codigo, comissao);
		return vendedor;
	}
	static private void exibirListaProdutos(ArrayList<Produto> ListProdutos) {
		for (Produto p : ListProdutos) {
			System.out.println("Produto: ");
			System.out.println(p.dadosProdutos());
		}
	}
	static private void exibirListaVendedor(ArrayList<Vendedor> ListVendedor) {

		for (Vendedor v : ListVendedor) {
			System.out.println("Vendedor: ");
			System.out.println(v.dadosVendedor());
		}
	}
	static private void exibirListaVendas(ArrayList<Venda> ListVenda) {
		for (Venda v : ListVenda) {
			System.out.println("Venda: ");
			System.out.println(v.dadosVendas());
		}
	}
	static private Venda realizarVenda(ArrayList<Produto> ListProdutos, ArrayList<Vendedor> ListVendedor) {
		Venda venda = new Venda();
		Produto produto;
		Vendedor vendedor;
		int codProd;
		int codVend;
		do {
			do {
				exibirListaProdutos(ListProdutos);
				System.out.println("Digite o código da mercadoria: ");
				codProd = leitor.nextInt();
			}while(!confirmarProduto(ListProdutos, codProd));
			
			produto = retornaProduto(ListProdutos, codProd);
			System.out.println("Informe a quantidade de itens: ");
			int qtdItens = leitor.nextInt();
			do{	
				exibirListaVendedor(ListVendedor);
				System.out.println("Informe o código do vendedor: ");
				codVend = leitor.nextInt();
			}while(!confirmarVendedor(ListVendedor, codVend));
			vendedor = retornaVendedor(ListVendedor, codVend);
			System.out.println("Informe o Desconto em porcentagem");
			int desconto = leitor.nextInt();
			
			venda.efetuarDesconto(desconto, produto.getValorVenda(), produto.getValorCusto());
			
			if(venda.isVendaRealizada()) {
				venda.setProduto(produto);
				venda.setQuantidadeItens(qtdItens);
				venda.setDesconto(desconto);
				venda.setVendedor(vendedor);
			}
			
		}while(!venda.isVendaRealizada());
		return venda;
	}
	
	static private boolean confirmarProduto(ArrayList<Produto> ListProdutos,int codprod) {
		for (Produto p : ListProdutos) {
			if(p.getCodigo() == codprod)
				return true;
		}
	 System.err.println("Produto inexistente, digite o codigo certo.");
	 return false;
	}
	
	static private boolean confirmarVendedor(ArrayList<Vendedor> ListVendedor,int codvend) {
		for (Vendedor v : ListVendedor) {
			if(v.getCodigo() == codvend)
				return true;
		}
	 System.err.println("Vendedor inexistente, digite o codigo certo.");
	 return false;
	}
	
	static private Vendedor retornaVendedor(ArrayList<Vendedor> ListVendedor,int codvend) {
		for (Vendedor v : ListVendedor) {
			if(v.getCodigo() == codvend)
				return v;
		}
	 return null;
	}
	
	
	static private Produto retornaProduto(ArrayList<Produto> ListProdutos, int codprod) {
		for (Produto p : ListProdutos) {
			if(p.getCodigo() == codprod)
				return p;
		}
		return null;
	}

}
