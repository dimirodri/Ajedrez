package es.ieslavereda.chess;

public class Pawn extends Pieza {

	public Pawn(Color color, Coordenada posicion, Tablero tablero) {
		super(posicion, tablero);
		if (color == Color.WHITE)
			tipo = tipo.WHITE_PAWN;
		else
			tipo = tipo.BLACK_PAWN;
	}

	@Override
	public Lista<Coordenada> getNextMovements() {
		Lista<Coordenada> lista = new Lista<Coordenada>();
		if (getColor() == Color.WHITE) {
			if (!tablero.getCeldaAt(posicion.up()).contienePieza()) {
				lista.addHead(posicion.up());
				if (!tablero.getCeldaAt(posicion.up().up()).contienePieza())
					lista.addHead(posicion.up().up());
			}
			if (tablero.coordenadaEnTablero(posicion.diagonalUpLeft())
					&& tablero.getCeldaAt(posicion.diagonalUpLeft()).contienePieza()
					&& tablero.getCeldaAt(posicion.diagonalUpLeft()).getPieza().getColor() != this.getColor())
				lista.addHead(posicion.diagonalUpLeft());
			if (tablero.coordenadaEnTablero(posicion.diagonalUpRight())
					&& tablero.getCeldaAt(posicion.diagonalUpRight()).contienePieza()
					&& tablero.getCeldaAt(posicion.diagonalUpRight()).getPieza().getColor() != this.getColor())
				lista.addHead(posicion.diagonalUpRight());
		}
		if (getColor() == Color.BLACK) {
			if (!tablero.getCeldaAt(posicion.down()).contienePieza()) {
				lista.addHead(posicion.down());
				if (!tablero.getCeldaAt(posicion.down().down()).contienePieza())
					lista.addHead(posicion.down().down());
			}
			if (tablero.getCeldaAt(posicion.diagonalDownLeft()).contienePieza()
					&& tablero.getCeldaAt(posicion.diagonalDownLeft()).getPieza().getColor() != this.getColor())
				lista.addHead(posicion.diagonalDownLeft());
			if (tablero.getCeldaAt(posicion.diagonalDownRight()).contienePieza()
					&& tablero.getCeldaAt(posicion.diagonalDownRight()).getPieza().getColor() != this.getColor())
				lista.addHead(posicion.diagonalDownRight());
		}
		return lista;
	}

	private boolean moved() {
		if (this.getColor() == Color.WHITE) {
			if (posicion.getRow() != 2) {
				return true;
			}
		}
		if (this.getColor() == Color.BLACK) {
			if (posicion.getRow() != 7) {
				return true;
			}
		}
		return false;
	}

	public void moveTo(Coordenada c) {
		super.moveTo(c);

		if (getColor() == Color.WHITE && posicion.getRow() == 8) {
			tablero.eliminarPieza(this);
			tablero.getBlancas().addHead(new Queen(Color.WHITE, c, tablero));
		} else if (getColor() == Color.BLACK && posicion.getRow() == 8) {

		}

	}

}
