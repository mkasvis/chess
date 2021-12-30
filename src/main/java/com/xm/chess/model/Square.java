package com.xm.chess.model;

import java.util.Objects;

public class Square {
    
    private int x;
    private int y;
    
    public Square(final int x, final int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public void setX(final char x) {
        this.x = x;
    }
    
    public int getY() {
        return y;
    }
    
    public void setY(final int y) {
        this.y = y;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Square square = (Square) o;
        return getX() == square.getX() && getY() == square.getY();
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }
    
}
