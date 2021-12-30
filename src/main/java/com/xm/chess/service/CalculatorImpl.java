package com.xm.chess.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.xm.chess.model.Board;
import com.xm.chess.model.Knight;
import com.xm.chess.model.Node;
import com.xm.chess.model.Square;
import com.xm.chess.util.ChessHelper;

public class CalculatorImpl implements Calculator{
    
    private final Board board;
    
    private final Knight knight;
    
    private static final int MOVES_COUNT = 2;
    
    public CalculatorImpl(){
        this.board = new Board();
        this.knight = new Knight();
    }
    
    @Override
    public List<String> calculatePath(final String startPos, final String endPos){
        Square startSquare = ChessHelper.getSquare(startPos);
        Square endSquare = ChessHelper.getSquare(endPos);
        
        Node rootNode = new Node(startSquare);
        
        int count = 0;
        List<Node> rootNodes = List.of(rootNode);
        Optional<Node> finalNode = Optional.empty();
        while(count <= MOVES_COUNT && finalNode.isEmpty()){
            
            rootNodes = rootNodes
                .stream()
                .flatMap(rn -> {
                    rn.setChildren(getNextValidMoves(rn, knight, board));
                    return rn.getChildren().stream();
                }).collect(Collectors.toList());
            
            finalNode = getFinalNode(rootNodes, endSquare);
            
            count++;
        }
    
        return getPath(finalNode);
    }
    
    private List<Node> getNextValidMoves(Node node, Knight knight, Board board){
        return knight.getValidMoves(board, node.getData())
                     .stream()
                     .map(s -> new Node(s, node))
                     .collect(Collectors.toList());
    }
    
    private Optional<Node> getFinalNode(List<Node> rootNodes, Square endSquare) {
        return rootNodes.stream()
                        .filter(rn -> rn.getData().equals(endSquare))
                        .findFirst();
    }
    
    private List<String> getPath(final Optional<Node> finalNode) {
        
        List<Node> nodeList = finalNode
            .map(fn -> {
                Node temp = fn;
                List<Node> nodes = new ArrayList<>();
                nodes.add(temp);
                while (temp.getParent() != null) {
                    nodes.add(temp.getParent());
                    temp = temp.getParent();
                }
                
                Collections.reverse(nodes);
                
                return nodes;
            })
            .orElseGet(Collections::emptyList);
        
        return nodeList.stream()
                    .map(n -> ChessHelper.convertFromAxisToXChessBoardPos(n.getData().getX()) + "" +
                              ChessHelper.convertFromAxisYToChessBoardPos(n.getData().getY()))
                    .collect(Collectors.toList());
        
    }
    
}
