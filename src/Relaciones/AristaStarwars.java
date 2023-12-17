package Relaciones;

import graphsDSESIUCLM.*;

/**
 * Representa una arista de Star Wars.
 * @author andre
 *
 * @param <E> Tipo del peso de la arista.
 */
public class AristaStarwars <E> implements Element {
	
	private Integer nLine;
	private E weight;
	
	public AristaStarwars(Integer n, E w){
		this.nLine = n;
		this.weight = w;
	}
	
	public String getID() {
		return nLine.toString();
	}
	
	/**
	 * Obtiene el peso de la arista.
	 * 
	 * @return Peso de la arista.
	 */
	public E getElement() {
		return weight;
	}
}

