package com.hibernate.app;

import java.util.List;
import java.util.Scanner;

import com.hibernate.dao.CiudadDAO;
import com.hibernate.model.Ciudad;

public class App {

static void menu() {
	System.out.println("Insertar nueva ciudad (1)");
	System.out.println("Borrar una ciudad dado su código (2)");
	System.out.println("Actualizar nombre de ciudad dado su código (3)");
	System.out.println("Actualizar habitantes de ciudad dado su código (4)");
	System.out.println("Ver todas las ciudades (5)");
	System.out.println("Ver los datos de una ciudad dado su codigo (6)");
	System.out.println("Salir (7)");
	System.out.println();
}

	public static void main(String[] args) {
	Scanner entrada=new Scanner(System.in);
	
	int opcion;
	
	int codigo;
	String nombre;
	int numeroHabitantes;
	
	CiudadDAO ciudadDAO=new CiudadDAO();
	Ciudad ciudad=new Ciudad();
	
	do {
		App.menu();
		
		System.out.print("Selecciona una opción del menú: ");
		opcion=entrada.nextInt();
		
		switch (opcion) {
		case 1:
			System.out.print("Introduce un nombre: ");
			nombre=entrada.next();
			System.out.print("Introduce un número de habitantes: ");
			numeroHabitantes=entrada.nextInt();
			
			ciudad=new Ciudad(nombre, numeroHabitantes);
			ciudadDAO.insertCiudad(ciudad);
			
			break;
		case 2:
			System.out.print("¿Qué ciudad quieres eliminar? Introduce su código: ");
			codigo=entrada.nextInt();
			
			ciudadDAO.deleteCiudad(codigo);
			
			break;
		case 3:
			System.out.print("¿A qué ciudad quieres cambiarle el nombre? Introduce su código: ");
			codigo=entrada.nextInt();
			
			System.out.print("Introduce un nombre: ");
			nombre=entrada.next();
			ciudad.setNombre(nombre);
			
			ciudadDAO.updateCiudad(ciudad, codigo);
			
			break;
		case 4:
			System.out.print("¿A qué ciudad quieres cambiarle el número de habitantes? Introduce su código: ");
			codigo=entrada.nextInt();
			
			System.out.print("Introduce un número de habitantes: ");
			numeroHabitantes=entrada.nextInt();
			ciudad.setNumeroHabitantes(numeroHabitantes);
			
			ciudadDAO.updateCiudad(ciudad, codigo);
			
			break;
		case 5:
			List<Ciudad> ciudades=ciudadDAO.selectAllCiudades();
			
			for (Ciudad c : ciudades) {
				System.out.println("Código: "+c.getCodigo()+" | Nombre: "+c.getNombre()+" "
								 + "| Número de habitantes: "+c.getNumeroHabitantes());
			}
			
			//ciudades.forEach(p->System.out.println("Código: "+c.getCodigo()+" | Nombre: "+c.getNombre()+" "
			//												+ "| Número de habitantes: "+c.getNumeroHabitantes()));
			
			break;
		case 6:
			System.out.print("¿De qué ciudad quieres ver sus datos? Introduce su código: ");
			codigo=entrada.nextInt();
			
			ciudad=ciudadDAO.selectCiudadById(codigo);
			System.out.println("Código: "+ciudad.getCodigo()+" | Nombre: "+ciudad.getNombre()+" "
							 + "| Número de habitantes: "+ciudad.getNumeroHabitantes());
			
			break;
		case 7:
			System.out.println("Has salido");
			break;
		default:
			System.out.print("Opción no válida. Por favor, selecciona una opción del menú: ");
			opcion=entrada.nextInt();
		}
	} while (opcion!=7);
	}
}