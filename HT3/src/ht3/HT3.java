/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht3;

import java.util.Random;
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
        Random rand = new Random();
        Sorting sort = new Sorting();
        Scanner entrada = new Scanner(System.in);
        numbers[] nums;
        int size;
        
        System.out.println("Ingrese el tamaño del arreglo de numeros (min: 10 max: 3000)");
        size = entrada.nextInt();
        nums = new numbers[size];
        for(int x=0; x<size; x++){
            nums[x]=new numbers(rand.nextInt(size+1));
        }
        sort.selectionSort(nums);

        System.out.println("*********Selection Sort*********");
        for(numbers num : nums){
            System.out.println(num);
        }
    }
}
