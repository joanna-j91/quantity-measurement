package com.apps.quantitymeasurement;


public class QuantityMeasurementApp {

    public static boolean demonstrateLengthEquality(Length length1, Length length2) {
        boolean result = length1.equals(length2);
        System.out.println(length1 + " == " + length2 + " ? " + result);
        return result;
    }


    public static double demonstrateLengthConversion(double value,
                                                     Length.LengthUnit fromUnit,
                                                     Length.LengthUnit toUnit) {
        double result = Length.convert(value, fromUnit, toUnit);
        System.out.printf("convert(%.4f %s → %s) = %.6f%n",
                value, fromUnit.name(), toUnit.name(), result);
        return result;
    }


    public static Length demonstrateLengthConversion(Length length,
                                                     Length.LengthUnit targetUnit) {
        Length result = length.convertTo(targetUnit);
        System.out.println(length + " converted to " + targetUnit.name() + " = " + result);
        return result;
    }


    public static void demonstrateLengthComparison(double value1, Length.LengthUnit unit1,
                                                   double value2, Length.LengthUnit unit2) {
        Length l1 = new Length(value1, unit1);
        Length l2 = new Length(value2, unit2);
        demonstrateLengthEquality(l1, l2);
    }

    public static void main(String[] args) {
        System.out.println("=== Conversion Demo (raw values) ===");
        demonstrateLengthConversion(1.0,  Length.LengthUnit.FEET,        Length.LengthUnit.INCHES);
        demonstrateLengthConversion(3.0,  Length.LengthUnit.YARDS,       Length.LengthUnit.FEET);
        demonstrateLengthConversion(36.0, Length.LengthUnit.INCHES,      Length.LengthUnit.YARDS);
        demonstrateLengthConversion(1.0,  Length.LengthUnit.CENTIMETERS, Length.LengthUnit.INCHES);
        demonstrateLengthConversion(0.0,  Length.LengthUnit.FEET,        Length.LengthUnit.INCHES);

        System.out.println("\n=== Conversion Demo (Length instance) ===");
        Length lengthInYards = new Length(1.0, Length.LengthUnit.YARDS);
        demonstrateLengthConversion(lengthInYards, Length.LengthUnit.INCHES);

        System.out.println("\n=== Equality Demo ===");
        demonstrateLengthComparison(1.0, Length.LengthUnit.FEET,  12.0, Length.LengthUnit.INCHES);
        demonstrateLengthComparison(1.0, Length.LengthUnit.YARDS,  3.0, Length.LengthUnit.FEET);
    }
}