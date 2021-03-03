package es.ieslavereda.test;

import es.ieslavereda.chess.Coordenada;
import es.ieslavereda.chess.Pawn;
import es.ieslavereda.chess.Tablero;
import es.ieslavereda.chess.Tipo;
import es.ieslavereda.chess.Pieza;
import es.ieslavereda.chess.Color;

public class Test {

	public static void main(String[] args) {

		Coordenada c = new Coordenada('D', 1);

		Coordenada co = new Coordenada('D', 7);
		Tablero t = new Tablero();

		Color color;

		System.out.println(t.print(Color.WHITE));
		t.getCeldaAt(c).getPieza().moveTo(co);
		System.out.println(t.getCeldaAt(co).getPieza().getNextMovements());
		System.out.println(t.getBlancas());
		System.out.println(t.Check(Color.BLACK));
		System.out.println(t.print(Color.WHITE));
	}

}
