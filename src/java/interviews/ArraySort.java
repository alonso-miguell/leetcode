package interviews;

import java.util.Arrays;

public class ArraySort {
    /*
        Sort a giving array in ascending order
     */

    public static void main(String[] args) {
        int[] arrayInt = {10, 60, 5, 40, 3, 0};

//        int[] sortedArray=bubbleSort(arrayInt);
        int[] sortedArray=bruteForceSort(arrayInt);


        System.out.println(Arrays.toString(sortedArray));

//        for (int a : sortedArray) {
//            System.out.println(a);
//        }

    }

    static int[] bruteForceSort(int[] array){
        int[] sortedArray=array;

        //Simplest way to do it finding the smallest in each iteration

        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[j]<array[i]){
                    int temp=array[i];
                    sortedArray[i]=array[j];
                    sortedArray[j]=temp;
                }
            }
        }

        return sortedArray;
    }

    static int[] bubbleSort(int[] array){
        int[] sortedArray=array;

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length-i-1; j++) {
//                System.out.println("j: "+j+" = "+array[j]);

                if(array[j+1]<array[j]){
                    int temp=array[j+1];
                    sortedArray[j+1]=sortedArray[j];
                    sortedArray[j]=temp;
                }

            }
        }

        return sortedArray;
    }

}
