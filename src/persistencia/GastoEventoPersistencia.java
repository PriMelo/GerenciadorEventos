package persistencia;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import entidade.Entidade;

public class GastoEventoPersistencia extends Persistencia {
	private static GastoEventoPersistencia gastoEventoPersistencia = null;
	static java.io.File diretorio = null;
	static java.io.File arquivo;
	private static FileWriter texto = null;
	private static PrintWriter escritor = null;
	private static List<Entidade> gastosEvento = new ArrayList<Entidade>();

	public static Persistencia instance() {

		if (gastoEventoPersistencia == null) {
			gastoEventoPersistencia = new GastoEventoPersistencia();
			diretorio = new java.io.File("C:\\Users\\prit_\\eclipse-workspace\\ProjetoEngDeSoftware");
			arquivo = new java.io.File(diretorio, "gastoPersistencia.txt");
			if (arquivo != null)
				arquivo.delete();
		}
		return gastoEventoPersistencia;
	}

	public void inserir(Entidade entidade) throws IOException {

		Integer id;
		if (gastosEvento.size() == 0)
			id = 0;
		else {
			id = gastosEvento.size();
		}
		entidade.setId(id);
		gastosEvento.add(entidade);
		escreverArquivo(entidade);
	}

	public static List<Entidade> getGastos() {
		return gastosEvento;
	}

	public static void setGastos(List<Entidade> gastos) {
		GastoEventoPersistencia.gastosEvento = gastos;
	}

	public boolean alterar(Entidade entidade, String renome) throws IOException {

		for (Entidade e : gastosEvento) {
			if (e.getNome().equals(entidade.getNome())) {
				e.setNome(renome);
				alterarArquivo();
				return true;
			}
		}
		return false;

	}

	public void alterarArquivo() throws IOException {
		if (arquivo != null)
			arquivo.delete();
		for (Entidade e : gastosEvento)
			escreverArquivo(e);

	}

	public void escreverArquivo(Entidade entidade) throws IOException {
		texto = new FileWriter(arquivo, true);
		escritor = new PrintWriter(texto);
		escritor.println("_____________________________________");
		escritor.println("Id: #" + entidade.getId() + "#.");
		escritor.println("Nome: %" + entidade.getNome() + "%.");
		escritor.flush();
		escritor.close();
	}

	public boolean excluir(Entidade entidade) throws IOException {
		return true;
	}

	public Entidade buscarNome(String nome) {
		for (Entidade e : gastosEvento) {
			if (e.getNome().equals(nome)) {
				return e;
			}
		}

		return null;
	}

	public Entidade buscarId(Integer id) {
		for (Entidade e : gastosEvento) {
			if (e.getId().equals(id)) {
				return e;
			}
		}
		return null;
	}

}
