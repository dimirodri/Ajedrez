package es.ieslavereda.chess;
import java.util.Scanner;

public class Game {
	private Jugador j1;
	private Jugador j2;
	private Tablero t;
	private Lista<Pieza> blancas;
	private Lista<Pieza> negras;
	private Lista<Pieza> comidas;
	Color turno;
	
	public Game(Jugador j1, Jugador j2, Tablero t) {
		this.j1=j1;
		this.j2=j2;
		this.t=t;
		blancas = new Lista<>();
		negras = new Lista<>();
		comidas = new Lista<>();
		turno=Color.WHITE;
	}
	public Jugador getBlancas() {
		return j1;
	}

	public Jugador getNegras() {
		return j2;
	}
	public void setBlancas(Jugador j1) {
		this.j1 = j1;
	}

	public void setNegras(Jugador j2) {
		this.j2 = j2;
	}
	public void start() {
		do {
			switch(turno) {
			case WHITE:
				moverPieza(j1);
				break;
			case BLACK:
				moverPieza(j2);
			}
			turno = Color.values()[(turno.ordinal() + 1) % Color.values().length];
			
		}while(t.blackKingIsAlive() && t.whiteKingIsAlive());
		
		if(t.blackKingIsAlive()) {
			System.out.println("Felicidades " + j2.getNombre() + "!!! has ganado.");
		}else {
			System.out.println("Felicidades " + j1.getNombre() + "!!! has ganado.");
		}
	}
	private void moverPieza(Jugador jugador) {
		Coordenada c;
		Pieza pieza = null ;

		do {
			c =Entrada.getCoordenada(" Que ficha quieres mover [A0]");
			if(!t.getCeldaAt(c).contienePieza()) {
				!t.getPiezaAt(c).getNextMovements().isEmpty()) 
			}else if(t.getPiezaAt(c).getColor()==color)
				aux=c;
				aceptado=true;
			}
		}while(pieza==null);
			
		do {
			
		}while();
		
	}
	

}
