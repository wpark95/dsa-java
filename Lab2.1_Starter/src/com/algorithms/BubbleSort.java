package com.algorithms;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args){
       int[] input = {4, 15, 2, 6, 9, 22, 13};
       System.out.println(Arrays.toString(input));
       sort(input);
       System.out.println(Arrays.toString(input));
    }

    /*
    bubbleSort(array)
       n = length(array)
       for (k = 1 until n)
         for (j = 0 until length-1)
           if(array[j] > array[j + 1])
             swap(array, j, j + 1)
    */
    public static void sort(int[] numbers) {
        // the length of the input array numbers
        int n = numbers.length;

        // iterate over the input array numbers
        for (int k = 0; k < n - 1; k++) {
            // for each item (number), iterate over the rest of the unsorted array,
            // where the length of the unsorted array will gradually decrement
            // per iteration because the last iterated item will be in its correct place
            for (int j = 0; j < n - k - 1; j++) {
                // compare if current number is bigger than the next number
                // and if so, swap their places accordingly
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }

}
