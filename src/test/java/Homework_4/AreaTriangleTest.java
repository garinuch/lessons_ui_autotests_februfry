package Homework_4;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.gb.lessons.lesson4.Triangle;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Перенесены в параметризированные тесты")
public class AreaTriangleTest {

    @Test
    @Disabled("Перенесены в параметризированные тесты")
    @DisplayName("Площадь треугольника 3, 4, 5 должен равен = 6.0")
    public void countAreaEgyptTriangleSuccessfulTest() {
        AreaTriangle areaTriangle = new AreaTriangle(3.0, 4.0, 5.0);
        double area = areaTriangle.countArea();
        assertEquals(6.0, area);
    }

    @Test
    @Disabled("Перенесены в параметризированные тесты")
    @DisplayName("Площадь треугольника 3, 4, 6 должен равен = 5.332682251925386")
    public void сountAreaGreater90TriangleSuccessfulTest() {
        AreaTriangle areaTriangle = new AreaTriangle(3.0, 3.0, 6.0);
        double area = areaTriangle.countArea();
        assertEquals(5.332682251925386, area);
    }

    @Test
    @Disabled("Перенесены в параметризированные тесты")
    @DisplayName("Площадь треугольника 3, 3, 3 должен равен = 3.897114317029974")
    public void countAreaWithEqualSidesTriangleSuccessfulTest() {
        AreaTriangle areaTriangle = new AreaTriangle(3.0, 3.0, 3.0);
        double area = areaTriangle.countArea();
        assertEquals(3.897114317029974, area);
    }

    @Test
    public void countArea1SideIsZeroFailedTest() {
        AreaTriangle areaTriangle = new AreaTriangle(0.0, 3.0, 3.0);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, areaTriangle::countArea);
        assertEquals("Sides must be positive", illegalArgumentException.getMessage());
    }

    @Test
    public void countArea2SideIsZeroFailedTest() {
        Triangle triangle = new Triangle(1, 0, 2);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, triangle::countPerimeter);
        assertEquals("Sides must be positive", illegalArgumentException.getMessage());
    }

    @Test
    public void ccountArea3SideIsZeroFailedTest() {
        Triangle triangle = new Triangle(1, 1, 0);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, triangle::countPerimeter);
        assertEquals("Sides must be positive", illegalArgumentException.getMessage());
    }

    @Test
    public void countArea1SideIsNegativeFailedTest() {
        Triangle triangle = new Triangle(-3, 3, 3);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, triangle::countPerimeter);
        assertEquals("Sides must be positive", illegalArgumentException.getMessage());
    }

    @Test
    public void countArea2SideIsNegativeFailedTest() {
        Triangle triangle = new Triangle(1, -1, 1);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, triangle::countPerimeter);
        assertEquals("Sides must be positive", illegalArgumentException.getMessage());
    }

    @Test
    public void countArea3SideIsNegativeFailedTest() {
        Triangle triangle = new Triangle(1, 1, -1);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, triangle::countPerimeter);
        assertEquals("Sides must be positive", illegalArgumentException.getMessage());
    }

    @Test
    public void countAreaInvalidTriangleFailedTest() {
        Triangle triangle = new Triangle(1, 1, 6);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, triangle::countPerimeter);
        assertEquals("One side can't be greater than sum of others", illegalArgumentException.getMessage());
    }

    @Test
    public void countAreaInvalidTriangle2FailedTest() {
        Triangle triangle = new Triangle(1, 2, 1);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, triangle::countPerimeter);
        assertEquals("One side can't be greater than sum of others", illegalArgumentException.getMessage());
    }

}
