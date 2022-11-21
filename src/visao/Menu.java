package visao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import controlador.Controlador;
import controlador.GastoControlador;
import entidade.Entidade;
import factory.AbstractFactory;
import main.Console;
import persistencia.Persistencia;

public abstract class Menu {

	public static void menuPrincipal() throws IOException {
		
		
		
		String op = "";
		do {
			while (!op.equals("gasto") && !op.equals("evento") && !op.equals("sair")) {

				System.out.println("Entre com o nome da opção que você deseja selecionar: ");
				System.out.println("gasto");
				System.out.println("evento");
				System.out.println("sair");

				op = Console.readLine();

			}
			if (op.equals("sair"))
				break;
			AbstractFactory fabrica = AbstractFactory.getFactory(op);
			Menu menuEntidade = fabrica.criarVisao();
			Entidade entidade = fabrica.criarEntidade();
			op= menuEntidade.menu(entidade);
			Controlador controlador = fabrica.criarControlador();
			controlador.controle(op, entidade, fabrica);

		} while (true);

	}
	


	public abstract String menu(Entidade entidade);
	public abstract void criar (Entidade entidade);
	public abstract void alterar (Entidade entidade);
	public abstract void excluir(Entidade entidade);
	public abstract String renomear();
	public abstract void buscarNome(Entidade entidade);
	public abstract void buscarId(Entidade entidade);
	public abstract Entidade mostrarBusca(Entidade entidade);


	public void mensagemDeSucesso(boolean sucesso) {
		if (sucesso == true)
			System.out.println("\nAÇÃO BEM SUCEDIDA\n");
		else
			System.out.println("\nNÃO FOI POSSÍVEL COMPLETAR A AÇÃO\n");
	}

}
