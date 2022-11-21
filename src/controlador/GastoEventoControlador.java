package controlador;

import java.io.IOException;

import entidade.Entidade;
import entidade.Gasto;
import entidade.GastoEvento;
import factory.AbstractFactory;
import persistencia.Persistencia;
import visao.Menu;

public class GastoEventoControlador extends Controlador {
	
	public void controle(String comando, Entidade entidade, AbstractFactory fabrica) throws IOException {
		Menu gastoEventoVisao = fabrica.criarVisao();
			gastoEventoVisao.criar(entidade);
	}
	

	@Override
	public Entidade buscarNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void buscarId(Integer Id) {
		// TODO Auto-generated method stub
		
	}
	public void addGasto(Gasto gasto, GastoEvento gastoEvento) {
		gastoEvento.setGasto(gasto);
	}

	public void inserir(Entidade entidade, Persistencia persistencia) throws IOException {
	}

	@Override
	public void alterar(Entidade entidade) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Entidade entidade) throws IOException {
		// TODO Auto-generated method stub
		
	}
	

}
