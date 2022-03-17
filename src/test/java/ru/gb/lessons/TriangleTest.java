package ru.gb.lessons;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.gb.lessons.lesson4.Triangle;
import static org.junit.jupiter.api.Assertions.*;

@Disabled("Перенесены в параметризированные тесты")
public class TriangleTest {

    @Test
    @Disabled("Перенесены в параметризированные тесты")
    @DisplayName("Периметр треугольника 3, 4, 5 должен быть равен 12")
    public void countPerimeterEgyptTriangleSuccessfulTest() {
        Triangle triangle = new Triangle(3, 4, 5);   //Arrange
        int perimeter = triangle.countPerimeter();    //Act
        assertEquals(12, perimeter);
    }


    @Test
    @Disabled("Перенесены в параметризированные тесты")
    @DisplayName("Периметр треугольника 3, 4, 6 должен быть равен 13")
    public void countPerimeterGreater90TriangleSuccessfulTest() {
        Triangle triangle = new Triangle(3, 4, 6);   //Arrange
        int perimeter = triangle.countPerimeter();    //Act
        assertEquals(13, perimeter);
    }

    @Test
    @Disabled("Перенесены в параметризированные тесты")
    @DisplayName("Периметр треугольника 3, 3, 3 должен быть равен 9")
    public void countPerimeterWithEqualSidesTriangleSuccessfulTest() {
        Triangle triangle = new Triangle(3, 3, 3);   //Arrange
        int perimeter = triangle.countPerimeter();    //Act
        assertEquals(9, perimeter);
    }


    @Test
    public void countPerimeter1SideIsZeroFailedTest() {
        Triangle triangle = new Triangle(0, 3, 3);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, triangle::countPerimeter);
        assertEquals("Sides must be positive", illegalArgumentException.getMessage());
    }

    @Test
    public void countPerimeter2SideIsZeroFailedTest() {
        Triangle triangle = new Triangle(1, 0, 2);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, triangle::countPerimeter);
        assertEquals("Sides must be positive", illegalArgumentException.getMessage());
    }

    @Test
    public void countPerimeter3SideIsZeroFailedTest() {
        Triangle triangle = new Triangle(1, 1, 0);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, triangle::countPerimeter);
        assertEquals("Sides must be positive", illegalArgumentException.getMessage());
    }


    @Test
    public void countPerimeter1SideIsNegativeFailedTest() {
        Triangle triangle = new Triangle(-3, 3, 3);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, triangle::countPerimeter);
        assertEquals("Sides must be positive", illegalArgumentException.getMessage());
    }

    @Test
    public void countPerimeter2SideIsNegativeFailedTest() {
        Triangle triangle = new Triangle(1, -1, 1);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, triangle::countPerimeter);
        assertEquals("Sides must be positive", illegalArgumentException.getMessage());
    }

    @Test
    public void countPerimeter3SideIsNegativeFailedTest() {
        Triangle triangle = new Triangle(1, 1, -1);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, triangle::countPerimeter);
        assertEquals("Sides must be positive", illegalArgumentException.getMessage());
    }

    @Test
    public void countPerimeterInvalidTriangleFailedTest() {
        Triangle triangle = new Triangle(1, 1, 6);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, triangle::countPerimeter);
        assertEquals("One side can't be greater than sum of others", illegalArgumentException.getMessage());
    }

    @Test
    public void countPerimeterInvalidTriangle2FailedTest() {
        Triangle triangle = new Triangle(1, 2, 1);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, triangle::countPerimeter);
        assertEquals("One side can't be greater than sum of others", illegalArgumentException.getMessage());
    }

}