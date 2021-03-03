package es.ieslavereda.chess;

public class Knight extends Pieza {

	public Knight(Color color, Coordenada posicion, Tablero tablero) {
		super(posicion,tablero);
		if(color==color.WHITE)
			tipo=tipo.WHITE_KNIGHT;
		else
			tipo=tipo.BLACK_KNIGHT;
	}

	@Override
	public Lista<Coordenada> getNextMovements() {
		Lista<Coordenada> lista = new Lista<Coordenada>();
	
		addCoordenada(posicion.up().up().right(),lista);
		addCoordenada(posicion.up().up().left(),lista);
		addCoordenada(posicion.up().right().right(),lista);
		addCoordenada(posicion.up().left().left(),lista);
		addCoordenada(posicion.down().down().right(),lista);
		addCoordenada(posicion.down().down().left(),lista);
		addCoordenada(posicion.down().left().left(),lista);
		addCoordenada(posicion.down().right().right(),lista);
		
		
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
