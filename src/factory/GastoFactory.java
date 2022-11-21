package factory;

import java.io.IOException;

import controlador.Controlador;
import controlador.GastoControlador;
import entidade.Entidade;
import entidade.Gasto;
import persistencia.GastoPersistencia;
import persistencia.Persistencia;
import visao.GastoVisao;
import visao.Menu;

public class GastoFactory extends AbstractFactory{

	public Entidade criarEntidade() {
		return new Gasto();
	}

	public Persistencia criarPersistencia() throws IOException {
		
		return GastoPersistencia.instance();
	}

	public Menu criarVisao() {
		return new GastoVisao();
	}

	public Controlador criarControlador() throws IOException {
		return new GastoControlador();
	}

}
