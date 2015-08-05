/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht3;

import java.util.Random;

/**
 *
 * @author Home
 */
public class Sorting {
    public void setText(){
        
    }
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
    public void insertionSort (Comparable[] list)
    {
      for (int index = 1; index < list.length; index++)
      {
         Comparable key = list[index];
         int position = index;

         //  Shift larger values to the right
         while (position > 0 && key.compareTo(list[position-1]) < 0)
         {
            list[position] = list[position-1];
            position--;
         }
            
         list[position] = key;
      }
   }
    public void quickSort (Comparable [] list){
        
    }
}
