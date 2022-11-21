package factory;

import java.io.IOException;

import controlador.Controlador;
import controlador.EventoControlador;
import entidade.Entidade;
import entidade.Evento;
import persistencia.EventoPersistencia;
import persistencia.Persistencia;
import visao.EventoVisao;
import visao.Menu;

public class EventoFactory extends AbstractFactory{

	public Entidade criarEntidade() {
		return new Evento();
	}

	public Persistencia criarPersistencia() throws IOException {
		return EventoPersistencia.instance();
	}

	public Menu criarVisao() {
		return new EventoVisao();
	}

	public Controlador criarControlador() throws IOException {
		return new EventoControlador();
	}

}
