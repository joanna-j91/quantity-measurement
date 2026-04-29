package com.apps.quantitymeasurement;

public class Length {

    private final double value;
    private final LengthUnit unit;

    private static final double EPSILON = 1e-6;

    public enum LengthUnit {
        FEET(12.0),            // 1 foot = 12 inches
        INCHES(1.0),           // base unit
        YARDS(36.0),           // 1 yard = 36 inches
        CENTIMETERS(0.393701); // 1 cm = 0.393701 inches

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    public Length(double value, LengthUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be a finite number, got: " + value);
        }
        this.value = value;
        this.unit = unit;
    }

    public Length convertTo(LengthUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }
        double convertedValue = this.value *
                (this.unit.getConversionFactor() / targetUnit.getConversionFactor());
        return new Length(convertedValue, targetUnit);
    }

    public static double convert(double value, LengthUnit sourceUnit, LengthUnit targetUnit) {
        if (sourceUnit == null || targetUnit == null) {
            throw new IllegalArgumentException("Source and target units cannot be null");
        }
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be finite, got: " + value);
        }
        return value * (sourceUnit.getConversionFactor() / targetUnit.getConversionFactor());
    }


    private double convertToBaseUnit() {
        return value * unit.getConversionFactor();
    }

    public boolean compare(Length other) {
        return Math.abs(this.convertToBaseUnit() - other.convertToBaseUnit()) < EPSILON;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Length other = (Length) o;
        return this.compare(other);
    }

    @Override
    public String toString() {
        return String.format("Length(%.6f %s)", value, unit.name());
    }

    public static void main(String[] args) {
        System.out.println(Length.convert(1.0,  LengthUnit.FEET,        LengthUnit.INCHES));  // 12.0
        System.out.println(Length.convert(3.0,  LengthUnit.YARDS,       LengthUnit.FEET));    // 9.0
        System.out.println(Length.convert(36.0, LengthUnit.INCHES,      LengthUnit.YARDS));   // 1.0
        System.out.println(Length.convert(1.0,  LengthUnit.CENTIMETERS, LengthUnit.INCHES));  // ~0.393701
        System.out.println(Length.convert(0.0,  LengthUnit.FEET,        LengthUnit.INCHES));  // 0.0
    }
}