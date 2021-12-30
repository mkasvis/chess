package com.xm.chess.service;

import java.util.List;

public interface Calculator {
    
    List<String> calculatePath(final String startPos, final String endPos);
    
}
