package com.apps.quantitymeasurement;

public class Length {

    private double value;
    private LengthUnit unit;

    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    public Length(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    private double convertToBaseUnit() {
        return value * unit.getConversionFactor();
    }

    public boolean compare(Length thatLength) {
        return Double.compare(this.convertToBaseUnit(), thatLength.convertToBaseUnit()) == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Length other = (Length) o;
        return this.compare(other);
    }

    public static void main(String[] args) {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(20.0, LengthUnit.INCHES);
        System.out.println("Are lengths equal? " + length1.equals(length2)); // false; 1ft=12in ≠ 20in
    }
}
