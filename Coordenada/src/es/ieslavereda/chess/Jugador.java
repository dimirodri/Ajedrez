package es.ieslavereda.chess;

public class Jugador {

	String nombre;
	Color color;
	
	public Jugador(String nombre, Color color) {
		this.nombre=nombre;
		this.color=color;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	public Color getColor() {
		return color;
	}
	public String toString() {
		return "Nombre: " + nombre + ", Color: " + color;
	}
}
