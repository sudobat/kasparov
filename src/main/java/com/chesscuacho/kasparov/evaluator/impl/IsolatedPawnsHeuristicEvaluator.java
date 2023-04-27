package com.chesscuacho.kasparov.evaluator.impl;

import com.chesscuacho.kasparov.evaluator.HeuristicEvaluator;
import org.springframework.stereotype.Service;

@Service
public class IsolatedPawnsHeuristicEvaluator implements HeuristicEvaluator {

    public static final int PENALTY = 20;

    private static String WHITE = "P";
    private static String BLACK = "p";

    @Override
    public int evaluate(String[][] board) {
        return evaluatePawns(WHITE, board) + evaluatePawns(BLACK, board);
    }

    int evaluatePawns(String tipoFicha, String [][] board) {
        int result = 0;
        int nFilaIni = 0;
        int nFilaFin = 0;

        if(WHITE.equals(tipoFicha)) {
            nFilaIni = 1;
            nFilaFin = 6;
        } else {
            nFilaIni = 2;
            nFilaFin = 7;
        }

        for(int fila = nFilaIni; fila<nFilaFin; fila++) {
            for (int col = 0; col<8; col++){
                String pos = board[fila] [col];
                if(tipoFicha.equals(pos)) {
                    boolean lProtected = false;
                    int checkFila = (WHITE.equals(tipoFicha))? (fila + 1) : (fila -1);

                    if(col >0) {
                        lProtected = tipoFicha.equals(board[checkFila] [col - 1]);
                    }
                    if(col<7) {
                        lProtected = lProtected || tipoFicha.equals(board[checkFila] [col + 1]);
                    }

                    if(!lProtected) {
                        result = (WHITE.equals(tipoFicha))? (result - PENALTY) : (result + PENALTY);
                    }
                }

            }
        }

        return result;
    }
}
