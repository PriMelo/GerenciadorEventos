package visao;

import entidade.Entidade;
import entidade.Gasto;
import entidade.GastoEvento;
import main.Console;

public class GastoEventoVisao extends Menu {

	@Override
	public String menu(Entidade entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void criar(Entidade entidade) {
		GastoEvento gastoEvento = (GastoEvento) entidade;
		System.out.println("Informe a quantidade de itens: ");
		Integer quant = Integer.parseInt(Console.readLine());
		System.out.println("Informe o preço unitário: ");
		Float preco = Float.parseFloat(Console.readLine());
		gastoEvento.setPreco(preco);
		gastoEvento.setQuantidade(quant);
	}
	
	public void addGasto(Gasto gasto, GastoEvento gastoEntidade) {
		
	}
	@Override
	public void alterar(Entidade entidade) {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluir(Entidade entidade) {
		// TODO Auto-generated method stub

	}

	@Override
	public String renomear() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void buscarNome(Entidade entidade) {
		// TODO Auto-generated method stub

	}

	@Override
	public void buscarId(Entidade entidade) {
		// TODO Auto-generated method stub

	}

	@Override
	public Entidade mostrarBusca(Entidade entidade) {
		return entidade;
		// TODO Auto-generated method stub

	}

	

}
