package Relaciones;

/**
 * Representa un elemento decorado en un grafo
 * @author 
 *
 * @param <T> Tipo del elemento.
 */
public class DecoratedElement<T> {
	
	//Atributos
	private T element; 
	private DecoratedElement<T> parent;
	private boolean visited;
	
	//Constructor
	public DecoratedElement(T element) {
		this.element = element;
		this.visited = false;
		this.parent = null;
	}
	
	//Metodos getter y setter
	public boolean getVisited() {
		return visited;
	}
	
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	public DecoratedElement<T> getParent() {
		return parent;
	}
	
	public void setParent(DecoratedElement<T> parent) {
		this.parent = parent;
	}
	
	/**
	 * Obtiene el elemento contenido en este DecoratedElement.
	 * 
	 * @return El elemento contenido
	 */
	public T getElement() {
		return element;
	}

}
