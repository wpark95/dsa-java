package com.algorithms;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryConvertTest {

    @Test
    public void convertFromBinary_should_return_valid_result_with_valid_input() {
        assertEquals(37, BinaryConvert.convertFromBinary("100101"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void _convertFromBinary_should_throw_IllegalArgumentException_given_input_string_with_non_number_chars() throws IllegalArgumentException {
        BinaryConvert.convertFromBinary("17a");
    }

    @Test(expected = IllegalArgumentException.class)
    public void _convertFromBinary_should_throw_IllegalArgumentException_given_input_string_null() throws IllegalArgumentException {
        BinaryConvert.convertFromBinary(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void _convertFromBinary_should_throw_IllegalArgumentException_given_empty_input_string() throws IllegalArgumentException {
        BinaryConvert.convertFromBinary("");
    }

    @Test
    public void convertFromOctal_should_return_valid_result_with_valid_input() {
        assertEquals(15, BinaryConvert.convertFromOctal("17"));
    }

    @Test
    public void _convertFromOctal_should_throw_IllegalArgumentException_given_octal_string_with_non_number_chars() {
        String badOctalStr = "17a";
        try {
            BinaryConvert.convertFromOctal(badOctalStr);
            fail("Didn't throw exception");
        } catch (IllegalArgumentException ipe) {
            assertEquals("Input contains a non-numeric value", ipe.getMessage());
        }
    }

    @Test
    public void _convertFromOctal_should_throw_IllegalArgumentException_given_octal_string_with_invalid_numeric_values() {
        String badOctalStr = "15942";
        try {
            BinaryConvert.convertFromOctal(badOctalStr);
            fail("Didn't throw exception");
        } catch (IllegalArgumentException ipe) {
            assertEquals("Input contains letter bigger than 7", ipe.getMessage());
        }
    }

    @Test
    public void _convertFromOctal_should_throw_IllegalArgumentException_given_null() {
        try {
            BinaryConvert.convertFromOctal(null);
            fail("Didn't throw exception");
        } catch (IllegalArgumentException ipe) {
            assertEquals("Invalid input string (null or empty)", ipe.getMessage());
        }
    }

    @Test
    public void _convertFromOctal_should_throw_IllegalArgumentException_given_empty_string_input() {
        try {
            BinaryConvert.convertFromOctal("");
            fail("Didn't throw exception");
        } catch (IllegalArgumentException ipe) {
            assertEquals("Invalid input string (null or empty)", ipe.getMessage());
        }
    }

}