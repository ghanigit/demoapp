package com.demo;

/**
 * Simple utility class — pure Java logic, easy to unit test.
 */
public class MathUtils {

    /**
     * Adds two integers.
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * Subtracts b from a.
     */
    public int subtract(int a, int b) {
        return a - b;
    }

    /**
     * Multiplies two integers.
     */
    public int multiply(int a, int b) {
        return a * b;
    }

    /**
     * Divides a by b.
     * @throws IllegalArgumentException if b is zero
     */
    public double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }

    /**
     * Returns true if n is even.
     */
    public boolean isEven(int n) {
        return n % 2 == 0;
    }

    /**
     * Returns the factorial of n (n >= 0).
     * @throws IllegalArgumentException for negative input
     */
    public long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial not defined for negative numbers");
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
