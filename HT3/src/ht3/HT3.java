/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht3;

import java.util.Scanner;

/**
 *
 * @author Home
 */
public class HT3 {

    /**
     * @param args the command line arguments
     */
    
    //selection O(n2)
    public static void main(String[] args) {
        Sorting sort = new Sorting();
        Scanner entrada = new Scanner(System.in);
        int resultado[];
        int size;
        System.out.println("Ingrese el tamaño del arreglo de numeros (min: 10 max: 100)");
        size = entrada.nextInt();
        resultado = new int [size];
        
        sort.setSize(size);
        sort.fill();
        resultado = sort.selectionSort();
        System.out.println("*********Selection Sort*********");
        for(int i = 0; i < size; i++){
          System.out.println(resultado[i]);
        }
    }
}
