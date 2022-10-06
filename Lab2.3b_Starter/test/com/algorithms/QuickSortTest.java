package com.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class QuickSortTest {

    /*
    Quick Sort Test
     */

    @Test
    public void sortPositive() {
        int[] unsortedArray = {3, 7, 2, 15, 8, 4, 6, 5, 1};
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 15};
        new QuickSort().sort(unsortedArray);
        for (int a=0; a<unsortedArray.length; a++){
            assertEquals(sortedArray[a], unsortedArray[a]);
        }
    }

    @Test
    public void sortDupPivotPositive() {
        int[] unsortedArray = {3, 7, 2, 15, 8, 1, 4, 6, 5, 1};
        int[] sortedArray = {1, 1, 2, 3, 4, 5, 6, 7, 8, 15};
        new QuickSort().sort(unsortedArray);
        for (int a=0; a<unsortedArray.length; a++){
            assertEquals(sortedArray[a], unsortedArray[a]);
        }
    }

    @Test
    public void sortAnyDupPositive() {
        int[] unsortedArray = {3, 7, 2, 15, 8, 7, 4, 6, 5, 1};
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 7, 8, 15};
        new QuickSort().sort(unsortedArray);
        for (int a=0; a<unsortedArray.length; a++){
            assertEquals(sortedArray[a], unsortedArray[a]);
        }
    }

    @Test
    public void sortNullArrayNegative() {
        int[] unsortedArray = null;
        new QuickSort().sort(unsortedArray);
        try{
            new QuickSort().sort(unsortedArray);
        }
        catch (Exception e){
            fail("Exception thrown");
        }
    }
    
    @Test
    public void sortEmptyArrayNegative() {
        int[] unsortedArray = {};
        new QuickSort().sort(unsortedArray);
        try{
            new QuickSort().sort(unsortedArray);
        }
        catch (Exception e){
            fail("Exception thrown");
        }
    }

    /*
    Partition Test
     */

    @Test
    public void partitionPositive() {
        int[] array = {2, 5, 4, 1, 3};
        int expectedPivot = 3;
        Partition.partition(array, 0, 4);
        assertEquals(expectedPivot, array[2]);
    }

    @Test
    public void partitionPositiveSortedIncreasing() {
        int[] array = {1, 2, 3, 4, 5};
        int expectedPivotIndex = 4;
        int expectedPivotValue = 5;
        int partition = Partition.partition(array, 0, 4);
        assertEquals(expectedPivotIndex, partition);
        assertEquals(expectedPivotValue, array[partition]);
    }

    @Test
    public void partitionPositiveSortedDecreasing() {
        int[] array = {5, 4, 3, 2, 1};
        int expectedPivot = 1;
        Partition.partition(array, 0, 4);
        assertEquals(expectedPivot, array[0]);
    }

    @Test
    public void partitionPositiveNegativePivot() {
        int[] array = {2, 5, 4, 1, -3};
        int expectedPivot = -3;
        Partition.partition(array, 0, 4);
        assertEquals(expectedPivot, array[0]);
    }

    @Test (expected = InvalidParameterException.class)
    public void partitionNegativeNullArray(){
        int[] array = null;
        Partition.partition(array, 0, 0);
    }

    @Test (expected = InvalidParameterException.class)
    public void partitionNegativeEmptyArray(){
        int[] array = {};
        Partition.partition(array, 0, 0);
    }

    @Test
    public void partitionSingleElementPositive(){
        int expected = 0;
        int[] providedArray = {5};
        int actual = Partition.partition(providedArray, 0, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void swap2ElementArrayPositive() {
        int[] array = {2, 5};
        int expected1 = 2;
        int expected2 = 5;
        Partition.swap(array, 0, 1);
        int actual1 = array[1];
        assertEquals(expected1, actual1);
        int actual2 = array[0];
        assertEquals(expected2, actual2);
    }

    @Test
    public void swap1ElementArrayPositive() {
        int[] array = {5};
        int expected1 = 5;
        Partition.swap(array, 0, 0);
        int actual1 = array[0];
        assertEquals(expected1, actual1);
    }

    @Test
    public void swapEmptyArrayNegative() {
        int[] array = {};
        Partition.swap(array, 0, 0);
    }

    @Test
    public void swapNullArrayNegative() {
        int[] array = null;
        Partition.swap(array, 0, 0);
    }

}