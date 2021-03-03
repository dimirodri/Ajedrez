package es.ieslavereda.chess;

public class Bishop extends Pieza {

	public Bishop(Color color, Coordenada posicion, Tablero tablero) {
		super(posicion, tablero);
		if (color == Color.WHITE)
			tipo = tipo.WHITE_BISHOP;
		else
			tipo = tipo.BLACK_BISHOP;
	}

	@Override
	public Lista<Coordenada> getNextMovements() {

		return getNextMovements(tablero, this);
	}

	public static Lista<Coordenada> getNextMovements(Tablero t, Pieza p) {
		Lista<Coordenada> lista = new Lista<Coordenada>();
		Coordenada ur = p.posicion.diagonalUpRight();
		Coordenada ul = p.posicion.diagonalUpLeft();
		Coordenada dr = p.posicion.diagonalDownRight();
		Coordenada dl = p.posicion.diagonalDownLeft();

		while (t.coordenadaEnTablero(ur) && !t.getCeldaAt(ur).contienePieza()) {
			lista.addHead(ur);
			ur = ur.diagonalUpRight();
		}
		if (t.coordenadaEnTablero(ur) && t.getCeldaAt(ur).getPieza().getColor() != p.getColor()) {
			lista.addHead(ur);
		}
		while (t.coordenadaEnTablero(ul) && t.getCeldaAt(ul).contienePieza() == false) {
			lista.addHead(ul);
			ul = ul.diagonalUpLeft();
		}
		if (t.coordenadaEnTablero(ul) && t.getCeldaAt(ul).getPieza().getColor() != p.getColor()) {
			lista.addHead(ul);
		}

		while (t.coordenadaEnTablero(dr) && t.getCeldaAt(dr).contienePieza() == false) {
			lista.addHead(dr);
			dr = dr.diagonalDownRight();
		}
		if (t.coordenadaEnTablero(dr) && t.getCeldaAt(dr).getPieza().getColor() != p.getColor()) {
			lista.addHead(dr);
		}
		while (t.coordenadaEnTablero(dl) && t.getCeldaAt(dl).contienePieza() == false) {
			lista.addHead(dl);
			dl = dl.diagonalDownLeft();
		}
		if (t.coordenadaEnTablero(dl) && t.getCeldaAt(dl).getPieza().getColor() != p.getColor()) {
			lista.addHead(dl);
		}

		return lista;

	}

}
