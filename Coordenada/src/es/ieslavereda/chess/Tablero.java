package es.ieslavereda.chess;

import es.ieslavereda.chess.Tipo;

public class Tablero {

	private Celda[][] tablero;
	private Lista<Pieza> blancas;
	private Lista<Pieza> negras;
	private Lista<Pieza> blancasEliminadas;
	private Lista<Pieza> negrasEliminadas;
	private Pieza blackking;
	private Pieza whiteking;

	public Tablero() {
		tablero = new Celda[8][8];
		blancas = new Lista<>();
		blancasEliminadas = new Lista<>();
		negras = new Lista<>();
		negrasEliminadas = new Lista<>();

		inicializar();
	}

	private void inicializar() {

		// Inicializamos el tablero
		for (int fila = 0; fila < tablero.length; fila++)
			for (int col = 0; col < tablero[0].length; col++)
				tablero[fila][col] = new Celda();

		// Poner fichas negras
		blackking = new King(Color.BLACK, new Coordenada('E', 8), this);
		negras.addHead(blackking);

		negras.addHead(new Rook(Color.BLACK, new Coordenada('A', 8), this));
		negras.addHead(new Knight(Color.BLACK, new Coordenada('B', 8), this));
		negras.addHead(new Bishop(Color.BLACK, new Coordenada('C', 8), this));
		negras.addHead(new Queen(Color.BLACK, new Coordenada('D', 8), this));
		negras.addHead(new Bishop(Color.BLACK, new Coordenada('F', 8), this));
		negras.addHead(new Knight(Color.BLACK, new Coordenada('G', 8), this));
		negras.addHead(new Rook(Color.BLACK, new Coordenada('H', 8), this));

//		for(int i = 0; i<=tablero.length-1;i++) {
//			negras.addHead(new Pawn(Color.BLACK,new Coordenada((char)('A' + i) ,7),this));
//		}

		// Poner fichas blancas
		whiteking = new King(Color.WHITE, new Coordenada('E', 1), this);
		blancas.addHead(whiteking);

		blancas.addHead(new Rook(Color.WHITE, new Coordenada('A', 1), this));
		blancas.addHead(new Knight(Color.WHITE, new Coordenada('B', 1), this));
		blancas.addHead(new Bishop(Color.WHITE, new Coordenada('C', 1), this));
		blancas.addHead(new Queen(Color.WHITE, new Coordenada('D', 1), this));
		blancas.addHead(new Bishop(Color.WHITE, new Coordenada('F', 1), this));
		blancas.addHead(new Knight(Color.WHITE, new Coordenada('G', 1), this));
		blancas.addHead(new Rook(Color.WHITE, new Coordenada('H', 1), this));

		for (int i = 0; i <= tablero.length - 1; i++) {
			blancas.addHead(new Pawn(Color.WHITE, new Coordenada((char) ('A' + i), 2), this));
		}
	}

	public String print(Color color) {

		switch (color) {
		case WHITE:
			return tableroBlancas();

		case BLACK:
			return tableroNegras();

		default:
			return "Introduce un color correcto";
		}
	}

	private String tableroNegras() {
		String salida = "           H   G   F   E   D   C   B   A\n";

		salida += obtenerParteSuperior();

		for (int fila = tablero.length - 1; fila > 0; fila--) {
			salida += obtenerParteFichaNegra(fila);
			salida += obtenerParteDivisoria();
		}
		salida += obtenerParteFichaNegra(0);
		salida += obtenerParteInferior() + "\n";
		salida += "           H   G   F   E   D   C   B   A\n";

		return salida;
	}

	private String tableroBlancas() {
		String salida = "           A   B   C   D   E   F   G   H\n";

		salida += obtenerParteSuperior();

		for (int fila = 0; fila < tablero.length - 1; fila++) {
			salida += obtenerParteFichaBlanca(fila);
			salida += obtenerParteDivisoria();
		}
		salida += obtenerParteFichaBlanca(tablero.length - 1);
		salida += obtenerParteInferior() + "\n";
		salida += "           A   B   C   D   E   F   G   H\n";

		return salida;
	}

	private String obtenerParteSuperior() {

		return "         ╔═══╤═══╤═══╤═══╤═══╤═══╤═══╤═══╗\n";
	}

	private String obtenerParteFichaNegra(int fila) {
		// String I = "\u2502";
		String salida = "       " + (8 - fila) + " ║";

		for (int col = tablero[0].length - 1; col > 0; col--) {
			salida = salida + " " + tablero[fila][col] + " │";
		}

		salida = salida + " " + tablero[fila][0] + " ║ " + (8 - fila) + "\n";

		return salida;
	}

	private String obtenerParteFichaBlanca(int fila) {
		// String I = "\u2502";
		String salida = "       " + (8 - fila) + " ║";

		for (int col = 0; col < tablero[0].length - 1; col++) {
			salida = salida + " " + tablero[fila][col] + " │";
		}

		salida = salida + " " + tablero[fila][tablero[0].length - 1] + " ║ " + (8 - fila) + "\n";

		return salida;
	}

	private String obtenerParteDivisoria() {

		return "         ╟───┼───┼───┼───┼───┼───┼───┼───╢ \n";
	}

	private String obtenerParteInferior() {

		return "         ╚═══╧═══╧═══╧═══╧═══╧═══╧═══╧═══╝\n";
	}

	public boolean coordenadaEnTablero(Coordenada c) {
		if (c.getRow() < 1 || c.getRow() > 8 || c.getColumn() < 'A' || c.getColumn() > 'H')
			return false;
		else

			return true;
	}

	public Celda getCeldaAt(Coordenada coordenada) {
		if (coordenadaEnTablero(coordenada)) {
			return tablero[8 - coordenada.getRow()][coordenada.getColumn() - 'A'];
		}
		System.out.println("No existe la celda en " + coordenada);
		return null;

	}

	public void eliminarPieza(Pieza p) {

		if (p.getColor() == Color.WHITE) {
			Pieza pieza = blancas.getAndRemove(p);

			blancasEliminadas.addHead(pieza);
			System.out.println(pieza);
		} else
			negrasEliminadas.addHead(negras.getAndRemove(p));

	}

	public boolean blackKingIsAlive() {
		return negras.contains(blackking);
	}

	public boolean whiteKingIsAlive() {
		return blancas.contains(whiteking);
	}

	public Lista<Pieza> getBlancas() {
		return blancas;
	}

	public Lista<Pieza> getNegras() {
		return negras;
	}

	public Pieza getPiezaAt(Coordenada c) {
		if (!coordenadaEnTablero(c))
			return null;
		else
			return getCeldaAt(c).getPieza();
	}

	public boolean Check(Color color) {
		Lista l = new Lista();
		if (color == Color.BLACK) {
			for (int i = 0; i < blancas.getSize(); i++) {
				l.addAll(blancas.getDeVerdad(i).getNextMovements());
			}
			if (l.contains(blackking.posicion))
				return true;
			else
				return false;
		} else {
			for (int i = 0; i < negras.getSize(); i++) {
				l.addAll(negras.getDeVerdad(i).getNextMovements());
			}
			if (l.contains(whiteking.posicion))
				return true;
			else
				return false;
		}

	}

}
