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
        numbers[][] nums;
        int size;
        
        System.out.println("Ingrese el tamaño del arreglo de numeros (min: 10 max: 3000)");
        size = entrada.nextInt();
        nums = new numbers[4][size];
        for(int x=0; x<4; x++){
            for(int y=0; y<size; y++){
                nums[x][y]=new numbers(rand.nextInt(size+1));
            }
        }
        sort.selectionSort(nums[0]);
        sort.insertionSort(nums[1]);

        System.out.println("*********Selection Sort*********");
        for(numbers num : nums[0]){
            System.out.println(num);
        }
        
        System.out.println("*********Insertion Sort*********");
        for(numbers num : nums[1]){
            System.out.println(num);
        }
    }
}
