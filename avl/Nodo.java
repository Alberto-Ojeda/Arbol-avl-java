package fes.aragon.avl;
/**
 * clase nodo de tipo generica, que se utilizara en nuestro arbol avl
 * 
 * @author alberto
 *
 * @param <T>
 */
public class Nodo <T> {
	private T dato;
	private int fe;
    private T elemento;
	private Nodo<T> hijoIzq;
	private Nodo<T> hijoDer;
	public Nodo(T dato) {
		super();
		this.dato = dato;
		this.hijoIzq=null;
		this.hijoDer=null;
		this.fe=0;
	}
	/**
	 * el metodo nodos completo recibe una variable de tipo nodo, 
	 * la cual sera igual a nuestra raiz, por lo que verificamos si 
	 * esta no es nula en caso de serlo nos retornara un 0. 
	 *  por otro lado en caso de que la raiz no sea nula, con 
	 *  ayuda de un if se verificara si tando, el hijo derecho como el hijo 
	 *  izquierdo no sean nulos, si no son nulos entonces se retornara 
	 *  el hijo izquiero mas el hijo derecho
	 * @param n
	 * @return
	 */
    public int nodosCompletos(Nodo n) {
        if (n == null)
            return 0;
        else {
            if (n.getHijoIzq() != null && n.getHijoDer() != null)
                return nodosCompletos(n.getHijoIzq()) + nodosCompletos(n.getHijoDer()) + 1;
            return nodosCompletos(n.getHijoIzq()) + nodosCompletos(n.getHijoDer());
        }
    }

	public int getFe() {
		return fe;
	}

	public void setFe(int i) {
		this.fe = i;
	}

	public T getDato() {
		return dato;
	}
	public void setDato(T dato) {
		this.dato = dato;
	}
	public Nodo<T> getHijoIzq() {
		return hijoIzq;
	}
	public void setHijoIzq(Nodo<T> hijoIzq) {
		this.hijoIzq = hijoIzq;
	}
	public Nodo<T> getHijoDer() {
		return hijoDer;
	}
	public void setHijoDer(Nodo<T> hijoDer) {
		this.hijoDer = hijoDer;
	}
	/**
	 * metodo que compara objetos, para ver si son menores
	 * lo ocuparemos para comparar nuestros nodos en nuestro arbol avl
	 * @param obj
	 * @return
	 */
	public boolean comparaMenor(Object obj) {
		boolean resultado =false;
		if(dato instanceof Integer){
			Integer dat1=(Integer) dato;
			Integer dat2=(Integer) obj;
			resultado=dat1<=dat2;
		}else if (dato instanceof Float){
			Float dat1=(Float) dato;
			Float dat2=(Float) obj;
			resultado=dat1<=dat2;
		}else if(dato instanceof Double){
			Double dat1=(Double) dato;
			Double dat2=(Double) obj;
			resultado=dat1<=dat2;
		}
		return resultado;
	}	
	/**
	 * por otro lado tambien tenemos un metodo
	 * que compara si es mayor
	 * @param obj
	 * @return
	 */
	public boolean comparaMayor(Object obj) {
		boolean resultado = false;

		if (dato instanceof Integer) {

			Integer dat1 = (Integer) dato;
			Integer dat2 = (Integer) obj;
			
			
			resultado = dat2 < dat1;

		} else if (dato instanceof Float) {
			Float dat1 = (Float) dato;
			Float dat2 = (Float) obj;
			resultado = dat1 > dat2;
		} else if (dato instanceof Double) {
			Double dat1 = (Double) dato;
			Double dat2 = (Double) obj;
			resultado = dat1 > dat2;
		}
		return resultado;

	}
	    
	    
	    public String toString(){
	        return "el dato es "+dato;
	    }
	}	 
	
