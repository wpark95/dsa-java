package com.algorithms;

import java.util.HashMap;

public class BinaryConvert {

    public static final int OCTAL_CONVERSION_BASE = 8;

    public static void main(String[] args){
        int number = convertFromBinary("100101");
        System.out.println("Number for binary 100101: " + number);
        number = convertOctalStringToDecimalValue("17");
        System.out.println("Number for octal 17: " + number);
        System.out.println(convertStringToDecimalValue("4040", 16));
//        System.out.println(convertStringToDecimalValue("1!", 40)); // 1! = 1 * 40 + ! = 81
    }

    public static int convertFromBinary(String binary){
        int conversion = 1;
        int result = 0;
        /*
        for (int i = 1; i <= binary.length(); i++) {
            if (binary.charAt(binary.length() - i) == '1')
                result += conversion;
            conversion *= 2;
        }
        */
        // this could be a preferred solution: decrement from last element
        for (int i = binary.length()-1; i>=0; i-- ){
//            System.out.println("i is " + i);
            if (binary.charAt(i) == '1'){
                result += conversion;
            }
            conversion *= 2;
        }
        return result;
    }

    public static int convertOctalStringToDecimalValue(String octalString) {
        int result = 0;
        int conversion = 1;

        // for-loop - start from the bottom of the string
        for (int i = octalString.length() - 1; i >= 0; i--) {
            // - get the last character, and check if it is not 0
            int num = Character.getNumericValue(octalString.charAt(i));
            if (num > 0) {
                // - if it is not 0, compute value of that digit with the conversion
                num = num * conversion;
                // - add it to the result
                result += num;
            }
            // - change the conversion by the power of 8
            conversion *= OCTAL_CONVERSION_BASE;
        }
        return result;
    }

    // TODO: NOT TO DO :( THIS IS OUR OWN IMPLEMENTATION (CAN SUPPORT bases over 36)
    // "numberBase" argument could be 2,8,10,16 to represent
    // binary, octal, decimal, and hexa-decimal respectively
    public static int convertStringToDecimalValue(String toBeConverted, int numberBase) {
        int decimalValueResult = 0;
        int conversion = 1;
        // create an empty hashmap to store non-numeric values for hexadecimal strings
        HashMap<Character, Integer> hexadecimalNonNumerics = new HashMap<>();
        // only insert values if the numberBase is over 35
        if (numberBase > 35) {
            hexadecimalNonNumerics = new HashMap<>() {{
                put('^', 36);
                put('&', 37);
                put('*', 38);
                put('(', 39);
                put(')', 40);
                put('!', 41);
            }};
        }

        // for-loop - start from the bottom of the string
        for (int i = toBeConverted.length() - 1; i >= 0; i--) {
            // get the last character of toBeConverted
            char c = toBeConverted.charAt(i);
            // current digit's decimal value (initially 0)
            int num = 0;
            // if numberBase is 16 and the non-numerics map contains the current character as a key
            if (numberBase > 35 && hexadecimalNonNumerics.containsKey(c)) {
                // assign its value to num
                num = hexadecimalNonNumerics.get(c);
            // if numberBase is not 16 or non-numerics map does not have the current character as a key
            } else {
                // assign the current character's numeric value
                num = Character.getNumericValue(c);
            }
            // - get the last character, and check if it is not 0
            if (num > 0) {
                // - if it is not 0, compute value of that digit with the conversion
                num = num * conversion;
                // - add it to the result
                decimalValueResult += num;
            }
            // - change the conversion by the power of numberBase
            conversion *= numberBase;
        }
        return decimalValueResult;
    }

//    // "numberBase" argument could be 2,8,10,16 to represent
//    // binary, octal, decimal, and hexa-decimal respectively
//    public static int convertStringToDecimalValue(String toBeConverted, int numberBase) {
//        int decimalResult = 0;
//        int conversion = 1;
//
//        // for-loop - start from the bottom of the string
//        for (int i = toBeConverted.length() - 1; i >= 0; i--) {
//            // - get the last character, convert it to a numeric value (can parse upto base 36)
//            // and check if it is not 0
//            int currCharValue = Character.getNumericValue(toBeConverted.charAt(i));
//            if (currCharValue > 0) {
//                // - if num is not 0, compute decimal value of that digit using the conversion value
//                currCharValue = currCharValue * conversion;
//                // - add converted decimal value to the result
//                decimalResult += currCharValue;
//            }
//            // - change the conversion by the power of numberBase
//            conversion *= numberBase;
//        }
//        return decimalResult;
//    }

}
