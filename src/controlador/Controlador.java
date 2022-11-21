package controlador;

import java.io.IOException;
import java.util.List;

import entidade.Entidade;
import factory.AbstractFactory;
import persistencia.Persistencia;
import visao.Menu;

public abstract class Controlador {
	public void controle(String comando, Entidade entidade, AbstractFactory fabrica) throws IOException {
		Persistencia persistencia = fabrica.criarPersistencia();
		switch (comando) {
		case "criar":
			inserir(entidade, persistencia);
			break;
		case "alterar":
			alterar(entidade);
			break;
		case "excluir evento" :
			excluir(entidade);
			break;
		case "excluir":
			excluir(entidade);
			break;
		case "buscar por nome":
			buscarNome(entidade.getNome());
			break;
		case "buscar por id":
			buscarId(entidade.getId());
			break;
		case "inserir gasto":
			 inserirGasto(entidade);
			break;
		case "excluir gasto":
			 excluirGasto(entidade);
			break;
		}

	}

	public void excluirGasto(Entidade e) throws IOException {
		// TODO Auto-generated method stub
		
	}

	public void inserirGasto(Entidade entidade) throws IOException {}

	public abstract Entidade buscarNome(String nome);

	public abstract void buscarId(Integer Id);

	public abstract void inserir(Entidade entidade, Persistencia persistencia) throws IOException;

	public abstract void alterar(Entidade entidade) throws IOException;

	public abstract void excluir(Entidade entidade) throws IOException;

}
