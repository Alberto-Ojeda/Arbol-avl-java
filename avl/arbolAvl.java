package fes.aragon.avl;
/**
 * 
 */
import fes.aragon.cola.Cola;
import pila.Pila;
/**
 * clase arbol avl, la cual recibe un parametro de tipo
 * generico, la cual se encuentra en el paquete fes.aragon.avl
 * para la realización de esta clase necesitamos importar,
 * nuestra clase cola, ya que, nos fue de gran de utilidad a la
 * hora de realizar los metodos. 
 * versión 24/nov/2019
 * @author alberto
 *
 * @param <T>
 */
public class arbolAvl <T>{
/**
 *primeramente, creamos una variable de tipo nodo, la cual
 *recibira como nombre "raiz" 
 */
private Nodo raiz;
String[] niveles;
int nivel=0;
private Nodo<T> n;
int tmp1;
/**
 * nuestro constructor por lo mientras contendra los datos rai y oper
 * @param raiz
 * @param oPER
 */
public arbolAvl() {
}
/**
 * este sera uno de nuestros nuevos metodos el cual tendra como nombre
 * insertaravl.
 * tiene como parametros dos variables de tipo nodo (nuevo, subar), subar
 * que hace referencia a sub arbol, lo primero a que hicimos para la creación
 * de este metodo, es crear una variable de tipo nodo, la cual sera igual a subar,
 * empezaremos por ocupar nuestros metodos ya creados con anterioridad, para comparar
 * nuestros nodos, ya que como podemos observar en el if, recibe un nodo y junto con 
 * nuestro metodo comparaMenor, hara la comparación, entre el nodo nuevo y subar ya que
 * como son objetos no se pueden comparar como generalmente lo hacemos con <> 
 * despues pasamos a la realización de otras comparación, en el nodo subar para ver 
 * si su hijo izquierdo es nulo, si lo es, entonces el hijo izquierdo de subar, obtendra 
 * el dato del nodo nuevo. 
 * si las comparaciones anteriores no son acertadas lo que se hace es que el hijo izquierdo de subar
 * atrae el dato insertado en el arbolavl
 * despues se hacen las comparaciones de el factor de equilibri, en donde el hijo izquierdo 
 * y el hijo derecho se restaran, y se vera si este es igual a 2, si lo es se haran las comparación
 * para hacer la rotacion correcta, ya sea que se utiliza una rotación simple izquierda o una 
 * rotación simple derecha, esto se hace en el primer caso, pero por el caso contrario a este se efectuara
 * lo mismo pero de manera contraria, ya que a diferencia de este caso que se utilizo una comparación 
 * para ver si es menor en nuestro siguiente caso se evalua para ver si es mayor, y se evaluan los hijos
 * de lado derecho y esto tambien pasa con las rotaciones que se efecturan, en lugar de ser izquierdas
 * seran hacia la derecha, y si ninguno de estos dos casos, es el correcto entonces el nodo se introdujo 
 * dos veces, por ultimo lo que hacemos es realizar comparaciones para ver si no son nulos los hijos y al final
 * retornaremos el nodo, nuevopadre que creamos al inicio. 
 * 
 * @param nuevo
 * @param subar
 * @return
 */
public  Nodo insertaravl(Nodo nuevo, Nodo subar) {
	Nodo nuevopadre=subar;
	if (nuevo.comparaMenor(subar.getDato())) {
		if (subar.getHijoIzq()==null) {
			subar.setHijoIzq(nuevo);
		} else {
			subar.setHijoIzq(insertaravl(nuevo, subar.getHijoIzq())); 
		if ((obtenerFe(subar.getHijoIzq())-obtenerFe(subar.getHijoDer()))==2) {
			if (nuevo.comparaMenor(subar.getHijoIzq().getDato())) {
			nuevopadre=rotacionizq(subar);	
			}else {
				nuevopadre=rotdobleizq(subar);
			}
		}
		}

	}		else if (nuevo.comparaMayor(subar.getDato())) {
		if (subar.getHijoDer()==null) {
			subar.setHijoDer(nuevo);
			
		}else {
			subar.setHijoDer(insertaravl(nuevo, subar.getHijoDer()));
			if (obtenerFe(subar.getHijoDer())-obtenerFe(subar.getHijoIzq())==2) {
				if (nuevo.comparaMayor(subar.getHijoDer().getDato())) {
					nuevopadre=rotacionder(subar);
				}else {
					nuevopadre=rotdobleder(subar);
				}
				
			}
		}
	}else {
		System.out.println("Nodo duplicado");
	}
	if ((subar.getHijoIzq()==null)&&(subar.getHijoDer()!=null)) {
		subar.setFe(subar.getHijoDer().getFe()+1);
	}else if ((subar.getHijoDer()==null)&&(subar.getHijoIzq()!=null)) {
		subar.setFe(subar.getHijoIzq().getFe()+1);
	}else {
		subar.setFe((Math.max(obtenerFe(subar.getHijoIzq()), obtenerFe(subar.getHijoDer()))+1));
		
	}	
	return nuevopadre; 
}
/**
 * nuestro metodo insertar, es el que ocuparemos en el main, y 
 * recibe un dato de tipo generico, crearemos un nuevo nodo que sera igual 
 * a nuestro dato ingresado es por eso que hacemos un caseo  
 * y lo primero que haremos es verificar si la raiz no es nula, ya que, si 
 * lo es entonces nuestro nodo nuevo nodo sera igual a la raiz y e caso de que 
 * la raiz no sea nula se llamara a nuestro metodo insertar avl que anteriormente
 * ya explicamos. 
 * @param d
 */
public void insertar(T d) {
	Nodo nuevo=new Nodo(d);
	if (raiz==null) {
		raiz=nuevo;
	}
	else {
		raiz=insertaravl(nuevo, raiz);
	}
}

/**
 * el metodo buscar, recibira un entero y un nodo 
 * lo primero que haremos para la busqueda de un nodo
 * es verificar si la raiz no es nula, ya que en caso de 
 * que lo sea no hay nada que buscar, si no lo es
 * entonces haremos uso de la recursividad atrayendo los datos
 * de los nodos, del hijo derecho e hijo izquierdo y analizando 
 * si alguno de estos es igual al dato solicitado 
 * @param d
 * @param r
 * @return
 */
public Nodo buscar(int d, Nodo r){
if (raiz==null) {
	return null;
}else if (r.getDato().equals(d)	) {
	return r;
}else if (r.comparaMenor(d)) {
return buscar(d,r.getHijoDer());	
}else {
	return buscar(d, r.getHijoIzq());
}
	
}
/**
 * en este metodo, recibe un nodo n, el cual sera la raiz y un valor
 * entero, con el cual ira buscando entre los hijos
 * @param n
 * @param valor
 * @return
 */
public  Nodo BuscarNodo( Nodo n, int valor ) {
	  if ( n == null){
		  return (null); // árbol vacío o hijo de hoja
	  }else {
		  if( n.getDato().equals(valor)){
			  return(n); // lo encontró
		  }else{
			  	if(n.comparaMenor(valor)){
			  		n = BuscarNodo( n.getHijoDer(),valor);
			  	}else{
			  		n = BuscarNodo(n.getHijoIzq(),valor);
			  	}
		  }
		  return ( n ); // los retornos de las llamadas recursivas se pasan via t
	  } 
}
/**
 * obtener factor de equilibrio, recibe un nodo 
 * y si el nodo recibido es nulo, entonces 
 * retornara un -1 si no lo es retornara
 * el factor de equilibrio
 * @param e
 * @return
 */
public int obtenerFe(Nodo e) {
	if (e==null) {
		return -1;
	}else {
		return 	 e.getFe();
	}

}
/**
 * para el metodo rotacion izquierda, lo que le daremos es un nodo 
 * crearemos un nodo auxiliar el cual sera igual a al hijo izquierdo 
 * de nuestro nodo dado y si hijo izquierdo de nuestro nodo dado sera igual 
 * al hijo derecho de nuestro nodo auxiliar y por ultimo el hijo derecho de nuestro nodo 
 * auxiliar sera igual a nuestro nodo dado, despues pasamos a decirle que el factor de 
 * equilibrio de nuestro nodo dado sera igual al valor maximo de dos valores los cuales
 * se compararan con el metodo max de la libreria math, los valores a comparar son:
 * el hijo derecho y el hijo izquierdo y le sumamos 1 porque el factor de equilibrio es el 
 * nivel mas 1
 * y pasamos a realizar lo mismo pero con nuestro nodo auxiliar  y retornaremos nuestro nodo
 * auxiliar 
 * @param d
 * @return
 */

public Nodo<T> rotacionizq(Nodo d) {
	Nodo<T> auxiliar=d.getHijoIzq();
	d.setHijoIzq(auxiliar.getHijoDer());
	auxiliar.setHijoDer(d);
	d.setFe(Math.max(obtenerFe(d.getHijoIzq()), obtenerFe(d.getHijoDer()))+1);
	auxiliar.setFe(Math.max(obtenerFe(auxiliar.getHijoIzq()), obtenerFe(auxiliar.getHijoDer()))+1);
return auxiliar;
}
/**
 * para el metodo rotacion derecha, lo que le daremos es un nodo 
 * crearemos un nodo auxiliar el cual sera igual a al hijo derecho 
 * de nuestro nodo dado y el hijo derecho de nuestro nodo dado sera igual 
 * al hijo izquierdo de nuestro nodo auxiliar y por ultimo el hijo izquierdo de nuestro nodo 
 * auxiliar sera igual a nuestro nodo dado, despues pasamos a decirle que el factor de 
 * equilibrio de nuestro nodo dado sera igual al valor maximo de dos valores los cuales
 * se compararan con el metodo max de la libreria math, los valores a comparar son:
 * el hijo derecho y el hijo izquierdo y le sumamos 1 porque el factor de equilibrio es el 
 * nivel mas 1
 * y pasamos a realizar lo mismo pero con nuestro nodo auxiliar  y retornaremos nuestro nodo
 * auxiliar 
 * @param d
 * @return
 */
public Nodo<T> rotacionder(Nodo<T> d) {
	Nodo<T> auxiliar=d.getHijoDer();
	d.setHijoDer(auxiliar.getHijoIzq());
	auxiliar.setHijoIzq(d);
	d.setFe(Math.max(obtenerFe(d.getHijoIzq()), obtenerFe(d.getHijoDer()))+1);
auxiliar.setFe(Math.max(obtenerFe(auxiliar.getHijoIzq()), obtenerFe(auxiliar.getHijoDer()))+1);
return auxiliar;
}
/**
 * para la rotación doble derecha de igual manera recibira una variable de tipo nodo, y lo primero 
 * que haremos es crear un nodo temporal, el hijo derecho de nuestro nodo dado, recibira
 * los datos de la rotacion izquierdad de nuestro nodo derecho y el temporal sera igual 
 * a la rotacion derecha de nuestro nodo dado, de esta manera retornamos el nodo temporal
 * con doble rotación en nuestro nodo 
 * @param c
 * @return
 */
public Nodo<T> rotdobleder(Nodo c) {
	Nodo<T> temporal ;
	c.setHijoDer((rotacionizq(c.getHijoDer())));
	temporal=(rotacionder(c));
return temporal;
}
/**
 * para la rotación doble izquierda de igual manera recibira una variable de tipo nodo, y lo primero 
 * que haremos es crear un nodo temporal, el hijo izquierdo de nuestro nodo dado, recibira
 * los datos de la rotacion derecha de nuestro nodo izquierdo y el temporal sera igual 
 * a la rotacion izquierda de nuestro nodo dado, de esta manera retornamos el nodo temporal
 * con doble rotación en nuestro nodo 
 * @param c
 * @return
 */
public Nodo<T> rotdobleizq(Nodo c) {
	Nodo<T> temporal ;
	c.setHijoIzq(((rotacionder(c.getHijoIzq()))));
	temporal=(rotacionizq(c));
return temporal;
}	
/**
 * para recorrer nuestro arbol, por amplitud reutilizamos nuestro
 * codigo, anteriormente usado, en el arbol binario. 
 */
public void recAmplitud(){
	Nodo n=raiz;
	Cola<Nodo> cola=new Cola<>();
	if(n!=null){
		cola.insertar(raiz);
		while(!cola.vacia()){
			n=cola.sacar();
			System.out.println(n.getDato());
			if(n.getHijoIzq()!=null){
				cola.insertar(n.getHijoIzq());
			}
			if(n.getHijoDer()!=null){
				cola.insertar(n.getHijoDer());
			}
		}
	}
}
/**
 * recorrimiento del arbol en preorden primero se verifica 
 * si la raiz no es nula en caso de que no lo sea, imprimira
 * la raiz, y ira recorriendo el nodo hijo izquierdo y despues el
 * nodo hijo derecho
 */
public void preOrden(Nodo n){
	if(n!=null) {
	System.out.println(n.getDato());
	preOrden(n.getHijoIzq());
	preOrden(n.getHijoDer());
}	
}
/**
 * por otro lado el metodo pos orden, a diferencia de el pre orden 
 * primero recorrera el nodo hijo izquierdo, el nodo hijo derecho
 * y despues pasara a imprimir los datos
 * @param n
 */
public void posOrden(Nodo n){
	if(n!=null){
		posOrden(n.getHijoIzq());
		posOrden(n.getHijoDer());
		
		System.out.println(n.getDato());
	}
}
/**
 * en el caso del recorrido de forma inorden 
 * se traen los datos, del nodo hijo izquierdo 
 * se imprime el dato, y despues se trae los datos
 * del nodo hijo derecho. 
 * @param n
 */
public void inorden(Nodo n){
	 if (n != null){
	   inorden (n.getHijoIzq());
	   System.out.println(n.getDato());
	   inorden (n.getHijoDer());
	 }
  }  

/**
* los siguientes metodos, reciben un nodo n 
* y devuelve la variable ecu con una cadena de string
* de los datos de los nodos
*/
String OPER="";
public void poscad(Nodo n) {
if(n!=null){
	poscad(n.getHijoIzq());
	poscad(n.getHijoDer());	
	OPER += (String) n.getDato() + " ";
}
	
}
/**
 * devuelve la raiz del arbol
 * @return
 */
public Nodo getRaiz() {
	return raiz;
}
/**
 * se inserta un arreglo de string 
 * de forma posfija, y evaluara el orden de la operación para despues
 * con otro metodo resuelva la operación
 * @param cadena
 */
public void insertarPosfija(String[] cadena){
	int indice=0; 
	String simbolo=cadena[indice];
	indice++;
	Nodo <String> ultimoNodo =new Nodo<String>(simbolo);
	raiz = (Nodo <T>)ultimoNodo;
	boolean sigMovimiento = true;
	Pila <Nodo<String >> pila = new Pila<>();
	simbolo = cadena [indice];

	while(indice < cadena.length){
		Nodo<String>NuevoNodo = new Nodo(simbolo);
	    if(sigMovimiento){
	    	  ultimoNodo.setHijoIzq(NuevoNodo);	
	    	  pila.insertar(ultimoNodo);
	    }else{
	    	  ultimoNodo = pila.sacar();
	    	  ultimoNodo.setHijoDer(NuevoNodo);
	    }
	    if(simbolo.equals("+")|| simbolo.equals("-")||simbolo.equals("*")||simbolo.equals("/")|| simbolo.equals("^")){
	    	  sigMovimiento = true;
	    }
	    else{
	          sigMovimiento = false;
	    }
	    ultimoNodo = NuevoNodo;
	    indice++;
	    if(indice<cadena.length){
	    	  simbolo= cadena[indice];
	    }
	}
}

/**
* recibe un dato y lo elimina
* @param dato
*/
public void eliminar(T dato) {
	Nodo<T> tmp,nodo,previo=null,n=raiz;
	while (n!=null && n.getDato()!=dato) {
		previo=n;
		if (n.comparaMenor(dato)) {
			n=n.getHijoDer();
		}else {
			n=n.getHijoIzq();
		}
	}
	nodo=n;
	if (n!=null && n.getDato()==dato) {
		if (nodo.getHijoDer()==null) {
			nodo=nodo.getHijoIzq();
			}else if (nodo.getHijoIzq()==null) {
				nodo=nodo.getHijoDer();
			}else {
				tmp=nodo.getHijoIzq();
				while (tmp.getHijoDer()!=null) {
					tmp=tmp.getHijoDer();
				}
				tmp.setHijoDer(nodo.getHijoDer());
				nodo=nodo.getHijoIzq();
		}
		if (n==raiz) {
			raiz=nodo;
		}else if (previo.getHijoIzq()==n) {
			previo.setHijoIzq(nodo);
		}else {
			previo.setHijoDer(nodo);
		}
			
	}else if (raiz!=null) {
		System.out.println("no exisste dato");
	}else {
		System.out.println("arbol vacio");
	}
}
/**
 * en el siguiente metodo se encontrara el nodo maximo
 * lo que se le indica es que hasta que la raiz sea nula, 
 * se ira iterante del lado derecho 
 * para encontrar el valor maximo que hay en el arbol
 */
public void maximo() {
if (raiz!=null){
	Nodo max = raiz;
    while (max.getHijoDer() != null) {
        max = max.getHijoDer();
    }
    System.out.println(max.getDato());
}
}
public void imprimirraiz() {
System.out.println(raiz.getDato());
}
/**por el contrario del maximo valor, aqui
* se ira iterando del lado izquierdo para encontrar
* el minimo valor
* 
*/
public void menorValor() {
if (raiz != null) {
    Nodo minimo = raiz;
    while (minimo.getHijoIzq() != null) {
        minimo = minimo.getHijoIzq();
    }
    System.out.println(minimo.getDato());
}
}
/**
 * este metodo recibe un nodo y el nivel inicial para
 * devolver el nivel de cada nodo
 * @param n
 * @param nivel
 */
public void niveles(Nodo<T> n, int nivel) {
	if (n!=null) {
	niveles[nivel]= n.getDato()+ " " + ((niveles[nivel]!=null) ? niveles[nivel] : "");
	niveles(n.getHijoDer(),nivel+1);
	niveles(n.getHijoIzq(),nivel+1);
	
	}
	}
public void nivel() {
niveles=new String[tmp1+1];
niveles(raiz, 0);
for (int i = 0; i < niveles.length; i++) {
	System.out.println(niveles[i]+"en nivel"+i);
}
}
public void profundidad(Integer dato) {
	Nodo<T> n = raiz;
	int contador = 0;
	while (n != null && n.getDato() != dato) {
		contador++;
		if (!n.comparaMenor(dato)) {
			n = n.getHijoIzq();
		} else {
			n = n.getHijoDer();
		}
	}
	if (n != null && n.getDato() == dato) {
		System.out.println(contador);
	} else {
		System.err.println("No existe el dato ");
	}
}
/**
 * recibe el dato, y devuelve el nivel en el que se encuentra
 * a diferencia de el metodo que imprime todos los niveles
 * este solo devuelve el dato solicitado
 * @param dato
 */
public void NIVEL(Integer dato) {
	Nodo<T> n = raiz;
	int contador = 0;
	while (n != null && n.getDato() != dato) {
		contador++;
		if (!n.comparaMenor(dato)) {
			n = n.getHijoIzq();
		} else {
			n = n.getHijoDer();
		}
	}
	if (n != null && n.getDato() == dato) {
		System.out.println("el nivel del nodo es" + " " + contador);
	} else {
		System.err.println("No existe el dato ");
	}
}
/**
 * este metodo devuelve la altura del arbol, la cual es
 * del nodo dado hasta la hoja mas profunda
 * @param n
 * @return
 */
public int Altura(Nodo n){
	 int h, max;
	 if( n == null){
		 return -1;
	 }else {
		 h = Altura (n.getHijoDer());
		 max = Altura (n.getHijoIzq());
	 }if (h > max){
		 max = h;
	 }
	 return(max+1);
}
/**
 * este metodo hace la evaluacion, de la operacion posfija
 * para devolver el resultado de esta
 * @return
 */

	public float evaluacion1() {
		String[] cadena = this.getEcuacion().split(" ");
		Pila<Float> pila = new Pila<>();
		for (int i = 0; i < cadena.length; i++) {
			if (!cadena[i].equals("+") && !cadena[i].equals("-") && !cadena[i].equals("/") && !cadena[i].equals("^")
					&& !cadena[i].equals("*")) {
				pila.insertar(Float.parseFloat(cadena[i]));
			} else {
				float operDos = pila.sacar();
				float operUno = pila.sacar();
				float valor;
				if (cadena[i].equals("+")) {
					valor = operUno + operDos;
				} else if (cadena[i].equals("-")) {
					valor = operUno - operDos;
				} else if (cadena[i].equals("*")) {
					valor = operUno * operDos;
				} else if (cadena[i].equals("/")) {
					valor = operUno / operDos;
				} else if (cadena[i].equals("^")) {
					valor = (float) Math.pow(operUno, operDos);
				} else {
					valor = 0;
					System.out.println("Hay un error! ");
				}
				pila.insertar(valor);
			}
		}
		
		if (!pila.vacia()) {
			Float valor = pila.sacar();
			System.out.println(valor);
			return valor;
		}
		return -1;
	}
	/**
	 * se le da el nodo, y retorna la cadena
	 * @return
	 */
	public String getEcuacion() {
		this.poscad(raiz);
		return OPER;
	}

}
