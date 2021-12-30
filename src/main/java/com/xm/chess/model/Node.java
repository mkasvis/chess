package com.xm.chess.model;

import java.util.List;

public class Node {
    
    private Square data;
    
    private Node parent;
    
    private List<Node> children;
    
    public Node(final Square data) {
        this.data = data;
    }
    
    public Node(final Square data, final Node parent) {
        this.data = data;
        this.parent = parent;
    }
    
    public Square getData() {
        return data;
    }
    
    public void setData(final Square data) {
        this.data = data;
    }
    
    public Node getParent() {
        return parent;
    }
    
    public void setParent(final Node parent) {
        this.parent = parent;
    }
    
    public List<Node> getChildren() {
        return children;
    }
    
    public void setChildren(final List<Node> children) {
        this.children = children;
    }
    
}
