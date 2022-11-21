package visao;

import entidade.Entidade;
import entidade.GastoEvento;
import main.Console;

public class EventoVisao extends Menu {

	public String menu(Entidade entidade) {
		String op = "";
		do {

			do {
				System.out.println("Entre com o nome da opção que você deseja selecionar: ");
				System.out.println("criar");
				System.out.println("alterar");
				System.out.println("excluir evento");
				System.out.println("buscar por id");
				System.out.println("buscar por nome");
				System.out.println("inserir gasto");
				System.out.println("excluir gasto");
				System.out.println("voltar");
				op = Console.readLine();
			} while (!op.equals("criar") && !op.equals("inserir gasto") && !op.equals("buscar")
					&& !op.equals("buscar por id") && !op.equals("buscar por nome") && !op.equals("alterar")
					&& !op.equals("excluir evento") && !op.equals("voltar") && !op.equals("excluir gasto"));

			if (op.equals("voltar"))
				break;

			switch (op) {

			case "criar":
				criar(entidade);
				break;

			case "alterar":
				alterar(entidade);
				break;
			case "excluir evento":
				excluir(entidade);
				break;
			case "buscar por id":
				buscarId(entidade);
				break;
			case "buscar por nome":
				buscarNome(entidade);
				break;
			case "inserir gasto":
				inserirGasto(entidade);
				break;
			case "excluir gasto":
				 excluirGasto(entidade);
				break;
			}

		} while (!op.equals("criar") && !op.equals("buscar por id") && !op.equals("buscar por nome")
				&& !op.equals("alterar") && !op.equals("excluir evento") && !op.equals("voltar")
				&& !op.equals("inserir gasto") &&  !op.equals("excluir gasto"));

		return op;

	}

	private void excluirGasto(Entidade entidade) {
		System.out.println("Informe o nome do evento em que será feita a exclusão do gasto");
		String nome = Console.readLine();
		entidade.setNome(nome);
		
	}

	private void inserirGasto(Entidade entidade) {
		System.out.println("Informe o nome do evento em que será feita a inserção");
		String nome = Console.readLine();
		entidade.setNome(nome);		
	}

	public void buscarId(Entidade entidade) {
		System.out.println("Informe o id do evento que você deseja buscar");
		Integer id = Integer.parseInt(Console.readLine());
		entidade.setId(id);
	}

	public void buscarNome(Entidade entidade) {
		System.out.println("Informe o nome do evento que você deseja buscar");
		String nome = Console.readLine();
		entidade.setNome(nome);
	}

	public void alterar(Entidade entidade) {
		System.out.println("Informe o nome do evento que você deseja alterar");
		String nome = Console.readLine();
		entidade.setNome(nome);

	}

	public void excluir(Entidade entidade) {
		System.out.println("Informe o nome do evento que você deseja excluir");
		String nome = Console.readLine();
		entidade.setNome(nome);

	}

	public String renomear() {
		System.out.println("Informe o novo nome do evento");
		String nome = Console.readLine();
		return nome;

	}

	public void criar(Entidade entidade) {
		System.out.println("Informe o nome do evento");
		String nome = Console.readLine();
		entidade.setNome(nome);
	}

	public Entidade mostrarBusca(Entidade entidade) {
		if (entidade != null) {
			System.out.println("Resultado da Busca: ");
			System.out.println(entidade.toString());
		} else
			System.out.println("Evento não encontrado");
		return entidade;
	}
	
	public void dadosGastoEvento(Entidade entidade) {
		GastoEvento gastoEvento = (GastoEvento) entidade;
		System.out.println("Informe a quantidade de itens: ");
		Integer quant = Integer.parseInt(Console.readLine());
		System.out.println("Informe o preço unitário: ");
		Float preco = Float.parseFloat(Console.readLine());
		gastoEvento.setPreco(preco);
		gastoEvento.setQuantidade(quant);
	}

	
	

}
