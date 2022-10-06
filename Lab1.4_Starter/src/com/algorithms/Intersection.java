package com.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Intersection {

    public List<Integer> intersection(int[] a, int[] b) {
        List<Integer> result = new ArrayList<>(a.length);
        for (int x : a) {
            for (int y : b) {
                if (x == y) result.add(x);
            }
        }
        return result;
    }

	public List<Integer> intersectionFast(int[]a, int[]b){
        List<Integer> intersectingNumbers = new ArrayList<>();
        // Sort the input arrays
        Arrays.sort(a);
        Arrays.sort(b);
        int aIndex = 0;
        int bIndex = 0;

        while (aIndex < a.length && bIndex < b.length) {
            // if matching number is found, add it to the intersecting numbers list and increment both A and B indexes
            if (a[aIndex] == b[bIndex]) {
                intersectingNumbers.add(a[aIndex]);
                aIndex++;
                bIndex++;
            // if the current number in A is smaller than the current number in B
            } else if (a[aIndex] < b[bIndex]) {
                // increment A index
                aIndex++;
            // else (if the current number in B is smaller than the current number in A)
            } else {
                // increment B index
                bIndex++;
            }
        }
        // return the matching numbers list
        return intersectingNumbers;
	}

    public static void main(String args[]) {
        Intersection simpleIntersection = new Intersection();
//        System.out.println(simpleIntersection.intersection(new int[]{4, 7, 5, 2, 3}, new int[]{4, 2, 3, 9, 1}));
//        System.out.println("result = " + simpleIntersection.intersectionFast(new int[]{4, 7, 5, 2, 3}, new int[]{4, 2, 3, 9, 1}));
        System.out.println(simpleIntersection.intersectionFast(new int[]{1,2,3,4,20}, new int[]{5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20}));
    }
}
