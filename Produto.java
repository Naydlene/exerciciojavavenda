package venda.java;
public class Produto {
	
	public int codigo;
	public String descricao;
	public float valorVenda;
	public float valorCusto;
	public String promocao;

	
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
	public float getValorVenda() {
		return valorVenda;
	}
	public void setValorVenda(float valorVenda) {
		this.valorVenda = valorVenda;
	}
	public float getValorCusto() {
		return valorCusto;
	}
	public void setValorCusto(float valorCusto) {
		this.valorCusto = valorCusto;
	}
	public String getPromocao() {
		return promocao;
	}
	public void setPromocao(String promocao) {
		this.promocao = promocao;
	}
	
	Produto(int codigo, String descricao, float valorVenda, float valorCusto, String promocao){
		this.codigo = codigo;
		this.descricao = descricao;
		this.valorVenda = valorVenda;
		this.valorCusto = valorCusto;
		this.promocao = promocao;
		
	}

	public String dadosProdutos() {
		String retorno = "Codi: " + this.codigo + "\nDesc: " + this.descricao + "\nValor: " + this.valorVenda;
		return retorno;
	}
}
