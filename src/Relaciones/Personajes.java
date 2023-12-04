package Relaciones;

import java.io.File;
import java.util.Scanner;

public class Personajes {
	
	public static void main(String[] args) {
	
	File fichero = new File("C:\\Users\\andre\\OneDrive\\Escritorio\\PrimerCuatriTercerAño\\EDA\\Laboratorio\\starwars-full-interactions-allCharacters_aristas.csv");
	Scanner s = null;

	try {
		// Leemos el contenido del fichero
		System.out.println("... Leemos el contenido del fichero ...");
		s = new Scanner(fichero);

		// Leemos linea a linea el fichero
		while (s.hasNextLine()) {
			String linea = s.nextLine(); 	// Guardamos la linea en un String
			System.out.println(linea);      // Imprimimos la linea
		}

	} catch (Exception ex) {
		System.out.println("Mensaje: " + ex.getMessage());
	} finally {
		// Cerramos el fichero tanto si la lectura ha sido correcta o no
		try {
			if (s != null)
				s.close();
		} catch (Exception ex2) {
			System.out.println("Mensaje 2: " + ex2.getMessage());
		}
	}
	}
}
