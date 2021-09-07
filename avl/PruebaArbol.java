package fes.aragon.avl;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fes.aragon.arbolbinario.ArbolBinario;
import lienzoarbol.Controlador;
import lienzoarbol.Controlador2;
import lienzoarbol.Lienzo;
import lienzoarbol.Lienzo2;
/**
 * clase pruebaArbol, en donde se ejecutaran nuestros metodos del arbolavl
 * se encuentra en el paquete fes.aragon.avl 
 * versión 25/nov/2019
 * @author alberto
 *
 */
public class PruebaArbol {
/**
 * metodo main en donde crearmos, haremos dos objetos uno  de tipo arbolbinario
 *  y el otro de tipo arbolavl, ¿para que?, esto con la finalidad 
 *  de presentar de forama grafica  nuestros arboles, y que el usuario 
 *  pueda observar la diferencia de un arbol avl, y un arbol binario 
 *  por eso es que creamos dos objetos uno de cada una de las clases lienzo  
 *  controlador, para pintar cada arbol. 
 * @param args
 */
	public static void main(String[] args) {
/**
 * creamos tres objetos arboles, ya que al usar el metodo para que evalue de forma
 * posfija, hace interrupcion con el metodo lienzo y provoca errores 
 */
		ArbolBinario<Integer> arboriginal= new ArbolBinario<Integer>();
		arbolAvl<Integer> arb = new arbolAvl();
		arbolAvl<Integer> arb1 = new arbolAvl();
		Lienzo objLienzo = new Lienzo();
		Controlador objControlador = new Controlador(objLienzo, arb);
		Lienzo2 obblie= new Lienzo2();
		Controlador2 objcon= new Controlador2(obblie, arboriginal);
		//= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
		arboriginal.insertar(12);
		arboriginal.insertar(8);
		arboriginal.insertar(16);
		arboriginal.insertar(4);
		arboriginal.insertar(10);
	    arboriginal.insertar(14);
	    arboriginal.insertar(2);
		arboriginal.insertar(6);
		arboriginal.insertar(5);
		arboriginal.insertar(1);
		arboriginal.insertar(7);
		objcon.iniciar();
		//INSERTAR 
		arb.insertar(12);
		arb.insertar(8);
		arb.insertar(16);
		arb.insertar(4);
		arb.insertar(10);
	    arb.insertar(14);
	    arb.insertar(2);
		arb.insertar(6);
		arb.insertar(5);
		arb.insertar(1);
		arb.insertar(7);

	//	arb.rotacionder(arb.getRaiz());
        objControlador.iniciar();
        //= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
        //MOSTRAR
        JFrame ventana = new JFrame();
   //     JFrame ventana2 = new JFrame();
//        ventana2.getContentPane().add(obblie);
        
  /*      ventana2.setDefaultCloseOperation(3);
        ventana2.setSize(600, 600);
        ventana2.setVisible(true);
*/
    	JLabel  label2= new JLabel("ARBOL BALANCEADO");
		label2.setBorder(new EmptyBorder(5, 5, 5, 5));
		label2.setBounds(40, 239, 300, 45);
		label2.setBackground(Color.GREEN);
		label2.setForeground(Color.white);
		label2.setFont(new Font("DejaVu Serif Condensent", Font.BOLD, 18));
		ventana.add(label2);
    
        JPanel panel = objLienzo;
		panel.setBounds(100, 239, 400, 239);
		panel.setBackground(Color.black);
		panel.setForeground(Color.GREEN);
		ventana.add(panel);    
		
		JLabel  label= new JLabel("ARBOL ORIGINAL");
		label.setBorder(new EmptyBorder(5, 5, 5, 5));
		label.setBounds(40, 15, 300, 45);
		label.setBackground(Color.GREEN);
		label.setForeground(Color.white);
		label.setFont(new Font("DejaVu Serif Condensent", Font.BOLD, 18));
		ventana.add(label);

		JPanel panel2 = obblie;
		panel2.setBounds(100, 450, 1000,300);
		panel2.setBackground(Color.black);
		panel2.setForeground(Color.blue);
		ventana.add(panel2);    

	

		/*        ventana.getContentPane().add(objLienzo);
        
        ventana.setDefaultCloseOperation(3);
*/
        //		ventana.setBackground(Color.GREEN);
	//	ventana.setForeground(Color.white);
        ventana.setSize(900, 800);
        ventana.setVisible(true);

System.out.println("preorden");	    
arb.preOrden(arb.getRaiz());
System.out.println("posorden");
arb.posOrden(arb.getRaiz());
System.out.println("inorden");
arb.inorden(arb.getRaiz());
System.out.println("amplitud");
arb.recAmplitud();
System.out.println("ELIMINAR DATO");
arb.eliminar(25);
arb.recAmplitud();
System.out.println("LA RAIZ DEL ARBOL ES:");
arb.imprimirraiz();
System.out.println("EL MAXIMO ES:");
arb.maximo();
System.out.println("EL MINIMO ES:");
arb.menorValor();
System.out.println("LA ALTURA DEL ARBOL ES");
System.out.println(arb.Altura(arb.buscar(10,arb.getRaiz())));
arb.NIVEL(10);
System.out.println("profundidad del nodo es"); 
arb.profundidad(10);

System.out.println("METODO DE Posfija");
System.out.println("--------");

String ca = "^ / * + 8 4 3 2 4 ";
String[] token2 = ca.split(" ");
arb1.insertarPosfija(token2);
arb1.recAmplitud();
arb1.evaluacion1(); 

}
	}