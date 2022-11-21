package visao;

import entidade.Entidade;
import main.Console;

public class GastoVisao extends Menu {

	public String menu(Entidade entidade) {
		String op = "";
		do {

			do {
				System.out.println("Entre com o nome da opção que você deseja selecionar: ");
				System.out.println("criar");
				System.out.println("alterar");
				System.out.println("excluir");
				System.out.println("buscar por id");
				System.out.println("buscar por nome");
				System.out.println("voltar");
				op = Console.readLine();
			} while (!op.equals("criar") && !op.equals("buscar") && !op.equals("buscar por id")
					&& !op.equals("buscar por nome") && !op.equals("alterar") && !op.equals("excluir")
					&& !op.equals("voltar"));

			if (op.equals("voltar"))
				break;

			switch (op) {

			case "criar":
				criar(entidade);
				break;

			case "alterar":
				alterar(entidade);
				break;
			case "excluir":
				excluir(entidade);
				break;
			case "buscar por id":
				buscarId(entidade);
				break;
			case "buscar por nome":
				buscarNome(entidade);
				break;
			}

		} while (!op.equals("criar") && !op.equals("buscar por id") && !op.equals("buscar por nome")
				&& !op.equals("alterar") && !op.equals("excluir") && !op.equals("voltar"));

		return op;

	}

	public void buscarId(Entidade entidade) {
		System.out.println("Informe o id do gasto que você deseja buscar");
		Integer id = Integer.parseInt(Console.readLine());
		entidade.setId(id);
	}

	public void buscarNome(Entidade entidade) {
		System.out.println("Informe o nome do gasto que você deseja buscar");
		String nome = Console.readLine();
		entidade.setNome(nome);
	}

	public void alterar(Entidade entidade) {
		System.out.println("Informe o nome do gasto que você deseja alterar");
		String nome = Console.readLine();
		entidade.setNome(nome);

	}

	public void excluir(Entidade entidade) {
		System.out.println("Informe o nome do gasto que você deseja excluir");
		String nome = Console.readLine();
		entidade.setNome(nome);

	}

	public String renomear() {
		System.out.println("Informe o novo nome do gasto");
		String nome = Console.readLine();
		return nome;

	}

	public void criar(Entidade entidade) {
		System.out.println("Informe o nome do gasto");
		String nome = Console.readLine();
		entidade.setNome(nome);

	}

	public Entidade mostrarBusca(Entidade entidade) {
		if (entidade != null) {
			System.out.println("Resultado da Busca: ");
			System.out.println("Nome do gasto: " + entidade.getNome() + "  Id gasto: " + entidade.getId());
		} else
			System.out.println("Gasto não encontrado");
		return entidade;
	}

}