package Relaciones;

import java.io.File;
import java.util.Scanner;
import java.util.List;
import graphsDSESIUCLM.*;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		// Lectura del fichero de los Personajes
		System.out.println("Introduzca la direccion del fichero con los personajes");
	    String ficherito = scanner.next();	
		List<String> personajes = CargaDatos.leerPersonajes(ficherito);
		
		// Lectura del fichero de las relaciones
		System.out.println("Introduzca la direccion del fichero con las relaciones");
	    String ficherito2 = scanner.next();
	    Graph<DecoratedElement<String>, AristaStarwars<Integer>> grafo = new TreeMapGraph<DecoratedElement<String>, AristaStarwars<Integer>>();
		
	    CargaDatos.leerAristas(ficherito2, grafo, personajes);
		
	    // Creacion del menu de opciones
		boolean parar = true;
        
    	while(parar){
			// Mostrar menú
			System.out.println("\nIndique el número de la consulta a realizar:\r\n"
					+ "1. Grafo, Nº Personajes, el mas implicado y el mas discreto\r\n"
					+ "2. Secuencia mas corta de personajes entre dos personajes\r\n"
					+ "3. Secuencia mas corta y discreta entre dos personajes\r\n"
					+ "4. Salir\r\n");
			
			int valor = scanner.nextInt();
			switch (valor) {
			case 1:
				// Mostrar estadísticas del grafo
				System.out.println("Número de personajes: " + grafo.getVertices());
				System.out.println("Número total de relaciones: " + grafo.getEdges());
				
				List<DecoratedElement<String>> lospersonajesMasImplicados = Grafo.personajesMasImplicados(grafo);
				List<DecoratedElement<String>> lospersonajesMasDiscretos = Grafo.personajesMasDiscretos(grafo);
				
				
				System.out.println("Personaje mas implicado: " + lospersonajesMasImplicados);
				System.out.println("Personaje mas discreto: " + lospersonajesMasDiscretos);
				break;
				
			case 2:
				// Mostrar secuencia mas corta
				System.out.println("Introduzca el primer personaje:"); 
				String personaje1 = scanner.next();

				System.out.println("Introduzca el segundo personaje:");
				String personaje2 = scanner.next();
				
				List<DecoratedElement<String>> secuenciaCorta = Grafo.secuenciaCortaEntrePersonajes(grafo, personaje1, personaje2);
				
				System.out.println("Secuencia mas corta entre " + personaje1 + " y " + personaje2 + "con un total de: " + secuenciaCorta);				
				break;
				
			case 3:
				// Mostrar secuencia mas corta y discreta
				System.out.println("Introduzca el primer personaje:");
				String persona1 = scanner.next();

				System.out.println("Introduzca el segundo personaje:");
				String persona2 = scanner.next();
				
				List<DecoratedElement<String>> secuenciaCortaDiscreta = Grafo.secuenciaCortaDiscretaEntrePersonajes(grafo, persona1, persona2);
				
				System.out.println("Secuencia mas corta entre " + persona1 + " y " + persona2 + "con un total de: " + secuenciaCortaDiscreta);
				break;
			case 4:
				// Salir de las opciones y terminamos el programa
				System.out.println("Gracias por usar esta aplicacion...");	
				parar=false;
				break;
				
			default:
				System.out.println("Opcion no valida");
			    break;
			}
    	}
		
	}
}
