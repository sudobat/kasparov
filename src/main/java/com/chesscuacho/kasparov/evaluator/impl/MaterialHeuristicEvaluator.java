package com.chesscuacho.kasparov.evaluator.impl;

import com.chesscuacho.kasparov.evaluator.HeuristicEvaluator;

public class MaterialHeuristicEvaluator implements HeuristicEvaluator {

    public static final int PAWN   = 100;
    public static final int BISHOP = 300;
    public static final int KNIGHT = 300;
    public static final int ROOK   = 500;
    public static final int QUEEN  = 900;

    @Override
    public int evaluate(String[][] board) {
        return 0;
    }
}
