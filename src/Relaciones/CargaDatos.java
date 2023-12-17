package Relaciones;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import graphsDSESIUCLM.*;

/**
 * Carga los ficheros de los personajes y las relaciones
 * 
 * @author andre
 *
 */
public class CargaDatos {
	
	/**
	 * 
	 * @param filename
	 * @return Devuelve la lista de personajes desde el archivo 
	 */
	public static List<DecoratedElement<String>> leerPersonajes(String filename, Graph<DecoratedElement<String>, AristaStarwars<Integer>> g) {
		List<DecoratedElement<String>> personajes = new ArrayList<>(); //Creamos una lista va a contener los nombres de los personajes leidos del archivo
		String line, name;
		StringTokenizer token;
		int totalRelaciones;
		DecoratedElement<String> personaje;
		
		try {
			Scanner file = new Scanner(new File(filename)); //Leemos el archivo pasado
			while (file.hasNextLine()) { //Aqui recorremos el archivo linea por linea
				line = file.nextLine(); //Lee la siguiente linea y la almacena en una variable
				token = new StringTokenizer(line, ",");
				name = token.nextToken();
				totalRelaciones = Integer.parseInt(token.nextToken());
				
				personaje = new DecoratedElement<>(name);
				personaje.set
				g.insertVertex(personaje);
			}
		} catch (FileNotFoundException e){
			System.out.println("File not found");
		}
		return personajes; //Devuelve la lsita de personajes 
	}
	
	/**
	 * Lee las aristas de un archivo y las aguega a un grafo.
	 * 
	 * @param name Nombre del archivo que contiene las aristas.
	 * @param g Grafo donde se agregarán las aristas.
	 * @param p Lista de nombres de personajes utilizados para crear el grafo
	 */
	public static void leerAristas(String name, Graph<DecoratedElement<String>, AristaStarwars<Integer>> g, List<String> p) {
		String line, name1, name2;
		StringTokenizer token;
		int w, n = 0;
		DecoratedElement<String> p1, p2; //Se declaran dos variables que representan los dos vertices
		AristaStarwars<Integer> eAristas; //Se declara una variable que representa la arista
		
		try {
			Scanner file = new Scanner(new File(name)); //Leemos el archivo pasado
			while (file.hasNextLine()) { //Aqui recorremos el archivo linea por linea
				n++; // Contador de línea. Va a ser el ID de la Interaction
				line = file.nextLine(); //Lee la siguiente linea y la almacena en una variable
				token = new StringTokenizer(line, ","); //Utilizamos la linea y el delimitador
			 	name1 = p.get(Integer.parseInt(token.nextToken())); // Obtenemos el primer nombre del personaje de la linea
				name2 = p.get(Integer.parseInt(token.nextToken())); // Obtenemos el segundo nombre del personaje de la linea
				w = Integer.parseInt(token.nextToken()); // Obtenemos el peso de la arista
				 
				p1 = new DecoratedElement<String>(name1); // Creamos un nuevo objeto para el primer personaje
				p2 = new DecoratedElement<String>(name2); // Creamos un nuevo objeto para el segundo personaje
				eAristas = new AristaStarwars<Integer>(n, w); // Creamos un nuevo objeto con el ID y su peso
				g.insertEdge(p1, p2, eAristas); // Insertando la arista en el grafo
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
	}
	
}
