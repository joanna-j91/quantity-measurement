package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        boolean result = l1.equals(l2);
        System.out.println(l1 + " == " + l2 + " ? " + result);
        return result;
    }

    public static double demonstrateLengthConversion(double value,
                                                     Length.LengthUnit from,
                                                     Length.LengthUnit to) {
        double result = Length.convert(value, from, to);
        System.out.printf("convert(%.4f %s → %s) = %.6f%n", value, from.name(), to.name(), result);
        return result;
    }

    public static Length demonstrateLengthConversion(Length length, Length.LengthUnit targetUnit) {
        Length result = length.convertTo(targetUnit);
        System.out.println(length + " → " + targetUnit.name() + " = " + result);
        return result;
    }

    public static Length demonstrateLengthAddition(Length l1, Length l2) {
        Length result = l1.add(l2);
        System.out.println(l1 + " + " + l2 + " = " + result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println("=== UC6 Addition Demo ===");
        demonstrateLengthAddition(new Length(1.0,  Length.LengthUnit.FEET),
                new Length(2.0,  Length.LengthUnit.FEET));

        demonstrateLengthAddition(new Length(1.0,  Length.LengthUnit.FEET),
                new Length(12.0, Length.LengthUnit.INCHES));

        demonstrateLengthAddition(new Length(12.0, Length.LengthUnit.INCHES),
                new Length(1.0,  Length.LengthUnit.FEET));

        demonstrateLengthAddition(new Length(1.0,  Length.LengthUnit.YARDS),
                new Length(3.0,  Length.LengthUnit.FEET));

        demonstrateLengthAddition(new Length(2.54, Length.LengthUnit.CENTIMETERS),
                new Length(1.0,  Length.LengthUnit.INCHES));

        demonstrateLengthAddition(new Length(5.0,  Length.LengthUnit.FEET),
                new Length(0.0,  Length.LengthUnit.INCHES));

        demonstrateLengthAddition(new Length(5.0,  Length.LengthUnit.FEET),
                new Length(-2.0, Length.LengthUnit.FEET));
    }
}