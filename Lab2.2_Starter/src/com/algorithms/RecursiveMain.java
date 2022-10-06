package com.algorithms;

public class RecursiveMain {

    public static void main(String[] args) {
        int recursiveStartingCounter = 4000;
        new Hello().hello(recursiveStartingCounter);
    }

}

class Hello {

    public void hello(int counter) {    // recurring argument
        System.out.println(counter + ": hello");
        if (counter < 0) {              // base condition
            return;
        }
        hello(--counter);
    }

}