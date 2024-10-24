/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.cs341.a2.testngdemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author test
 */
// File: Calculator.java

public class Testngdemo {
    
    private AtomicInteger counter = new AtomicInteger(0);

    // Addition
    public int add(int a, int b) {
        return a + b;
    }

    // Subtraction
    public int subtract(int a, int b) {
        return a - b;
    }

    // Multiplication
    public int multiply(int a, int b) {
        return a * b;
    }

    // Division
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }

    // Increment the counter (simulates a shared resource)
    public void incrementCounter() {
        counter.incrementAndGet();
    }

    // Get the current counter value
    public int getCounter() {
        return counter.get();
    }

    // Simulates a long-running task (for parallel test demonstration)
    public void longTask() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

