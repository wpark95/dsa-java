package com.algorithms;

import java.util.Arrays;

public class MergeSort {

    public void mergeSort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(int[] array, int start, int end) {
        if (start >= end) { // Explicit Base Case
            return;
        }

        int middle = (end - start) / 2 + start;
        mergeSort(array, start, middle);
        mergeSort(array, middle + 1, end);
        merge(array, start, middle, end);
    }

    private void merge(int[] array, int start, int middle, int end) {
        int i = start; // index of the current item in the first array (initially pointing at the first item)
        int j = middle + 1; // index of the current item in the second array (initially pointing at the first item)
        int[] tempArray = new int[end - start + 1]; // temp array which will be the merged array

        for (int k = 0; k < tempArray.length; k++) {
            // check if both arrays are still active (hasn't reached the end of an array yet)
            if (i <= middle && j <= end)  {
                // if the current item at the first array is smaller than
                // or equal to the current item at the second array
                if (array[i] <= array[j]) {
                    // add the current item of the first array to the temp array
                    // and increment i (pointer for current item of the first array)
                    tempArray[k] = array[i++];
                // otherwise (if the second array's current item is greater than the current item at the first array)
                } else {
                    // add the current item at the second array to the temp array
                    // and increment j (pointer for current item of the second array)
                    tempArray[k] = array[j++];
                }
            // otherwise, end of an array has been reached
            } else {
                // check if the end of the first array has been reached
                if (i > middle) {
                    // since the first array has reached its end,
                    // add the current item at the second array to the temp array
                    // and increment j (pointer for current item of the second array)
                    tempArray[k] = array[j++];
                // otherwise (meaning the end of the second array has been reached)
                } else {
                    // since the second array has reached its end,
                    // add the current item at the first array to the temp array
                    // and increment i (pointer for current item of the first array)
                    tempArray[k] = array[i++];
                }
            }
        }
        // copy the temp array to the input array
        System.arraycopy(tempArray, 0, array, start, tempArray.length);
    }

    public static void main(String[] arge) {
        MergeSort sorter = new MergeSort();
        int[] array = new int[]{4, 5, 33, 17, 3, 21, 1, 16};
        System.out.println("Unsorted:");
        System.out.println(Arrays.toString(array));
//        for (int a : array) {
//            System.out.println(a);
//        }
        sorter.mergeSort(array);
        System.out.println("Sorted:");
        System.out.println(Arrays.toString(array));
//        for (int a : array) {
//            System.out.println(a);
//        }
    }
}
