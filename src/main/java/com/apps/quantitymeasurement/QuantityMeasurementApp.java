package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static boolean demonstrateLengthEquality(Length length1, Length length2) {
        boolean result = length1.equals(length2);
        System.out.println(length1 + " == " + length2 + " ? " + result);
        return result;
    }

    public static void demonstrateFeetEquality() {
        Length feet1 = new Length(1.0, Length.LengthUnit.FEET);
        Length feet2 = new Length(1.0, Length.LengthUnit.FEET);
        demonstrateLengthEquality(feet1, feet2);
    }

    public static void demonstrateInchesEquality() {
        Length inches1 = new Length(1.0, Length.LengthUnit.INCHES);
        Length inches2 = new Length(1.0, Length.LengthUnit.INCHES);
        demonstrateLengthEquality(inches1, inches2);
    }

    public static void demonstrateFeetInchesComparison() {
        Length oneFoot  = new Length(1.0,  Length.LengthUnit.FEET);
        Length twelveIn = new Length(12.0, Length.LengthUnit.INCHES);
        demonstrateLengthEquality(oneFoot, twelveIn);
    }

    public static void demonstrateYardsEquality() {
        Length oneYard  = new Length(1.0, Length.LengthUnit.YARDS);
        Length threeFt  = new Length(3.0, Length.LengthUnit.FEET);
        Length thirtySixIn = new Length(36.0, Length.LengthUnit.INCHES);
        demonstrateLengthEquality(oneYard, threeFt);
        demonstrateLengthEquality(oneYard, thirtySixIn);
    }

    public static void demonstrateCentimetersEquality() {
        Length oneCm   = new Length(1.0,      Length.LengthUnit.CENTIMETERS);
        Length inchEq  = new Length(0.393701, Length.LengthUnit.INCHES);
        demonstrateLengthEquality(oneCm, inchEq);
    }

    public static void main(String[] args) {
        demonstrateFeetEquality();
        demonstrateInchesEquality();
        demonstrateFeetInchesComparison();
        demonstrateYardsEquality();
        demonstrateCentimetersEquality();
    }
}