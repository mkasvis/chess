package com.xm.chess.model;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BoardTest {
    
    Board board;
    
    @Before
    public void setup() {
        board =  new Board();
    }
    
    @Test
    public void getSquare_returnsSquare() {
        Square square = new Square(0, 0);
    
        Optional<Square> actual = board.getSquare(0, 0 );
    
        Assert.assertTrue(actual.isPresent());
        actual.ifPresent(s -> {
            Assert.assertEquals(square.getX(), s.getX());
            Assert.assertEquals(square.getY(), s.getY());
        });
    }
    
    @Test
    public void getSquare_notValidArgs() {
        Optional<Square> actual = board.getSquare(-1, 0 );
        Assert.assertTrue(actual.isEmpty());
    
        actual = board.getSquare(9, 0 );
        Assert.assertTrue(actual.isEmpty());
    
        actual = board.getSquare(0, -1 );
        Assert.assertTrue(actual.isEmpty());
    
        actual = board.getSquare(0, 9 );
        Assert.assertTrue(actual.isEmpty());
    }
    
}