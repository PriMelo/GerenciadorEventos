package controlador;

import java.io.IOException;
import entidade.Entidade;
import factory.AbstractFactory;
import persistencia.Persistencia;
import visao.Menu;

public class GastoControlador extends Controlador {
	private AbstractFactory fabrica;
	private Menu menu;
	private Persistencia persistencia;

	public GastoControlador() throws IOException {
		fabrica = AbstractFactory.getFactory("gasto");
		menu = fabrica.criarVisao();
		persistencia = fabrica.criarPersistencia();

	}

	public void inserir(Entidade entidade, Persistencia persistencia) throws IOException {

		persistencia.inserir(entidade);
		menu.mensagemDeSucesso(true);
	}

	public void alterar(Entidade entidade) throws IOException {
		String s = menu.renomear();
		boolean sucesso = persistencia.alterar(entidade, s);
		menu.mensagemDeSucesso(sucesso);
	}
	public void excluir(Entidade entidade) throws IOException {
		boolean sucesso = persistencia.excluir(entidade);
		menu.mensagemDeSucesso(sucesso);
	}

	public Entidade buscarNome(String nome) {
		
		return menu.mostrarBusca(persistencia.buscarNome(nome));
	}

	public void buscarId(Integer id) {
		menu.mostrarBusca(persistencia.buscarId(id));
	}

}
