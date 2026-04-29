package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testFeetEquality() {
        assertTrue(new Length(1.0, Length.LengthUnit.FEET)
                .equals(new Length(1.0, Length.LengthUnit.FEET)));
    }

    @Test
    public void testFeetInequality() {
        assertFalse(new Length(1.0, Length.LengthUnit.FEET)
                .equals(new Length(2.0, Length.LengthUnit.FEET)));
    }

    @Test
    public void testInchesEquality() {
        assertTrue(new Length(1.0, Length.LengthUnit.INCHES)
                .equals(new Length(1.0, Length.LengthUnit.INCHES)));
    }

    @Test
    public void testInchesInequality() {
        assertFalse(new Length(1.0, Length.LengthUnit.INCHES)
                .equals(new Length(2.0, Length.LengthUnit.INCHES)));
    }

    @Test
    public void testFeetInchesComparison() {
        assertTrue(new Length(1.0, Length.LengthUnit.FEET)
                .equals(new Length(12.0, Length.LengthUnit.INCHES)));
    }

    @Test
    public void testCrossUnitInequality() {
        assertFalse(new Length(1.0, Length.LengthUnit.FEET)
                .equals(new Length(1.0, Length.LengthUnit.INCHES)));
    }

    @Test
    public void testNullComparison() {
        assertFalse(new Length(1.0, Length.LengthUnit.FEET).equals(null));
    }

    @Test
    public void testSameReference() {
        Length l = new Length(1.0, Length.LengthUnit.FEET);
        assertTrue(l.equals(l));
    }

    @Test
    public void testMultipleFeetComparison() {
        assertTrue(new Length(2.0, Length.LengthUnit.FEET)
                .equals(new Length(24.0, Length.LengthUnit.INCHES)));
    }


    @Test
    public void testEquality_YardToYard_SameValue() {
        assertTrue(new Length(1.0, Length.LengthUnit.YARDS)
                .equals(new Length(1.0, Length.LengthUnit.YARDS)));
    }

    @Test
    public void testEquality_YardToYard_DifferentValue() {
        assertFalse(new Length(1.0, Length.LengthUnit.YARDS)
                .equals(new Length(2.0, Length.LengthUnit.YARDS)));
    }

    @Test
    public void testEquality_YardToFeet_EquivalentValue() {
        assertTrue(new Length(1.0, Length.LengthUnit.YARDS)
                .equals(new Length(3.0, Length.LengthUnit.FEET)));
    }

    @Test
    public void testEquality_FeetToYard_EquivalentValue() {
        assertTrue(new Length(3.0, Length.LengthUnit.FEET)
                .equals(new Length(1.0, Length.LengthUnit.YARDS)));
    }

    @Test
    public void testEquality_YardToInches_EquivalentValue() {
        assertTrue(new Length(1.0, Length.LengthUnit.YARDS)
                .equals(new Length(36.0, Length.LengthUnit.INCHES)));
    }

    @Test
    public void testEquality_InchesToYard_EquivalentValue() {
        assertTrue(new Length(36.0, Length.LengthUnit.INCHES)
                .equals(new Length(1.0, Length.LengthUnit.YARDS)));
    }

    @Test
    public void testEquality_YardToFeet_NonEquivalentValue() {
        assertFalse(new Length(1.0, Length.LengthUnit.YARDS)
                .equals(new Length(2.0, Length.LengthUnit.FEET)));
    }

    @Test
    public void testEquality_YardSameReference() {
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        assertTrue(yard.equals(yard));
    }

    @Test
    public void testEquality_YardNullComparison() {
        assertFalse(new Length(1.0, Length.LengthUnit.YARDS).equals(null));
    }


    @Test
    public void testEquality_centimetersToInches_EquivalentValue() {
        assertTrue(new Length(1.0, Length.LengthUnit.CENTIMETERS)
                .equals(new Length(0.393701, Length.LengthUnit.INCHES)));
    }

    @Test
    public void testEquality_centimetersToFeet_NonEquivalentValue() {
        assertFalse(new Length(1.0, Length.LengthUnit.CENTIMETERS)
                .equals(new Length(1.0, Length.LengthUnit.FEET)));
    }

    @Test
    public void testEquality_CentimetersSameValue() {
        assertTrue(new Length(2.0, Length.LengthUnit.CENTIMETERS)
                .equals(new Length(2.0, Length.LengthUnit.CENTIMETERS)));
    }

    @Test
    public void testEquality_CentimetersDifferentValue() {
        assertFalse(new Length(1.0, Length.LengthUnit.CENTIMETERS)
                .equals(new Length(2.0, Length.LengthUnit.CENTIMETERS)));
    }

    @Test
    public void testEquality_CentimetersSameReference() {
        Length cm = new Length(1.0, Length.LengthUnit.CENTIMETERS);
        assertTrue(cm.equals(cm));
    }

    @Test
    public void testEquality_CentimetersNullComparison() {
        assertFalse(new Length(1.0, Length.LengthUnit.CENTIMETERS).equals(null));
    }


    @Test
    public void testEquality_MultiUnit_TransitiveProperty() {
        Length oneYard    = new Length(1.0,  Length.LengthUnit.YARDS);
        Length threeFeet  = new Length(3.0,  Length.LengthUnit.FEET);
        Length thirtySix  = new Length(36.0, Length.LengthUnit.INCHES);
        assertTrue(oneYard.equals(threeFeet));
        assertTrue(threeFeet.equals(thirtySix));
        assertTrue(oneYard.equals(thirtySix));
    }

    @Test
    public void testEquality_AllUnits_ComplexScenario() {
        Length twoYards    = new Length(2.0,  Length.LengthUnit.YARDS);
        Length sixFeet     = new Length(6.0,  Length.LengthUnit.FEET);
        Length seventyTwo  = new Length(72.0, Length.LengthUnit.INCHES);
        assertTrue(twoYards.equals(sixFeet));
        assertTrue(sixFeet.equals(seventyTwo));
        assertTrue(twoYards.equals(seventyTwo));
    }
}