package factory;

import java.io.IOException;

import controlador.Controlador;
import entidade.Entidade;
import persistencia.Persistencia;
import visao.Menu;

public abstract class AbstractFactory {

	public static AbstractFactory getFactory(String s) {
		AbstractFactory fabrica = null;
		if (s.equals("evento")) {
			fabrica = new EventoFactory();
		} else if (s.equals("gasto")) {
			fabrica = new GastoFactory();
		}
		else if (s.equals("gasto evento")) {
			fabrica = new GastoEventoFactory();
		}
		return fabrica;

	}

	public abstract Entidade criarEntidade();

	public abstract Persistencia criarPersistencia() throws IOException;

	public abstract Menu criarVisao();

	public abstract Controlador criarControlador() throws IOException;

}
