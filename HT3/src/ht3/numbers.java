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
public class numbers implements Comparable{
    int numero=0;
    public numbers(int numero){
    this.numero = numero;
}
    
    public int compareTo (Object otro){
        int resultado;
        int otroNumero = ((numbers)otro).getNumero();
        return numero-otroNumero;
   }
    
    
    
    public int getNumero (){
        return numero;
   }
    
    public String toString (){
        return String.valueOf(numero);
   }
    
}
