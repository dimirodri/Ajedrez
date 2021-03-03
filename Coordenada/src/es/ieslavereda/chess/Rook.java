package es.ieslavereda.chess;

public class Rook extends Pieza{

	public Rook(Color color, Coordenada posicion, Tablero tablero) {
		super(posicion, tablero);
		
		if(color==Color.WHITE)
			tipo=Tipo.WHITE_ROOK;
		else
			tipo=tipo.BLACK_ROOK;
		
	}

	@Override
	public Lista<Coordenada> getNextMovements() {

		
		return getNextMovements(tablero, this);
	}
	public static Lista<Coordenada> getNextMovements(Tablero t, Pieza p){
		Lista<Coordenada> lista = new Lista<Coordenada>();
		Coordenada u = p.posicion.up();
		Coordenada d=p.posicion.down();
		Coordenada r=p.posicion.right();
		Coordenada l=p.posicion.left();

		while(t.coordenadaEnTablero(u) && t.getCeldaAt(u).contienePieza()==false) {
			lista.addHead(u);
			u=u.up();
		}
		if(t.coordenadaEnTablero(u) && p.getColor()!=t.getCeldaAt(u).getPieza().getColor()) {
			lista.addHead(u);
		}
		while(t.coordenadaEnTablero(d) && t.getCeldaAt(d).contienePieza()==false) {
			lista.addHead(d);
			d=d.down();
		}
		if(t.coordenadaEnTablero(d) && p.getColor()!=t.getCeldaAt(d).getPieza().getColor()) {
			lista.addHead(d);
		}
		while(t.coordenadaEnTablero(r) && t.getCeldaAt(r).contienePieza()==false) {
			lista.addHead(r);
			r=r.right();
		}
		if(t.coordenadaEnTablero(r) && p.getColor()!=t.getCeldaAt(r).getPieza().getColor()) {
			lista.addHead(r);
		}
		while(t.coordenadaEnTablero(l) && t.getCeldaAt(l).contienePieza()==false) {
			lista.addHead(l);
			l=l.left();
		}
		if(t.coordenadaEnTablero(l) && p.getColor()!=t.getCeldaAt(l).getPieza().getColor()) {
			lista.addHead(l);
		}
		
		
		return lista;
	}
	

}
