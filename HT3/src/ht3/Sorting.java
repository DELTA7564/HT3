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
    public void selectionSort (Comparable[] list){ //sort por seleccion
        int min; //variable que almacena la posicion del numero mas pequeño
        Comparable temp; //creamos un objeto Comparable para almacenar el valor temporal

        for (int index = 0; index < list.length-1; index++){ //recorremos toda la cadena excepto la ultima posicion
            min = index; //el index se toma como la posicion minima
            for (int scan = index+1; scan < list.length; scan++) //recorremos el segemento de la cadena que aun esta desordenado
                if (list[scan].compareTo(list[min]) < 0) //si el valor en el index es mas pequeño que el minimo actual
                min = scan; //dicho valor pasa a ser el nuevo minimo y se guarda su posicion

            // se realiza el intercambio de posicion
            temp = list[min]; //temporal toma el valor en la posicion del minimo
            list[min] = list[index]; //intercambiamos el minimo con el valor
            list[index] = temp; //almacenamos el minimo en su nueva posicion y queda ordenado
        }
    }
    public void insertionSort (Comparable[] list){//sort por insercion
        int position; //iniciamos posicion en 0
        for (int index = 1; index < list.length; index++){ //sorting ordena comparando con izquierda, por lo que se asume que la primera posicion esta ordenada
            Comparable key = list[index]; //almacenamos el valor actual en key
            position = index; //y su index en posicion

            while (position > 0 && key.compareTo(list[position-1]) < 0){ //mientras haya cadena y el numero de la izquierda sea mayor
                list[position] = list[position-1]; //se intercambia posicion con su numero a la izquierda
                position--; //y disminuye el la cantidad de comparaciones
            }
            
            list[position] = key;
        }
    }
 
    static void mergeSort(Comparable[] list) { //sort por union
        if (list.length > 1) { //hasta que la lista sea de un tamaño de 2
            int mid = list.length/2; //encontramos el indice medio

            //dividimos el arreglo en dos, arreglo izquierdoi y derecho
            Comparable[] leftArray = Arrays.copyOfRange(list, 0, mid); 
            Comparable[] rightArray = Arrays.copyOfRange(list, mid, list.length);

            mergeSort(leftArray);
            mergeSort(rightArray);

            merge(list,leftArray,rightArray); //al separar unimos las parejas de arrays
        }
    }

    static void merge(Comparable[] sublist, Comparable[] l,Comparable[] r) { //metodo para unir los arrays
        int totElem = l.length + r.length; //establecemos el tamaño total
        int i = 0,li =0,ri =0; //iniciamos las variables para los indices
        while ( i < totElem) { //mientars hayan posiciones
            if ((li < l.length) && (ri<r.length)) { //ordenamos la sublista dependiendo si el numero del array izquiedo o derecho sea mas grande o mas pequeño
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
        int i = start;                          // index of left-to-right scan
        int k = end;                            // index of right-to-left scan

        if (end - start >= 1)                   // check that there are at least two elements to sort
        {
                Comparable pivot = array[start];       // set the pivot as the first element in the partition

                while (k > i)                   // while the scan indices from left and right have not met,
                {
                        while (array[i].compareTo(pivot) <= 0 && i <= end && k > i)  // from the left, look for the first
                                i++;                                    // element greater than the pivot
                        while (array[k].compareTo(pivot) > 0 && k >= start && k >= i) // from the right, look for the first
                            k--;                                        // element not greater than the pivot
                        if (k > i)                                       // if the left seekindex is still smaller than
                                swap(array, i, k);                      // the right index, swap the corresponding elements
                }
                swap(array, start, k);          // after the indices have crossed, swap the last element in
                                                // the left partition with the pivot 
                quickSort(array, start, k - 1); // quicksort the left partition
                quickSort(array, k + 1, end);   // quicksort the right partition
        }
        else    // if there is only one element in the partition, do not do any sorting
        {
                return;                     // the array is sorted, so exit
        }
    }

    public void swap(Comparable array[], int index1, int index2){
    // pre: array is full and index1, index2 < array.length
    // post: the values at indices 1 and 2 have been swapped
        Comparable temp = array[index1];           // store the first value in a temp
        array[index1] = array[index2];      // copy the value of the second into the first
        array[index2] = temp;               // copy the value of the temp into the second
    }
}
