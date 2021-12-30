package com.xm.chess.util;

import com.xm.chess.exception.ChessException;
import com.xm.chess.model.Square;

public class ChessHelper {
    
    private static final int ASCII_CONSTANT = 65;
    private static final String CHAR_REGEX = "[A-H]";
    
    public static char convertFromAxisToXChessBoardPos(int x){
        return (char) (x + ASCII_CONSTANT);
    }
    
    public static int convertFromAxisYToChessBoardPos(int y){
        return y + 1;
    }
    
    public static int convertFromChessBoardPosToAxisToX(final String x){
        if(!x.matches(CHAR_REGEX)){
            throw new ChessException("Invalid position. Please use A-H character.");
        }
        return x.charAt(0) - ASCII_CONSTANT;
    }
    
    public static int convertFromChessBoardPosToAxisToY(int y){
        if(y < 1 || y > 8){
            throw new ChessException("Invalid position. Please use 1-8 number.");
        }
        return y - 1;
    }
    
    public static Square getSquare(String pos){
        if(pos.length() != 2){
            throw new ChessException("Invalid position. Valid position example is 'A1'.");
        }
        int x = convertFromChessBoardPosToAxisToX(pos.substring(0,1));
        int y = convertFromChessBoardPosToAxisToY(Integer.parseInt(pos.substring(1,2)));
        
        return new Square(x, y);
    }
    
}
