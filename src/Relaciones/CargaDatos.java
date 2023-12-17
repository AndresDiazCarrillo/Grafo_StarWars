package Relaciones;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import graphsDSESIUCLM.*;

public class CargaDatos {
	
	public static List<String> leerPersonajes(String filename) {
		List<String> personajes = new ArrayList<>();
		
		try {
			Scanner file = new Scanner(new File(filename));
			while (file.hasNextLine()) {
				String personaje = file.nextLine();
				personajes.add(personaje);
			}
		} catch (FileNotFoundException e){
			System.out.println("File not found");
		}
		
		return personajes;
	}
	
	public static void leerAristas(String name, Graph<DecoratedElement<String>, AristaStarwars<Integer>> g, List<String> p) {
		String line, name1, name2;
		StringTokenizer token;
		int w, n = 0;
		DecoratedElement<String> p1, p2;
		AristaStarwars<Integer> eAristas;
		
		try {
			Scanner file = new Scanner(new File(name));
			while (file.hasNextLine()) {
				n++; // Contador de línea. Va a ser el ID de la Interaction
				line = file.nextLine();
				token = new StringTokenizer(line, ",");
				name1 = p.get(Integer.parseInt(token.nextToken())); 
				name2 = p.get(Integer.parseInt(token.nextToken())); 
				w = Integer.parseInt(token.nextToken());
				 
				p1 =new DecoratedElement<String>(name1);
				p2 =new DecoratedElement<String>(name2);
				eAristas = new AristaStarwars<Integer>(n, w);
				g.insertEdge(p1, p2, eAristas); // Insertando la arista
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
	}
	
}
