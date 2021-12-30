package com.xm.chess.exception;

public class ChessException extends RuntimeException{
    
    public ChessException(){
        super();
    }
    
    public ChessException(String message){
        super(message);
    }
    
    public ChessException(String message, Throwable cause){
        super(message, cause);
    }
    
    public ChessException(Throwable cause){
        super(cause);
    }
    
}
