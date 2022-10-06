package com.algorithms;

public class BinaryConvert {
    public static void main(String[] args) {
        int number = convertFromBinary("100101");
        System.out.println("Number for binary 100101: " + number);
        number = convertFromOctal("17");
        System.out.println("Number for octal 17: " + number);
    }

    public static int convertFromBinary(String binary) {
        if (binary == null || binary.length() == 0) {
            throw new IllegalArgumentException("Invalid input string (null or empty)");
        }
        int conversion = 1;
        int result = 0;

        for (int i = binary.length() - 1; i >= 0; i--) {
            if (!(binary.charAt(i) == '1') && !(binary.charAt(i) == '0')) {
                throw new IllegalArgumentException("Input you provided contains letters other than 0 and 1");
            }
            if (binary.charAt(i) == '1') {
                result += conversion;
            }
            conversion *= 2;
        }

        return result;
    }

    public static int convertFromOctal(String octal) {
        if (octal == null || octal.length() == 0) {
            throw new IllegalArgumentException("Invalid input string (null or empty)");
        }
        int conversion = 1;
        int result = 0;
        for (int i = octal.length()-1; i>=0; i-- ) {
            char c = octal.charAt(i);
            int num;

            try {
                num = Integer.parseInt(Character.toString(c));
            } catch(Exception e) {
                throw new NumberFormatException("Input contains a non-numeric value");
            }

            if (num > 7) {
                throw new IllegalArgumentException("Input contains letter bigger than 7");
            }

            result += num*conversion;
            conversion *= 8;
        }
        return result;
    }
}
