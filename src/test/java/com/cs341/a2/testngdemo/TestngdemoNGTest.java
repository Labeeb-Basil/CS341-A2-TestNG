/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package com.cs341.a2.testngdemo;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author test
 */
public class TestngdemoNGTest {

    private Testngdemo calculator;

    private int sampleValue;

    // Setting up before any test runs
    @BeforeClass
    public void setUp() {
        calculator = new Testngdemo();
        sampleValue = 0;
    }

    // Simple testing addition
    @Test
    public void testAddition() {
        int result = calculator.add(5, 3);
        sampleValue = result;
        Assert.assertEquals(result, 8, "Addition result is incorrect!");
    }

    // Simple testing subtraction
    @Test
    public void testSubtraction() {
        int result = calculator.subtract(10, 4);
        Assert.assertEquals(result, 6, "Subtraction result is incorrect!");
    }

    // Testing dependencies
    @Test(dependsOnMethods = "testAddition")
    public void testSampleValue() {
        Assert.assertEquals(sampleValue, 8, "Sample Value is wrong value");
    }

    // Testing multiplication
    @Test
    public void testMultiplication() {
        int result = calculator.multiply(7, 2);
        Assert.assertEquals(result, 14, "Multiplication result is incorrect!");
    }

    // Testing division by zero and exception
    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivisionByZero() {
        calculator.divide(10, 0);
    }

    // Testing parallel execution
    @Test(threadPoolSize = 2, invocationCount = 3)
    public void testParallelExecution() {
        long start = System.currentTimeMillis();
        calculator.longTask();
        long end = System.currentTimeMillis();
        System.out.println("Thread: " + Thread.currentThread().threadId() + ", Execution time: " + (end - start) + " ms, Started: "
                + start + ", Ended: " + end);
    }

    // Testing increment
    @Test(threadPoolSize = 5, invocationCount = 100, timeOut = 1000)
    public void testIncrementCounterParallel() {
        calculator.incrementCounter();
    }

    // Testing if value is correct after increment
    @Test(dependsOnMethods = "testIncrementCounterParallel")
    public void testCounterValue() {
        // Since 100 threads will increment the counter, the final value should be 100
        int expectedCounter = 100;
        Assert.assertEquals(calculator.getCounter(), expectedCounter, "Counter value is incorrect!");
    }

}
