package Homework_4;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class AreaTriangle {

    private double a;
    private double b;
    private double c;

    public void areaTriangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void checkSidesArePositive() {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Sides must be positive");
        }
    }

    private void checkOneSideIsSmallerThanSumOfOthers() {
        if (a + b <= c || b + c <= a || c + a <= b) {
            throw new IllegalArgumentException("One side can't be greater than sum of others");
        }
    }

    public double countArea() {
        checkSidesArePositive();
        checkOneSideIsSmallerThanSumOfOthers();

        double p = (a + b + c) / 2.0;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}