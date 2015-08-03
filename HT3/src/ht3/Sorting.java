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
    private int [] numbers;
    private int size;
    
    
    public void setSize(int size){
        this.size = size;
    }
    public int getSize(){
        return this.size;
    }
    
    public void fill(){
        Random num = new Random();
        numbers = new int[this.size];
        for(int x = 0; x < this.size; x++){
            numbers[x] = num.nextInt(this.size+1);
        }
    }
    
    public int[] selectionSort() {
        int i, j, minIndex, tmp;
        int n = this.size;
        for (i = 0; i < n - 1; i++) {
            minIndex = i;
            for (j = i + 1; j < n; j++)
                if (numbers[j] < numbers[minIndex])
                    minIndex = j;
            if (minIndex != i) {
                tmp = numbers[i];
                numbers[i] = numbers[minIndex];
                numbers[minIndex] = tmp;
            }
        }
        return numbers;
    }
}
