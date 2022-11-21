package persistencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import entidade.Entidade;
import entidade.Gasto;
import factory.AbstractFactory;
import visao.Menu;

public class GastoPersistencia extends Persistencia {
	static java.io.File diretorio = new java.io.File("C:\\Users\\prit_\\eclipse-workspace\\ProjetoEngDeSoftware");
	static java.io.File arquivo = new java.io.File(diretorio, "gastoPersistencia.txt");
	private static FileWriter texto = null;
	private static PrintWriter escritor = null;
	private static List<Entidade> gastos = new ArrayList<Entidade>();
	private static GastoPersistencia gastoPersistencia = null;
	private AbstractFactory fabrica;

	public GastoPersistencia() throws IOException {
		fabrica = AbstractFactory.getFactory("gasto");
	}

	public static GastoPersistencia instance() throws IOException {
		if (gastoPersistencia == null) {
			gastoPersistencia = new GastoPersistencia();
			leGasto();
		}
		return gastoPersistencia;
	}

	public static void leGasto() throws IOException {
		boolean existe = arquivo.exists();
		AbstractFactory fabrica = AbstractFactory.getFactory("gasto");
		List<String> nomes = new ArrayList<>();
		List<String> ids = new ArrayList<>();
		if (existe) {
			FileReader fr = new FileReader(arquivo);
			BufferedReader br = new BufferedReader(fr);
			while (br.ready()) {
				String linha = br.readLine();
				if (linha.contains("#")) {
					String array[] = linha.split("#");
					ids.add(array[1]);
				}
				if (linha.contains("%")) {
					String array[] = linha.split("%");
					nomes.add(array[1]);
				}
			}
			for (int i = 0; i < nomes.size(); i++) {
				Gasto gasto = (Gasto) fabrica.criarEntidade();
				gasto.setNome(nomes.get(i));
				gasto.setId(Integer.parseInt(ids.get(i)));
				gastos.add(gasto);
			}
			br.close();
			fr.close();
		}
	}

	public void inserir(Entidade entidade) throws IOException {

		Integer id;
		if (gastos.size() == 0)
			id = 0;
		else {
			id = gastos.size();
		}
		entidade.setId(id);
		gastos.add(entidade);
		escreverArquivo(entidade);
	}

	public static List<Entidade> getGastos() {
		return gastos;
	}

	public static void setGastos(List<Entidade> gastos) {
		GastoPersistencia.gastos = gastos;
	}

	public boolean alterar(Entidade entidade, String renome) throws IOException {
		for (Entidade e : gastos) {
			if (e.getNome().equals(entidade.getNome())) {
				e.setNome(renome);
				alterarArquivo();
				return true;
			}
		}
		return false;

	}

	public void alterarArquivo() throws IOException {
		arquivo.delete();
		for (Entidade e : gastos) {
			escreverArquivo(e);
		}

	}

	public void escreverArquivo(Entidade entidade) throws IOException {
		texto = new FileWriter(arquivo, true);
		escritor = new PrintWriter(texto);
		escritor.println("__________________Gasto___________________");
		escritor.println("Id: #" + entidade.getId() + "#.");
		escritor.println("Nome: %" + entidade.getNome() + "%.");
		escritor.flush();
		escritor.close();
	}

	public boolean excluir(Entidade entidade) throws IOException {
		boolean sucesso = false;
		for (Entidade e : gastos) {
			if (e.getNome().equals(entidade.getNome())) {
				gastos.remove(e);
				sucesso = true;
				break;
			}
		}
		Integer cont = 0;
		for (Entidade e : gastos) {
			e.setId(cont++);
		}
		alterarArquivo();
		return sucesso;
	}

	public Entidade buscarNome(String nome) {
		for (Entidade e : gastos) {
			if (e.getNome().equals(nome)) {
				return e;
			}
		}

		return null;
	}

	public Entidade buscarId(Integer id) {
		for (Entidade e : gastos) {
			if (e.getId().equals(id)) {
				return e;
			}
		}
		return null;
	}

}
