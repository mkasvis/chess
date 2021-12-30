package com.xm.chess.model;

import java.util.ArrayList;
import java.util.List;

public class Knight implements Piece{

    private static final int[] axisX = { 2, 1, -1, -2, -2, -1, 1, 2 };
    private static final int[] axisY = { 1, 2, 2, 1, -1, -2, -2, -1 };
    
    private static final int KNIGHT_MOVES = 8;
    
    @Override
    public List<Square> getValidMoves(final Board board, final Square currentSquare){
        
        List<Square> validSquares = new ArrayList<>();
        for (int i = 0; i < KNIGHT_MOVES; i++) {
        
            int x = currentSquare.getX() + axisX[i];
            int y = currentSquare.getY() + axisY[i];
    
            board.getSquare(x, y)
                .ifPresent(validSquares::add);
        }
    
        return validSquares;
    }
    
}
