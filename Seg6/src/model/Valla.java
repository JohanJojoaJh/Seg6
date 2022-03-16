package model;

import java.io.Serializable;

public class Valla implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private int altura;
	private int ancho;
	private boolean enUso;
	private String marca;
	
	public Valla(int altura, int ancho, boolean enUso, String marca)
	{
		this.altura = altura;
		this.ancho = ancho;
		this.enUso = enUso;
		this.marca = marca;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public boolean isEnUso() {
		return enUso;
	}

	public void setEnUso(boolean enUso) {
		this.enUso = enUso;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
}
