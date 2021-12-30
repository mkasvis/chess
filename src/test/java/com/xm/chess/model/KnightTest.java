package com.xm.chess.model;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class KnightTest {
    
    Piece knight;
    
    Board board;
    
    @Before
    public void setup() {
        knight = new Knight();
        board = new Board();
    }
    
    @Test
    public void getValidMoves_returnMoves() {
        Square edgeSquare = new Square(0, 0);
        
        List<Square> actual = knight.getValidMoves(board, edgeSquare);
        Assert.assertEquals(2, actual.size());
    
        Square middleSquare = new Square(3, 3);
    
        actual = knight.getValidMoves(board, middleSquare);
        Assert.assertEquals(8, actual.size());
    }
    
}