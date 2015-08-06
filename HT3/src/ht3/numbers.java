/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht3;

/**
 *
 * @author marcosb11
 */
public class numbers implements Comparable{ //implementamos la interfaz comparable
    private int numero=0; //creamos una variable de tipo int para almacenar el valor
    
    public numbers(int numero){
        this.numero = numero; //constructor para el numero
    }
    
    public int compareTo (Object otro){ //este metodo se se encarga de realizar las comparaciones
        int otroNumero = ((numbers)otro).getNumero(); //para ello almacenamos el valor del segundo numero
        return numero-otroNumero; //y se lo restamos al primero para devolver valores negativos, cero o positivos
   }
    
        public int getNumero (){ //get para recibir el valor del numero (encapsulacion)
        return numero;
   }
    
    public String toString (){ //para imprimir los valores del numero almacenado
        return String.valueOf(numero);
   }
    
}
