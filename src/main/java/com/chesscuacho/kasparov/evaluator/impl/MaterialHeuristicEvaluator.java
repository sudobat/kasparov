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
        int result = 0;

        for (String[] fila: board){
            for (String pos: fila) {
                switch(pos){
                    case "P":
                        result += PAWN;
                        break;
                    case "p":
                        result -= PAWN;
                        break;
                    case "B":
                        result += BISHOP;
                        break;
                    case "b":
                        result -= BISHOP;
                        break;
                    case "N":
                        result += KNIGHT;
                        break;
                    case "n":
                        result -= KNIGHT;
                        break;
                }
            }
        }


        return result;
    }
}
