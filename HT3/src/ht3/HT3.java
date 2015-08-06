/* *******************************************************
 * Gabriel Martinez 14070
 * Arturo Garcia 14186
 * Marcos Benedict 14368
 *
 * *******************************************************
 * El proposito de este programa es ofrecer un acercamiento
 * hacia las formas de sorting y compararlas por medio de su
 * big O().
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
    //insertion o(n2)
    public static void main(String[] args) { //iniciamos nuestro metodo main 
        Random rand = new Random(); //implementamos un objeto Random para asignar los valores aleatorios
        Sorting sort = new Sorting(); //implementamos la clase Sorting
        Scanner entrada = new Scanner(System.in); //implementamos Scanner para recibir datos
        numbers[][] nums; //se implementa una matriz de numeros, pero no se define su tamaño
        int size = 0; //variable que almacena el parametro del usuario
        boolean condicion = true;
        
        while(condicion){
            System.out.println("Ingrese el tamaño del arreglo de numeros (min: 10 max: 3000)");
            size = entrada.nextInt(); //se pide la variable al usuario
            if(size >=10 && size <=3000){ //si la entrada del usuario esta dentro del rango
                condicion = false; //sale del bucle y continua con el sorting
            }
        }
            nums = new numbers[4][size]; //creamos nuestro arreglo de numeros
            for(int x=0; x<4; x++){
                for(int y=0; y<size; y++){
                    nums[x][y]=new numbers(rand.nextInt(size+1)); //llenamos la matriz de datos aleatorios
                }
            }
        sort.selectionSort(nums[0]); //ordenamos el primer array por selection sort
        sort.insertionSort(nums[1]); //ordenamos el segundo array por insertion sort
        sort.mergeSort(nums[2]); //ordenamos el tercer array por merge sort
        sort.quickSort(nums[3], 0, size-1); //ordenamos el cuarto array por quick sort

        System.out.println("*********Selection Sort*********");
        for(numbers num : nums[0]){
            System.out.println(num); //imprimimos el resultado del sort
        }
        
        System.out.println("*********Insertion Sort*********");
        for(numbers num : nums[1]){
            System.out.println(num); //imprimimos el resultado del sort
        }
        
        System.out.println("***********Merge Sort***********");
        for(numbers num : nums[2]){
            System.out.println(num); //imprimimos el resultado del sort
        }
        
        System.out.println("***********Quick Sort***********");
        for(numbers num : nums[3]){
            System.out.println(num); //imprimimos el resultado del sort
        }
    }
}
