package venda.java;

public class Vendedor {

	public String nome;
	public int codigo;
	public static float comissao;
	public String endereco;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public static float getComissao() {
		return comissao;
	}

	public static void setComissao(float comissao) {
		Vendedor.comissao = comissao;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	Vendedor(String nome, String endereco, int codigo){
		this.nome = nome; //this p/ referenciar que o nome é do objeto, e não de outro parâmetro.
		this.endereco = endereco;
		this.codigo = codigo;
		
	}
	Vendedor(String nome, String endereco, int codigo, float comissao){
		this.nome = nome; //this p/ referenciar que o nome é do objeto, e não de outro parâmetro.
		this.endereco = endereco;
		this.codigo = codigo;
		Vendedor.comissao = comissao;
	}
	public String dadosVendedor() {
		String retorno = "Codi: " + this.codigo + "\nNome: " + this.nome;
		return retorno;
	}
}
