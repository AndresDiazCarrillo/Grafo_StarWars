package Relaciones;

import java.util.ArrayList;
import java.util.*;
import java.util.List;

import graphsDSESIUCLM.*;

public class Grafo {

	private static List<DecoratedElement<String>> personajeMasImplicado(Graph<DecoratedElement<String>, AristaStarwars<Integer>> grafo) {
		List<DecoratedElement<String>> masImplicados = new ArrayList<>();
		int maxRelaciones = -1;
		
		for (DecoratedElement<String> personaje : grafo.getVertices()) {
			int numRelaciones = grafo.getOutDegree(personaje);
			
			if (numRelaciones > maxRelaciones) {
				maxRelaciones = numRelaciones;
				masImplicados.clear();
				masImplicados.add(personaje);
			} else if (numRelaciones == maxRelaciones) {
				masImplicados.add(personaje);
			}
		}
		return masImplicados;
	}
	
	private static List<DecoratedElement<String>> personajeMasDiscreto(Graph<DecoratedElement<String>, AristaStarwars<Integer>> grafo) {
		List<DecoratedElement<String>> masDiscretos = new ArrayList<>();
		int minRelaciones = Integer.MAX_VALUE;
		
		for (DecoratedElement<String> personaje : grafo.getVertices()) {
			int numRelaciones = grafo.getOutDegree(personaje);
			
			if (numRelaciones > minRelaciones) {
				minRelaciones = numRelaciones;
				masDiscretos.clear();
				masDiscretos.add(personaje);
			} else if (numRelaciones == minRelaciones) {
				masDiscretos.add(personaje);
			}
		}
		
		return masDiscretos;
	}
	
	private static List<DecoratedElement<String>> secuenciaCortaEntrePersonajes(Graph<DecoratedElement<String>, AristaStarwars<Integer>> grafo, String personaje1, String personaje2) {
		DecoratedElement<String> inicioElement = buscarElementoPorNombre(grafo, personaje1);
		DecoratedElement<String> finElement = buscarElementoPorNombre(grafo, personaje2);
		
		if (inicioElement == null || finElement == null) {
			System.out.println("Uno o ambos personajes no existen en el grafo");
			return new ArrayList<>();
		}
		
		Map<DecoratedElement<String>, DecoratedElement<String>> padres = new HashMap<>();
		Queue<DecoratedElement<String>> cola = new LinkedList<>();
		
		padres.put(inicioElement, null);
		cola.add(inicioElement);
		
		while (!cola.isEmpty()) {
			DecoratedElement<String> actual = cola.poll();
			
			if (actual.equals(finElement)) {
				break;
			}
			
			for (DecoratedElement<String> vecino : grafo.getVecino(actual)) {
				if (!padres.containsKey(vecino)) {
					padres.put(vecino, actual);
					cola.add(vecino);
				}
			}
			
		}
		
		return reconstruirCamino(padres, inicioElement, finElement);
	}
	
	private static List<DecoratedElement<String>> reconstruirCamino(Map<DecoratedElement<String>, DecoratedElement<String>> padres, DecoratedElement<String> inicio, DecoratedElement<String> fin) {
		List<DecoratedElement<String>> camino = new ArrayList<>();
		DecoratedElement<String> actual = fin;
		
		while (actual != null) {
			camino.add(actual);
			actual = padres.get(actual);
		}
		
		Collections.reverse(camino);
		return camino;
	}
	
	private static DecoratedElement<String> buscarElementoPorNombre(Graph<DecoratedElement<String>, AristaStarwars<Integer>> grafo, String nombre) {
		for (DecoratedElement<String> elemento : grafo.getVertices()) {
			if (elemento.getElement().equals(nombre)) {
				return elemento;
			}
		}
		return null;
	}
	
	private static List<DecoratedElement<String>> secuenciaCortaDiscretaEntrePersonajes(Graph<DecoratedElement<String>, AristaStarwars<Integer>> grafo, String persona1, String persona2) {
		DecoratedElement<String> inicioElement = buscarElementoPorNombre(grafo, persona1);
		DecoratedElement<String> finElement = buscarElementoPorNombre(grafo, persona2);
		
		if (inicioElement == null || finElement == null) {
			System.out.println("Uno o ambos personajes no existen en el grafo");
			return new ArrayList<>();
		}
		
		Map<DecoratedElement<String>, DecoratedElement<String>> padres = new HashMap<>();
		Set<DecoratedElement<String>> visitados = new HashSet<>();
		
		padres.put(inicioElement, null);
		visitados.add(inicioElement);
		
		realizarDFS(grafo, inicioElement, finElement, padres, visitados);
		
		return reconstruirCamino(padres, inicioElement, finElement);
	}
	
	private static void realizarDFS(Graph<DecoratedElement<String>, AristaStarwars<Integer>> grafo, DecoratedElement<String> actual, DecoratedElement<String> fin, Map<DecoratedElement<String>, DecoratedElement<String>> padres, Set<DecoratedElement<String>> visitados) {
		if (actual.equals(fin)) {
			return;
		}
		
		for (DecoratedElement<String> vecino : grafo.getVecino(actual)) {
			if (!padres.containsKey(vecino)) {
				padres.put(vecino, actual);
				visitados.add(vecino);
				realizarDFS(grafo, vecino, fin, padres, visitados);
			}
		}
	}
	
}
