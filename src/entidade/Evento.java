package entidade;

import java.util.ArrayList;
import java.util.List;

public class Evento extends Entidade{
	private List <GastoEvento> gastosEvento= new ArrayList <GastoEvento>(); 

	public String toString() {
		String s0="";
		for(GastoEvento g: gastosEvento) {
			s0+=g.toString();
		}
		String s = "\nId do evento: "+ this.getId() + "\n Nome do evento: "+ this.getNome()+"\n"+
		"Total do evento: " + calcularTotal() + "\n      GASTOS      \n "+ s0;
		return s;
	}
	public void addGastoEvento(GastoEvento gastoEvento) {
		gastosEvento.add(gastoEvento);
	}
	public List <GastoEvento> getGastosEvento() {
		return gastosEvento;
	}

	public void setGastosEvento(List <GastoEvento> gastosEvento) {
		this.gastosEvento = gastosEvento;
	}
	public float calcularTotal() {
		float total = 0;
		for (GastoEvento g: gastosEvento) {			
			float parcial = g.getPreco()*g.getQuantidade();
			total = total+ parcial;
		}
		return total;
		
	}
	//float t = calcularTotal();
}
