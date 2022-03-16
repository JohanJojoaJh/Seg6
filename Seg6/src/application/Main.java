package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import model.*;
import sun.font.CreatedFontTracker;
import list.*;

public class Main
{
	private Scanner lector;
	
	private VallaList vallas;
	private File file;

	public static void main(String[]args) throws IOException
	{		
		Main main = new Main();		
		main.menu();
	}
	
	public Main()
	{
		lector = new Scanner(System.in);
	}
	
	public void serialize() {
		File fileK = new File("Seg6\\src\\file\\Seg6Data.txt");
		try {
			FileOutputStream fos = new FileOutputStream(fileK);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(vallas);
			oos.close();
			fos.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deserialize() {
		File fileK = new File("Seg6\\src\\file\\Seg6Data.txt");
		try {
			FileInputStream fis = new FileInputStream(fileK);
			ObjectInputStream ois = new ObjectInputStream(fis);
			vallas = (VallaList) ois.readObject();
			ois.close();
			fis.close();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void menu() throws IOException
	{
		System.out.println("¿Qué desea hacer?");
		
		System.out.print("1. Importar datos CSV.\n2. Agregar valla publicitaria.");
		System.out.print("\n3. Mostrar vallas publicitarias.\n4. Exportar reporte de peligrosidad.\n0. Salir.");

		int answer = lector.nextInt();
		lector.nextLine();
		
		if(answer < 0 || answer > 4)
		{
			System.out.println("No es una opción.");
			menu();
		}
		else
		{
			switch(answer)
			{
				case 0:
					System.out.println("Adiós.");
					break;
				
				case 1:
					importarDatos();
					break;
				
				case 2:
					agregarValla();
					break;
				
				case 3:
					mostrarVallas();
					break;
				
				case 4:
					exportarPeligrosidad();
					break;
			}
		}
	}

	private void importarDatos() throws IOException
	{
		System.out.println("Ingrese la ruta completa de donde se encuentra el archivo a leer.");
		String path = lector.nextLine();
		lector.nextLine();
		
		file = new File(path);
		
		if(!(file.exists()))
		{
			System.out.println("No se encuentra el archivo.");
		}
		else
		{
			vallas = new VallaList(file);
		}
		menu();
	}
 //C:\\Users\\johan jojoa\\Downloads\\Datos1.csv
	private void agregarValla() throws IOException
	{
		System.out.println("Escriba los datos requeridos separados con ++:\n"
				+ "Altura(cm)++Ancho(cm)++¿Está en uso?(true/false)++Marca\r\n" + 
				"");
		
		String respuesta = lector.nextLine();
		lector.nextLine();
		
		String[] datos = respuesta.split("\\+\\+");
		
		int altura = Integer.parseInt(datos[0]);
		int ancho = Integer.parseInt(datos[1]);
		boolean enUso = Boolean.parseBoolean(datos[2]);
		String marca = datos[3];
		
		vallas.addValla(altura, ancho, enUso, marca);	
		
		menu();
	}

	private void mostrarVallas() throws IOException
	{
		System.out.println("W     H     inUse  Brand.");
		
		try
		{
			int total = vallas.printVallas();
			System.out.println("Total: "+total);
		}
		catch(NullPointerException e)
		{
			System.out.println("No hay datos registrados.");
		}
		menu();
	}

	private void exportarPeligrosidad() throws IOException
	{
		File fileK = new File("C:\\Users\\johan jojoa\\Downloads\\Peligrosidad.txt");
		fileK.createNewFile();
		PrintWriter peligro = new PrintWriter(file);
	}
}
