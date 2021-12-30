package com.xm.chess.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.xm.chess.exception.ChessException;

@RunWith(JUnit4.class)
public class CalculatorTest {
    
    Calculator calculator;
    
    @Before
    public void setup() {
        calculator = new CalculatorImpl();
    }
    
    @Test
    public void calculatePath_withSolution() {
        
        List<String> actual = calculator.calculatePath("E5", "A4");
    
        Assert.assertEquals(4, actual.size());
    }
    
    @Test
    public void calculatePath_withoutSolution() {
        
        List<String> actual = calculator.calculatePath("A1", "H8");
        
        Assert.assertEquals(0, actual.size());
    }
    
    @Test(expected = ChessException.class)
    public void calculatePath_throwExceptionForInvalidPosLength() {
        
        calculator.calculatePath("A1", "H81");
        
    }
    
    @Test(expected = ChessException.class)
    public void calculatePath_throwExceptionForInvalidPosChar() {
        
        calculator.calculatePath("A1", "W8");
        
    }
    
    @Test(expected = ChessException.class)
    public void calculatePath_throwExceptionForInvalidPosNumber() {
        
        calculator.calculatePath("A1", "W9");
        
    }
    
}