package com.algorithms;

public class BinaryConvert {

    public static final int CONVERSION_NUMBER_BASE_OF = 2;

    public static void main(String[] args){
        int number = convertFromBinary("100101");
        System.out.println("Number for binary 100101: " + number);
    }

    public static int convertFromBinary(String binaryString) {
        int result = 0;
        int conversion = 1;

        // for-loop - start from the bottom of the string
        for (int i = binaryString.length() - 1; i >= 0; i--) {
            // - get the last character, and check if it is 1 or not
            int num = Integer.parseInt(String.valueOf(binaryString.charAt(i)));
            if (num == 1) {
                // - if it is 1, compute value of that digit with the conversion
                num = num * conversion;
                // - add it to the result
                result = result + num;
            }
            // - change the conversion by the power of 2
            conversion *= CONVERSION_NUMBER_BASE_OF;
        }
        return result;
    }

}
