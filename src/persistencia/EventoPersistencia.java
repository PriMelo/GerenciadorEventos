package persistencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import entidade.Entidade;
import entidade.Evento;
import entidade.Gasto;
import entidade.GastoEvento;
import factory.AbstractFactory;

public class EventoPersistencia extends Persistencia {
	static java.io.File diretorio1 = new java.io.File("C:\\Users\\prit_\\eclipse-workspace\\ProjetoEngDeSoftware");
	
	static java.io.File arquivo1 = new java.io.File(diretorio1, "eventoPersistencia.txt");
	private static FileWriter texto1 = null;
	private static PrintWriter escritor1 = null;
	private static List<Entidade> eventos = new ArrayList<Entidade>();
	private static EventoPersistencia eventoPersistencia = null;
	private AbstractFactory fabrica;

	public EventoPersistencia() throws IOException {
		fabrica = AbstractFactory.getFactory("evento");
		
	}

	public static EventoPersistencia instance() throws IOException {
		if (eventoPersistencia == null) {
			eventoPersistencia = new EventoPersistencia();			
			leEvento();			
			
		}
		return eventoPersistencia;
	}

	public static void setEventos(List<Entidade> eventos) {
		EventoPersistencia.eventos = eventos;
	}

	public static void leEvento() throws IOException {
		boolean existe = arquivo1.exists();
		AbstractFactory fabricaEvento = AbstractFactory.getFactory("evento");
		AbstractFactory fabricaGasto = AbstractFactory.getFactory("gasto");
		AbstractFactory fabricaGastoEvento = AbstractFactory.getFactory("gasto evento");


		if (existe) {
			FileReader fr = new FileReader(arquivo1);
			BufferedReader br = new BufferedReader(fr);
			while (br.ready()) {
                Evento evento = (Evento) fabricaEvento.criarEntidade();
                Gasto gasto = (Gasto) fabricaGasto.criarEntidade();
                GastoEvento gastoEvento = (GastoEvento) fabricaGastoEvento.criarEntidade();
                
                String linha = br.readLine();
                if (linha.contains("#")) {
                    String array[] = linha.split("#");
                   
                    evento.setId(Integer.parseInt(array[1]));
                    eventos.add(evento);
                }
                if (linha.contains("%")) {
                    String array[] = linha.split("%");
                    
                    int size = eventos.size();
                    evento = (Evento) eventos.get(size - 1);
                    evento.setNome(array[1]);

                }
                if (linha.contains("ç")) {
                    String array[] = linha.split("ç");
                  
                    int size = eventos.size();
                    evento = (Evento) eventos.get(size - 1);
                    gasto.setId(Integer.parseInt(array[1]));
                    gastoEvento.setGasto(gasto);
                    evento.addGastoEvento(gastoEvento);
                }
				
                if (linha.contains("@")) {
                    String array[] = linha.split("@");
                   
                    int size = eventos.size();
                    evento = (Evento) eventos.get(size - 1);
                    size = evento.getGastosEvento().size();
                    gastoEvento = evento.getGastosEvento().get(size - 1);
                    gastoEvento.getGasto().setNome(array[1]);
                }
                if (linha.contains("&")) {
                    String array[] = linha.split("&");
                   
                    int size = eventos.size();
                    evento = (Evento) eventos.get(size - 1);
                    size = evento.getGastosEvento().size();
                    gastoEvento = evento.getGastosEvento().get(size - 1);
                    gastoEvento.setPreco(Float.parseFloat(array[1]));
                }
                if (linha.contains(";")) {
                    String array[] = linha.split(";");
                   
                    int size = eventos.size();
                    evento = (Evento) eventos.get(size - 1);
                    size = evento.getGastosEvento().size();
                    gastoEvento = evento.getGastosEvento().get(size - 1);
                    gastoEvento.setQuantidade(Integer.parseInt(array[1]));

                }

            }

			
			br.close();
			fr.close();
		}
	}

	public void inserir(Entidade entidade) throws IOException {

		Integer id;
		if (eventos.size() == 0)
			id = 0;
		else {
			id = eventos.size();
		}
		entidade.setId(id);
		eventos.add(entidade);
		escreverArquivo(entidade);
	}

	public static List<Entidade> getEventos() {
		return eventos;
	}

	public boolean alterar(Entidade entidade, String renome) throws IOException {

		for (Entidade e : eventos) {
			if (e.getNome().equals(entidade.getNome())) {
				e.setNome(renome);
				alterarArquivo();
				return true;
			}
		}
		return false;
	}
	
	public void alterarArquivo() throws IOException {
		arquivo1.delete();
		for (Entidade e : eventos)
			escreverArquivo(e);

	}

	public void escreverArquivo(Entidade entidade) throws IOException {
		texto1 = new FileWriter(arquivo1, true);
		escritor1 = new PrintWriter(texto1);
		escritor1.println("__________________Evento___________________");
		escritor1.println("Id: #" + entidade.getId() + "#.");
		escritor1.println("nome: %" + entidade.getNome() + "%.\n");
		
		
		Evento e = (Evento) entidade;
		escritor1.println("--------------Gastos------------");
		for (GastoEvento g : e.getGastosEvento()) {
			escritor1.println("Id do gasto: ç" + g.getGasto().getId() + "ç.");
			escritor1.println("Nome do gasto: @" + g.getGasto().getNome() + "@.");
			escritor1.println("Preco unitario do gasto: &" + g.getPreco() + "&.");
			escritor1.println("Quantidade de itens: ;" + g.getQuantidade() + ";.\n");
		}
		escritor1.println("Total do Evento: " + e.calcularTotal());
		escritor1.flush();
		escritor1.close();
	}

	public boolean excluir(Entidade entidade) throws IOException {
		boolean sucesso = false;
		for (Entidade e : eventos) {
			if (e.getNome().equals(entidade.getNome())) {
				eventos.remove(e);
				sucesso = true;
				break;
			}
		}
		Integer cont = 0;
		for (Entidade e : eventos) {
			e.setId(cont++);
		}
		alterarArquivo();
		return sucesso;
	}

	public Entidade buscarNome(String nome) {
		for (Entidade e : eventos) {
			if (e.getNome().equals(nome)) {
				return e;
			}
		}

		return null;
	}

	public Entidade buscarId(Integer id) {
		for (Entidade e : eventos) {
			if (e.getId().equals(id)) {
				return e;
			}
		}
		return null;
	}

}
