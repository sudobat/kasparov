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

    int evaluatePawns(String _tipoFicha, String [][] _board) {
        int result = 0;
        int nFilaIni = 0;
        int nFilaFin = 0;

        if(WHITE.equals(_tipoFicha)) {
            nFilaIni = 1;
            nFilaFin = 6;
        } else {
            nFilaIni = 2;
            nFilaFin = 7;
        }

        for(int fila = nFilaIni; fila<nFilaFin; fila++) {
            for (int col = 0; col<8; col++){
                String pos = _board[fila] [col];
                if(_tipoFicha.equals(pos)) {
                    boolean lProtected = false;
                    int checkFila = (WHITE.equals(_tipoFicha))? (fila + 1) : (fila -1);

                    if(col >0) {
                        lProtected = _tipoFicha.equals(_board[checkFila] [col - 1]);
                    }
                    if(col<7) {
                        lProtected = lProtected || _tipoFicha.equals(_board[checkFila] [col + 1]);
                    }

                    if(!lProtected) {
                        result = (WHITE.equals(_tipoFicha))? (result - PENALTY) : (result + PENALTY);
                    }
                }

            }
        }

        return result;
    }
}
