package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    private static final double EPSILON = 1e-6;

    @Test public void testFeetEquality() {
        assertTrue(new Length(1.0, Length.LengthUnit.FEET).equals(new Length(1.0, Length.LengthUnit.FEET)));
    }
    @Test public void testFeetInequality() {
        assertFalse(new Length(1.0, Length.LengthUnit.FEET).equals(new Length(2.0, Length.LengthUnit.FEET)));
    }
    @Test public void testInchesEquality() {
        assertTrue(new Length(1.0, Length.LengthUnit.INCHES).equals(new Length(1.0, Length.LengthUnit.INCHES)));
    }
    @Test public void testFeetInchesComparison() {
        assertTrue(new Length(1.0, Length.LengthUnit.FEET).equals(new Length(12.0, Length.LengthUnit.INCHES)));
    }
    @Test public void testNullComparison() {
        assertFalse(new Length(1.0, Length.LengthUnit.FEET).equals(null));
    }
    @Test public void testSameReference() {
        Length l = new Length(1.0, Length.LengthUnit.FEET);
        assertTrue(l.equals(l));
    }

    @Test public void testYardToFeet() {
        assertTrue(new Length(1.0, Length.LengthUnit.YARDS).equals(new Length(3.0, Length.LengthUnit.FEET)));
    }
    @Test public void testYardToInches() {
        assertTrue(new Length(1.0, Length.LengthUnit.YARDS).equals(new Length(36.0, Length.LengthUnit.INCHES)));
    }
    @Test public void testCentimetersToInches() {
        assertTrue(new Length(1.0, Length.LengthUnit.CENTIMETERS).equals(new Length(0.393701, Length.LengthUnit.INCHES)));
    }

    @Test
    public void testConversion_FeetToInches() {
        assertEquals(12.0, Length.convert(1.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES), EPSILON);
    }

    @Test
    public void testConversion_InchesToFeet() {
        assertEquals(2.0, Length.convert(24.0, Length.LengthUnit.INCHES, Length.LengthUnit.FEET), EPSILON);
    }

    @Test
    public void testConversion_YardsToInches() {
        assertEquals(36.0, Length.convert(1.0, Length.LengthUnit.YARDS, Length.LengthUnit.INCHES), EPSILON);
    }

    @Test
    public void testConversion_InchesToYards() {
        assertEquals(2.0, Length.convert(72.0, Length.LengthUnit.INCHES, Length.LengthUnit.YARDS), EPSILON);
    }

    @Test
    public void testConversion_CentimetersToInches() {
        assertEquals(1.0, Length.convert(2.54, Length.LengthUnit.CENTIMETERS, Length.LengthUnit.INCHES), 0.01);
    }

    @Test
    public void testConversion_FeetToYards() {
        assertEquals(2.0, Length.convert(6.0, Length.LengthUnit.FEET, Length.LengthUnit.YARDS), EPSILON);
    }

    @Test
    public void testConversion_ZeroValue() {
        assertEquals(0.0, Length.convert(0.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES), EPSILON);
    }

    @Test
    public void testConversion_NegativeValue() {
        assertEquals(-12.0, Length.convert(-1.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES), EPSILON);
    }

    @Test
    public void testConversion_SameUnit() {
        assertEquals(5.0, Length.convert(5.0, Length.LengthUnit.FEET, Length.LengthUnit.FEET), EPSILON);
    }

    @Test
    public void testConversion_RoundTrip_PreservesValue() {
        double original = 3.0;
        double converted = Length.convert(original, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);
        double backToFeet = Length.convert(converted, Length.LengthUnit.INCHES, Length.LengthUnit.FEET);
        assertEquals(original, backToFeet, EPSILON);
    }

    @Test
    public void testConversion_InvalidUnit_Throws() {
        assertThrows(IllegalArgumentException.class, () ->
                Length.convert(1.0, null, Length.LengthUnit.INCHES));
        assertThrows(IllegalArgumentException.class, () ->
                Length.convert(1.0, Length.LengthUnit.FEET, null));
    }

    @Test
    public void testConversion_NaNValue_Throws() {
        assertThrows(IllegalArgumentException.class, () ->
                Length.convert(Double.NaN, Length.LengthUnit.FEET, Length.LengthUnit.INCHES));
    }

    @Test
    public void testConversion_InfiniteValue_Throws() {
        assertThrows(IllegalArgumentException.class, () ->
                Length.convert(Double.POSITIVE_INFINITY, Length.LengthUnit.FEET, Length.LengthUnit.INCHES));
    }

    @Test
    public void testConversion_PrecisionTolerance() {
        double result = Length.convert(1.0, Length.LengthUnit.CENTIMETERS, Length.LengthUnit.INCHES);
        assertEquals(0.393701, result, EPSILON);
    }

    @Test
    public void testConvertTo_InstanceMethod() {
        Length oneYard = new Length(1.0, Length.LengthUnit.YARDS);
        Length inInches = oneYard.convertTo(Length.LengthUnit.INCHES);
        assertEquals(36.0, Length.convert(1.0, Length.LengthUnit.YARDS, Length.LengthUnit.INCHES), EPSILON);
        assertTrue(inInches.equals(new Length(36.0, Length.LengthUnit.INCHES)));
    }

    @Test
    public void testConstructor_NullUnit_Throws() {
        assertThrows(IllegalArgumentException.class, () ->
                new Length(1.0, null));
    }
}