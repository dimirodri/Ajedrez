package es.ieslavereda.chess;

public class King extends Pieza {

	public King(Color color,Coordenada posicion, Tablero tablero) {
		super(posicion, tablero);
		if(color==color.WHITE)
			tipo=tipo.WHITE_KING;
		else
			tipo=tipo.BLACK_KING;
	}

	@Override
	public Lista<Coordenada> getNextMovements() {
		
		Lista<Coordenada> lista = new Lista<Coordenada>();
		
		addCoordenada(posicion.up(),lista);
		addCoordenada(posicion.down(),lista);
		addCoordenada(posicion.left(),lista);
		addCoordenada(posicion.right(),lista);
		addCoordenada(posicion.diagonalUpLeft(),lista);
		addCoordenada(posicion.diagonalUpRight(),lista);
		addCoordenada(posicion.diagonalDownLeft(),lista);
		addCoordenada(posicion.diagonalDownRight(),lista);
		

		
		
		return lista;
	}
	private void addCoordenada(Coordenada c, Lista<Coordenada> lista) {
		if(tablero.coordenadaEnTablero(c)) {
			if(tablero.getCeldaAt(c).contienePieza()) {
				if(tablero.getCeldaAt(c).getPieza().getColor()!=getColor()) {
					lista.addHead(c);
				}
			}else {
				lista.addHead(c);
			}
				
		}
		
	}

}
