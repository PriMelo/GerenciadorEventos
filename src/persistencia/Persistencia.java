package persistencia;

import java.io.IOException;

import entidade.Entidade;

public abstract class Persistencia {
	
	
	public abstract void inserir(Entidade entidade) throws IOException;
	public abstract boolean alterar(Entidade entidade, String renome) throws IOException;
	public abstract void alterarArquivo() throws IOException ;
	public abstract void escreverArquivo(Entidade entidade) throws IOException;
	public abstract boolean excluir(Entidade entidade) throws IOException;
	public abstract Entidade buscarNome(String nome);
	public abstract Entidade buscarId(Integer nome);
}