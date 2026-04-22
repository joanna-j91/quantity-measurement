package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testFeetEquality() {
        Length f1 = new Length(1.0, Length.LengthUnit.FEET);
        Length f2 = new Length(1.0, Length.LengthUnit.FEET);
        assertTrue(f1.equals(f2));
    }

    @Test
    public void testFeetInequality() {
        Length f1 = new Length(1.0, Length.LengthUnit.FEET);
        Length f2 = new Length(2.0, Length.LengthUnit.FEET);
        assertFalse(f1.equals(f2));
    }

    @Test
    public void testInchesEquality() {
        Length i1 = new Length(1.0, Length.LengthUnit.INCHES);
        Length i2 = new Length(1.0, Length.LengthUnit.INCHES);
        assertTrue(i1.equals(i2));
    }

    @Test
    public void testInchesInequality() {
        Length i1 = new Length(1.0, Length.LengthUnit.INCHES);
        Length i2 = new Length(2.0, Length.LengthUnit.INCHES);
        assertFalse(i1.equals(i2));
    }

    @Test
    public void testFeetInchesComparison() {
        Length oneFoot  = new Length(1.0,  Length.LengthUnit.FEET);
        Length twelveIn = new Length(12.0, Length.LengthUnit.INCHES);
        assertTrue(oneFoot.equals(twelveIn), "1 foot should equal 12 inches");
    }

    @Test
    public void testCrossUnitInequality() {
        Length oneFoot = new Length(1.0, Length.LengthUnit.FEET);
        Length oneInch = new Length(1.0, Length.LengthUnit.INCHES);
        assertFalse(oneFoot.equals(oneInch), "1 foot should not equal 1 inch");
    }

    @Test
    public void testNullComparison() {
        Length l = new Length(1.0, Length.LengthUnit.FEET);
        assertFalse(l.equals(null));
    }

    @Test
    public void testSameReference() {
        Length l = new Length(1.0, Length.LengthUnit.FEET);
        assertTrue(l.equals(l));
    }

    @Test
    public void testMultipleFeetComparison() {
        Length f1 = new Length(2.0, Length.LengthUnit.FEET);  // = 24 inches
        Length f2 = new Length(24.0, Length.LengthUnit.INCHES);
        assertTrue(f1.equals(f2), "2 feet should equal 24 inches");
    }
}