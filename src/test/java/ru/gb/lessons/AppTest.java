package ru.gb.lessons;

import org.junit.jupiter.api.Test;


public class AppTest {

    public boolean b;

    @Test
    public void shouldAnswerWithTrue() {

        assertTrue(true);
    }

    public void assertTrue(boolean b) {
        this.b = b;
    }
}
