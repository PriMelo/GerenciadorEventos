package entidade;

public class Gasto extends Entidade {

	public String toString() {
		String s = "\nId do gasto: "+ this.getId() + "\nNome do gasto: "+ this.getNome();
		return s;
	}

}
