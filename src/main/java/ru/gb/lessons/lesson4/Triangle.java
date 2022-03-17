package ru.gb.lessons.lesson4;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Triangle {

    private int a;
    private int b;
    private int c;
    private Colour colour;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        colour = Colour.WHITE;
    }

    private void checkSidesArePositive() {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Sides must be positive");
        }
    }

    private void checkOneSideIsSmallerThanSumOfOthers() {
        if (a + b <= c || b + c <= a || c + a <= b) {
            throw new IllegalArgumentException("One side can't be greater than sum of others");
        }
    }

    public int countPerimeter() {
        checkSidesArePositive();
        checkOneSideIsSmallerThanSumOfOthers();
        return a + b + c;
    }

    public void paint(Colour colour) {
        if (this.colour == colour) {
            throw new IllegalArgumentException("New colour must not be equal to old colour");
        }
        this.colour = colour;
    }

    public void paint(String colour) {
        checkSidesArePositive();
        checkOneSideIsSmallerThanSumOfOthers();
        paint(Colour.valueOf(colour));
    }

    public double countArea() {
        // TODO: 01.03.2022 realize https://shkolkovo.net/theory/128
        return 0;
    }

    public Triangle createSimilarTriangle(int coef) {
        checkSidesArePositive();
        checkOneSideIsSmallerThanSumOfOthers();
        // TODO: 01.03.2022 добавить проверку коэффициента
        return new Triangle(a * coef, b * coef, c * coef);
    }
}
