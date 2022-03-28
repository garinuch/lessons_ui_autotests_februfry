package ru.gb.lessons.Lesson4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.gb.lessons.lesson4.Colour;
import ru.gb.lessons.lesson4.Triangle;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AssertJTest {

    public static Stream<Arguments> triangles() {
        return Stream.of(Arguments.of(new Triangle(3, 4, 5), 12),
                Arguments.of(new Triangle(3, 4, 6), 13),
                Arguments.of(new Triangle(3, 3, 3), 9)
        );
    }

    @ParameterizedTest(name = "Периметр треугольника: позитивный сценарий, периметр треугольника {0} == {1}")
    @MethodSource("triangles")
    void countPerimeterPositiveTest(Triangle triangle, int expectedResult) {
        int perimeter = triangle.countPerimeter();
        assertThat(perimeter).as("Проверяем, что периметр должен ....")
                .isEqualTo(expectedResult);
    }


    public static Stream<Arguments> negativeTriangles() {
        return Stream.of(Arguments.of(new Triangle(0, 3, 3), "Sides must be positive"),
                Arguments.of(new Triangle(3, 0, 3), "Sides must be positive"),
                Arguments.of(new Triangle(3, 3, 0), "Sides must be positive"),
                Arguments.of(new Triangle(3, 3, -1), "Sides must be positive"),
                Arguments.of(new Triangle(3, -1, 3), "Sides must be positive"),
                Arguments.of(new Triangle(-1, 3, 3), "Sides must be positive"),
                Arguments.of(new Triangle(-1, 3, 3), "Sides must be positive"),
                Arguments.of(new Triangle(6, 1, 1), "One side can't be greater than sum of others"),
                Arguments.of(new Triangle(1, 2, 1), "One side can't be greater than sum of others")
        );
    }

    @ParameterizedTest(name = "Периметр треугольника: негативный сценарий (треугольника {0}, ошибка:{1})")
    @MethodSource("negativeTriangles")
    public void countPerimeterNegativeTest(Triangle triangle, String errorText) {
        assertThatThrownBy(triangle::countPerimeter)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorText);
    }

    @Test
    void similarTriangleTest() {
        Triangle triangle = new Triangle(3, 3, 3);
        Triangle similarTriangle = triangle.createSimilarTriangle(2);
        assertThat(similarTriangle).usingRecursiveComparison()
                .ignoringFieldsOfTypes(Colour.class)
                .isEqualTo(new Triangle(6, 6, 6, Colour.BLUE));
    }
}
