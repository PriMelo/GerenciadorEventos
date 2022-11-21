package factory;

import java.io.IOException;

import controlador.Controlador;
import controlador.GastoEventoControlador;
import entidade.Entidade;
import entidade.GastoEvento;
import persistencia.GastoEventoPersistencia;
import persistencia.Persistencia;
import visao.GastoEventoVisao;
import visao.Menu;

public class GastoEventoFactory extends AbstractFactory {

	@Override
	public Entidade criarEntidade() {
		return new GastoEvento();
	}

	public Persistencia criarPersistencia() throws IOException {
		return GastoEventoPersistencia.instance();
	}

	@Override
	public Menu criarVisao() {
		// TODO Auto-generated method stub
		return new GastoEventoVisao();
	}

	@Override
	public Controlador criarControlador() throws IOException {
		// TODO Auto-generated method stub
		return new GastoEventoControlador();
	}

}
