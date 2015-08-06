/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht3;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Home
 */
public class Sorting {
    public void selectionSort (Comparable[] list){
        int min;
        Comparable temp;

        for (int index = 0; index < list.length-1; index++){
            min = index;
            for (int scan = index+1; scan < list.length; scan++)
                if (list[scan].compareTo(list[min]) < 0)
                min = scan;

            // Swap the values
            temp = list[min];
            list[min] = list[index];
            list[index] = temp;
        }
    }
    public void insertionSort (Comparable[] list){
        int position = 0;
        for (int index = 1; index < list.length; index++){
            Comparable key = list[index];
            position = index;

            //Shift larger values to the right
            while (position > 0 && key.compareTo(list[position-1]) < 0){
                list[position] = list[position-1];
                position--;
            }
            
            list[position] = key;
        }
    }
 
    static void mergeSort(Comparable[] list) {
        if (list.length > 1) {
            int mid = list.length/2;

            Comparable[] leftArray = Arrays.copyOfRange(list, 0, mid);
            Comparable[] rightArray = Arrays.copyOfRange(list, mid, list.length);

            mergeSort(leftArray);
            mergeSort(rightArray);

            merge(list,leftArray,rightArray);
        }
    }

    static void merge(Comparable[] sublist, Comparable[] l,Comparable[] r) {
        int totElem = l.length + r.length;
        //int[] a = new int[totElem];
        int i,li,ri;
        i = li = ri = 0;
        while ( i < totElem) {
            if ((li < l.length) && (ri<r.length)) {
                if (l[li].compareTo(r[ri]) < 0) {
                    sublist[i] = l[li];
                    i++;
                    li++;
                }
                else {
                    sublist[i] = r[ri];
                    i++;
                    ri++;
                }
            }
            else {
                if (li >= l.length) {
                    while (ri < r.length) {
                        sublist[i] = r[ri];
                        i++;
                        ri++;
                    }
                }
                if (ri >= r.length) {
                    while (li < l.length) {
                        sublist[i] = l[li];
                        li++;
                        i++;
                    }
                }
            }
        }
    }
    
    public void quickSort(Comparable array[], int start, int end){
        int i = start;                          // index de donde empieza
        int k = end;                            // donde terminea

        if (end - start >= 1)                   // verifica que por lo menos hayan dos elementos
        {
                Comparable pivot = array[start];       //la particion se pone al principio

                while (k > i)                   
                {
                        while (array[i].compareTo(pivot) <= 0 && i <= end && k > i)  //desde la izquiera empieza
                                i++;                                    
                        while (array[k].compareTo(pivot) > 0 && k >= start && k >= i) //desde la deracha
                            k--;                                        
                        if (k > i)                                     
                                swap(array, i, k);                      //se intercambian los elementos
                }
                swap(array, start, k);          
                                              
                quickSort(array, start, k - 1); 
                quickSort(array, k + 1, end);  
        }
        else    //por si solo existe un elemento
        {
                return;                    
        }
    }

    public void swap(Comparable array[], int index1, int index2){
    // pre: array is full and index1, index2 < array.length
    // post: the values at indices 1 and 2 have been swapped
        Comparable temp = array[index1];           //guarda el primer valor un un temporal
        array[index1] = array[index2];      //copia el valor del segundo elemnto
        array[index2] = temp;               //lo mueve hacia el temporal
    }
}
