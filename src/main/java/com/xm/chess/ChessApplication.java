package com.xm.chess;

import java.util.List;

import com.xm.chess.exception.ChessException;
import com.xm.chess.service.CalculatorImpl;

public class ChessApplication {
    
    public static void main(String[] args){
        if(args.length != 2){
            System.out.println("Invalid arguments. Please pass only start end end positions!");
            return;
        }
    
        try{
            CalculatorImpl calculator = new CalculatorImpl();
            List<String> positions = calculator.calculatePath(args[0], args[1]);
    
            if(positions.isEmpty()){
                System.out.println("No solution has been found");
            } else {
                positions.forEach(System.out::println);
            }
        } catch(ChessException e){
            System.out.println(e.getMessage());
        }
        
        
        
    }
    
}
