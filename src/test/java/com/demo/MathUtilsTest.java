package com.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("MathUtils Unit Tests")
public class MathUtilsTest {

    private MathUtils math;

    @BeforeEach
    void setUp() {
        math = new MathUtils();
    }

    // ── add ──────────────────────────────────────────────────────────────────

    @Test
    @DisplayName("add: 2 + 3 = 5")
    void testAdd() {
        assertEquals(5, math.add(2, 3));
    }

    @Test
    @DisplayName("add: negative numbers")
    void testAddNegative() {
        assertEquals(-1, math.add(-3, 2));
    }

    // ── subtract ─────────────────────────────────────────────────────────────

    @Test
    @DisplayName("subtract: 10 - 4 = 6")
    void testSubtract() {
        assertEquals(6, math.subtract(10, 4));
    }

    // ── multiply ─────────────────────────────────────────────────────────────

    @Test
    @DisplayName("multiply: 3 × 4 = 12")
    void testMultiply() {
        assertEquals(12, math.multiply(3, 4));
    }

    @Test
    @DisplayName("multiply: anything × 0 = 0")
    void testMultiplyByZero() {
        assertEquals(0, math.multiply(99, 0));
    }

    // ── divide ───────────────────────────────────────────────────────────────

    @Test
    @DisplayName("divide: 10 / 2 = 5.0")
    void testDivide() {
        assertEquals(5.0, math.divide(10, 2), 0.001);
    }

    @Test
    @DisplayName("divide: throws on division by zero")
    void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> math.divide(5, 0));
    }

    // ── isEven ───────────────────────────────────────────────────────────────

    @Test
    @DisplayName("isEven: 4 is even")
    void testIsEven() {
        assertTrue(math.isEven(4));
    }

    @Test
    @DisplayName("isEven: 7 is odd")
    void testIsOdd() {
        assertFalse(math.isEven(7));
    }

    // ── factorial ────────────────────────────────────────────────────────────

    @Test
    @DisplayName("factorial: 5! = 120")
    void testFactorial() {
        assertEquals(120, math.factorial(5));
    }

    @Test
    @DisplayName("factorial: 0! = 1")
    void testFactorialZero() {
        assertEquals(1, math.factorial(0));
    }

    @Test
    @DisplayName("factorial: throws on negative input")
    void testFactorialNegative() {
        assertThrows(IllegalArgumentException.class, () -> math.factorial(-1));
    }
}
