import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Manejo de Ficheros");
		System.out.println("Leo un archivo existenet");
		try {
			List<String> lineas = Files.readAllLines(Paths.get("c:\\temp\\ejemplo.txt"));
			lineas.forEach(System.out::println);
		}catch(Exception ex) {
			System.err.println("No se pudo leer el archivo");
			System.err.println(ex.getMessage());
		}
		
		System.out.println("Escribo un archivo");
		List<String> lineas = new ArrayList<String>();
		lineas.add("linea1");
		lineas.add("linea2");
		lineas.add("linea3");
		try {
			Files.write(Paths.get("C:\\temp\\ejemplo-out.txt"), lineas);
		} catch (IOException ex) {
			System.err.println("No se pudo grabar el archivo");
			System.err.println(ex.getMessage());
		}
		
		System.out.println("Listo los archivos de un directorio");
		try {
			Stream<Path> archivos = Files.list(Paths.get("C:\\temp\\"));
			archivos.forEach( (p)->{
				System.out.println(p.getFileName());
			});
			archivos.close();
		} catch (IOException ex) {
			System.out.println("No se pudo leer los archivos del directorio");
			System.out.println(ex.getMessage());
		}
		
	}

}
