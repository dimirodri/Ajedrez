package es.ieslavereda.chess;

public class Coordenada{

	private int row;
	private char column;
	
	public Coordenada( char column,int row) {
		
//		if(row<0 || row>8) 
//			this.row=0;
//		else
			this.row = row;
		
//		String letra = String.valueOf(column);
//		char upper = letra.toUpperCase().charAt(0);
//		
//		if(upper<'A' || upper>'H')
//			this.column='A';
//		else
			this.column=column;
	}
	
	public Coordenada up() {
		return  new Coordenada(column,row+1);
		
	}
	public Coordenada down() {
		return new Coordenada(column,row-1);

		
	}
	public Coordenada left() {
		return new Coordenada((char)(column-1),row);

		
	}
	public Coordenada right() {
		return new Coordenada((char)(column+1),row);
		
	}
	
	public Coordenada diagonalUpLeft() {
		return up().left();
	}
	public Coordenada diagonalUpRight() {
		return up().right();
	}
	public Coordenada diagonalDownLeft() {
		return down().left();
	}
	public Coordenada diagonalDownRight() {
		return down().right();
	}
	

	public int getRow() {
		return row;
	}

	public char getColumn() {
		return column;
	}
	@Override
	
	public boolean equals(Object o) {
		if(o instanceof Coordenada) {
			Coordenada c= (Coordenada) o;
			return row==c.row && c.column==column;
		}else {
			return false;
		}
	}

	@Override
	public String toString() {
		return String.valueOf(column) + row;
	}
	
}
