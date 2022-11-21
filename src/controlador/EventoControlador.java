package controlador;

import java.io.IOException;
import java.util.List;

import entidade.Entidade;
import entidade.Evento;
import entidade.Gasto;
import entidade.GastoEvento;
import factory.AbstractFactory;
import persistencia.Persistencia;
import visao.EventoVisao;
import visao.Menu;

public class EventoControlador<retutn> extends Controlador {

	private AbstractFactory fabrica;
	private Menu menu;
	private Persistencia persistencia;

	public EventoControlador() throws IOException {
		fabrica = AbstractFactory.getFactory("evento");
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

	public void excluirGasto(Entidade e) throws IOException {
		Evento entidade = (Evento) persistencia.buscarNome(e.getNome());
		boolean sucesso = false;
		if (entidade != null) {
			AbstractFactory fabricaGasto = AbstractFactory.getFactory("gasto");
			GastoControlador controladorGasto = null;
			controladorGasto = (GastoControlador) fabricaGasto.criarControlador();
			Menu gastoVisao = fabricaGasto.criarVisao();
			Entidade gastoBusca = fabricaGasto.criarEntidade();
			gastoVisao.buscarNome(gastoBusca);
			Gasto gasto = (Gasto) controladorGasto.buscarNome(gastoBusca.getNome());
			if (gasto != null) {
				List<GastoEvento> gastosEvento = entidade.getGastosEvento();
				for (GastoEvento g : gastosEvento) {
					if (g.getGasto().getId() == gasto.getId()) {
						gastosEvento.remove(g);
						sucesso = true;
						persistencia.alterarArquivo();
						break;
					}
				}
			}
		}
		menu.mensagemDeSucesso(sucesso);
	}

	public void inserirGasto(Entidade e) throws IOException {
		// menu.buscarNome(e);
		Evento entidade = (Evento) persistencia.buscarNome(e.getNome());
		boolean sucesso=false;
		if (entidade != null)

		{
			AbstractFactory fabricaGasto = AbstractFactory.getFactory("gasto");
			GastoControlador controladorGasto = null;
			controladorGasto = (GastoControlador) fabricaGasto.criarControlador();
			Menu gastoVisao = fabricaGasto.criarVisao();
			Entidade gastoBusca = fabricaGasto.criarEntidade();
			gastoVisao.buscarNome(gastoBusca);
			Gasto gasto = (Gasto) controladorGasto.buscarNome(gastoBusca.getNome());
			if (gasto != null) {
				AbstractFactory fabricaGastoEvento = AbstractFactory.getFactory("gasto evento");
				GastoEvento gastoEvento = (GastoEvento) fabricaGastoEvento.criarEntidade();
				EventoVisao menuEvento = (EventoVisao) menu;
				menuEvento.dadosGastoEvento(gastoEvento);
				GastoEventoControlador controladorGastoEvento = (GastoEventoControlador) fabricaGastoEvento
						.criarControlador();
				controladorGastoEvento.addGasto(gasto, gastoEvento);
				entidade.addGastoEvento(gastoEvento);
				sucesso=true;
				persistencia.alterarArquivo();
			}
		}
		menu.mensagemDeSucesso(sucesso);
	}

}
