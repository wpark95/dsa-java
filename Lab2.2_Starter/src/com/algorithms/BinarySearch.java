package com.algorithms;

public class BinarySearch {
    public static boolean binarySearch(int target, int[] sortedArray) {
        if (target < sortedArray[0] || target > sortedArray[sortedArray.length - 1]) {
            throw new IllegalArgumentException("Invalid target: target is not within the range of input array");
        }
        return binarySearch(target, sortedArray, 0, sortedArray.length - 1);
    }

    private static boolean binarySearch(int target, int[] array, int start, int end) {
        // Base Case
        if (end - start < 0) {
            return false;
        }

        // save the middle index of the currently relevant portion of the input array
        int mid = (end - start) / 2 + start;

        // If the target is smaller than the current item at mid
        if (target < array[mid]) {
            // use the left half of the array
            return binarySearch(target, array, start, mid - 1);
        }
        // If the target is greater than the current item at mid
        else if (target > array[mid]) {
            // use the left right of the array
            return binarySearch(target, array, mid + 1, end);
        } else {
            // at this point, array[mid] == target. Therefore, return true
            return true;
        }
    }

    public static void main(String[] args) {
        int[] sorted = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
//        System.out.println(binarySearch(13, sorted)); // Should throw exception
        System.out.println(binarySearch(11, sorted));
        System.out.println(binarySearch(7, sorted));
        System.out.println(binarySearch(1, sorted));
//        System.out.println(binarySearch(0, sorted)); // Should throw exception
    }
}

