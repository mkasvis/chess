package com.xm.chess.model;

import java.util.List;

public interface Piece {
    
    List<Square> getValidMoves(final Board board, final Square currentSquare);
    
}
