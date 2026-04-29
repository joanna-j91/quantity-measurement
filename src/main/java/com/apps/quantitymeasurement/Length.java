package com.apps.quantitymeasurement;

public class Length {

    private final double value;
    private final LengthUnit unit;
    private static final double EPSILON = 1e-6;

    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    public Length(double value, LengthUnit unit) {
        if (unit == null) throw new IllegalArgumentException("Unit cannot be null");
        if (!Double.isFinite(value)) throw new IllegalArgumentException("Value must be finite");
        this.value = value;
        this.unit = unit;
    }

    public Length convertTo(LengthUnit targetUnit) {
        if (targetUnit == null) throw new IllegalArgumentException("Target unit cannot be null");
        double converted = this.value * (this.unit.getConversionFactor() / targetUnit.getConversionFactor());
        return new Length(converted, targetUnit);
    }

    public static double convert(double value, LengthUnit source, LengthUnit target) {
        if (source == null || target == null) throw new IllegalArgumentException("Units cannot be null");
        if (!Double.isFinite(value)) throw new IllegalArgumentException("Value must be finite");
        return value * (source.getConversionFactor() / target.getConversionFactor());
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
        return this.compare((Length) o);
    }

    @Override
    public String toString() {
        return String.format("Length(%.6f %s)", value, unit.name());
    }


    private Length addInTargetUnit(Length other, LengthUnit targetUnit) {
        if (other == null) throw new IllegalArgumentException("Operand cannot be null");
        if (targetUnit == null) throw new IllegalArgumentException("Target unit cannot be null");

        double sumInBase = this.convertToBaseUnit() + other.convertToBaseUnit();
        double resultValue = sumInBase / targetUnit.getConversionFactor();
        resultValue = Math.round(resultValue * 100.0) / 100.0;
        return new Length(resultValue, targetUnit);
    }

    public Length add(Length other) {
        return addInTargetUnit(other, this.unit);
    }

    public Length add(Length other, LengthUnit targetUnit) {
        return addInTargetUnit(other, targetUnit);
    }

    public static void main(String[] args) {
        Length feet1   = new Length(1.0,  LengthUnit.FEET);
        Length feet2   = new Length(2.0,  LengthUnit.FEET);
        Length inches1 = new Length(12.0, LengthUnit.INCHES);
        Length yards1  = new Length(1.0,  LengthUnit.YARDS);
        Length feet3   = new Length(3.0,  LengthUnit.FEET);

        System.out.println(feet1.add(feet2));
        System.out.println(feet1.add(inches1));
        System.out.println(inches1.add(feet1));
        System.out.println(yards1.add(feet3));
    }
}