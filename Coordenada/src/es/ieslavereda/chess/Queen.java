package es.ieslavereda.chess;

public class Queen extends Pieza {

	public Queen(Color color, Coordenada posicion, Tablero tablero) {
		super(posicion, tablero);
		if (color == color.WHITE)
			tipo = tipo.WHITE_QUEEN;
		else
			tipo = tipo.BLACK_QUEEN;
	}

	@Override
	public Lista<Coordenada> getNextMovements() {

		return Rook.getNextMovements(tablero, this).addAll(Bishop.getNextMovements(tablero, this));
	}

}
