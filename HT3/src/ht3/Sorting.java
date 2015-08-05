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
