package es.ieslavereda.chess;

public class Lista<T> {

	private int size;
	private Nodo<T> cabeza;
	private Nodo<T> cola;

	public Lista() {
		super();

		size = 0;
		cabeza = null;
		cola = null;
	}

	public void addHead(T info) {

		Nodo<T> nodo = new Nodo<T>(info);
		if (cabeza == null) {
			cabeza = nodo;
			cola = nodo;

		} else {
			nodo.setSiguiente(cabeza);
			cabeza.setAnterior(nodo);
			cabeza = nodo;
		}

		size++;

	}

	public void addTail(T info) {
		Nodo<T> aux = new Nodo<T>(info);
		if (cola == null) {
			cabeza = aux;
			cola = aux;
		} else {
			aux.setAnterior(cola);
			cola.setAnterior(aux);
			cola = aux;
		}
		size++;

	}

	public T getHead() {
		T valor = null;

		if (cabeza == null) {
			return null;
		} else if (cabeza == cola) {
			valor = cabeza.getInfo();
			cabeza = null;
			cola = null;
			size--;
		} else {
			valor = cabeza.getInfo();
			cabeza.getSiguiente().setAnterior(null);
			cabeza = cabeza.getSiguiente();
			size--;
		}
		return valor;

	}

	public T getTail() {
		T valor = null;

		if (cabeza == null) {
			return null;
		} else if (cabeza == cola) {
			valor = cabeza.getInfo();
			cabeza = null;
			cola = null;
			size--;
		} else {
			valor = cola.getInfo();
			cola.getAnterior().setSiguiente(null);
			cola = cola.getAnterior();
			size--;
		}

		return valor;
	}

	public int search(T p) {

		int posicion = -1;

		Nodo<T> aux = cabeza;
		int i = 0;

		while (aux != null && posicion == -1) {
			if (p.equals(aux.getInfo())) {
				posicion = i;
			}
			i++;
			aux = aux.getSiguiente();

		}

		return posicion;
	}

	public int getSize() {
		return size;
	}

	public Lista<T> addAll(Lista<T> lista) {

		Nodo<T> aux = lista.cabeza;
		while (aux != null) {
			addHead(aux.getInfo());
			aux = aux.getSiguiente();
		}

		return this;

	}

	public T getAndRemove(T elemento) {

		if (elemento.equals(cabeza))
			return getHead();
		else if (elemento.equals(cola))
			return getTail();
		else {

			Nodo<T> aux = cabeza;
			T valor = null;

			while (aux != null && valor == null) {
				if (aux.getInfo().equals(elemento))
					valor = aux.getInfo();
				else
					aux = aux.getSiguiente();
			}
			if (valor != null) {
				aux.getAnterior().setSiguiente(aux.getSiguiente());
				aux.getSiguiente().setAnterior(aux.getAnterior());
				size--;
			}
			return valor;

		}
	}
	public boolean isEmpty() {
		return size == 0;
	}

	public boolean contains(T elemento) {
		boolean contiene = false;
		Nodo<T> nodo = cabeza;
		while (nodo != null && !contiene) {
			if (nodo.getInfo().equals(elemento))
				contiene = true;
			nodo = nodo.getSiguiente();
		}

		return contiene;
	}

	public T get(int index) {

		if (index == 0)
			return getHead();
		else if (index == size - 1)
			return getTail();
		else if (index > 0 && index < size) {

			Nodo<T> aux = cabeza;
			int i = 0;
			while (i < index) {
				aux = aux.getSiguiente();
				i++;
			}

			aux.getAnterior().setSiguiente(aux.getSiguiente());
			aux.getSiguiente().setAnterior(aux.getAnterior());
			size--;

			return aux.getInfo();

		} else
			return null;
	}

	public T getDeVerdad(int index) {

		if(index<0 || index>=size) {
			return null;
		}else {
			Nodo<T> aux=cabeza;
			int i=0;
			while(i<index) {
				aux=aux.getSiguiente();
				i++;
			}
			return aux.getInfo();
		}
	}

	@Override
	public String toString() {

		String salida = "";
		salida = "size : " + size + "\n";
		salida = "valores: ";
		Nodo<T> aux = cabeza;
		while (aux != null) {
			salida += aux.toString() + " ";
			aux = aux.getSiguiente();
		}

		return salida;
	}

}
