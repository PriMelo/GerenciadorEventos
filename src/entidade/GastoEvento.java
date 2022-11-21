package entidade;

public class GastoEvento extends Entidade {
	private float preco;
	private Integer quantidade;
	private Gasto gasto;

	@Override
	public String toString() {
		String s = "\n-----------------:\n";
		s += "Preço: R$" + preco + "\nquantidade: " + quantidade + gasto.toString();
		return s;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}


	public Gasto getGasto() {
		return gasto;
	}

	public void setGasto(Gasto gasto) {
		this.gasto = gasto;
	}

}
