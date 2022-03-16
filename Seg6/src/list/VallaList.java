package list;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

import model.Valla;

public class VallaList implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Valla> vallas;
	
	public VallaList(File file)
	{
		vallas = new ArrayList<Valla>();
		loadVallas(file);
	}
	
	public void loadVallas(File file){
		try
		{			
			FileReader fr = new FileReader(file);
			
			BufferedReader input = new BufferedReader(fr);
			
			input.readLine();
			
			while (input.ready())
			{
				String [] valla = input.readLine().split("\\|");
				
				int altura = Integer.parseInt(valla[0]);
				int ancho = Integer.parseInt(valla[1]);
				boolean enUso = Boolean.parseBoolean(valla[2]);
				String marca = valla[3];
				
				vallas.add(new Valla(altura, ancho, enUso, marca));
			}
			
			input.close();
			fr.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void addValla(int altura, int ancho, boolean enUso, String marca)
	{
		vallas.add(new Valla(altura, ancho, enUso, marca));
	}
	
	public int printVallas()
	{
		for(int i = 0; i < vallas.size(); i++)
		{
			System.out.println(vallas.get(i).getAltura()+"   "+vallas.get(i).getAncho()+"   "+
						vallas.get(i).isEnUso()+"   "+vallas.get(i).getMarca());
		}
		
		return vallas.size();
	}
	
	public ArrayList<Valla> getValla()
	{
		return vallas; 
	}
}
