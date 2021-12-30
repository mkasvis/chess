package com.xm.chess.model;

import java.util.Optional;

public class Board {
    
    private static final int BOARD_X = 8;
    private static final int BOARD_Y = 8;
    
    private final Square[][] squares = new Square[BOARD_X][BOARD_Y];
    
    public Board(){
        for (int i = 0; i < BOARD_X; i++) {
            for (int j = 0; j < BOARD_X; j++) {
                squares[i][j] = new Square(i, j);
            }
        }
    }
    
    public Optional<Square> getSquare(int x, int y){
        
        if (x < 0 || x >= BOARD_X || y < 0 || y >= BOARD_Y) {
            return Optional.empty();
        }
        
        return Optional.of(squares[x][y]);
    }
    
}
