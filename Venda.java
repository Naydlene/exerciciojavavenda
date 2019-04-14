package venda.java;

public class Venda {
	
	public Produto produto;
	public Vendedor vendedor;
	public float desconto;
	public int quantidadeItens;
	public float valorPago;
	public boolean vendaRealizada = false;
	
	public float getDesconto() {
		return desconto;
	}
	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}
	public float getValorPago() {
		return valorPago;
	}
	public void setValorPago(float valorPago) {
		this.valorPago = valorPago;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	public int getQuantidadeItens() {
		return quantidadeItens;
	}
	public void setQuantidadeItens(int quantidadeItens) {
		this.quantidadeItens = quantidadeItens;
	}
	
	public void efetuarDesconto(float desconto, float valorVenda, float valorCusto) {
		float calcdesconto = valorVenda - (valorVenda *(desconto/100));
		if(this.desconto > valorCusto) {
			System.err.println("Desconto nao permitido");
			vendaRealizada = false;
		}
		else {
			this.vendaRealizada = true;
			this.valorPago = calcdesconto;
		}	
	}
	public boolean isVendaRealizada() {
		return vendaRealizada;
	}
	public void setVendaRealizada(boolean vendaRealizada) {
		this.vendaRealizada = vendaRealizada;
	}
	
	public String dadosVendas() {
		String retorno = "CodVend " + this.vendedor.getCodigo() + "\nCodProd: " + this.produto.getCodigo() + "\nValor: " + (this.valorPago * quantidadeItens);
		return retorno;
	}
	

}
