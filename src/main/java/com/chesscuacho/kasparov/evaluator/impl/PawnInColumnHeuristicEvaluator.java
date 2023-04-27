package com.chesscuacho.kasparov.evaluator.impl;

import com.chesscuacho.kasparov.evaluator.HeuristicEvaluator;
import org.springframework.stereotype.Service;

@Service
public class PawnInColumnHeuristicEvaluator implements HeuristicEvaluator {

    public static final int PENALTY = 50;

    @Override
    public int evaluate(String[][] board) {
        int result = 0;

        int nWhitePawns = 0;
        int nBlackPawns = 0;

        for(int col = 0; col<8; col++) {
            nWhitePawns = 0;
            nBlackPawns = 0;
            for (String[] fila: board){
                switch(fila[col]){
                    case "P":
                        nWhitePawns++;
                        break;
                    case "p":
                        nBlackPawns++;
                        break;
                }
            }
            if(nWhitePawns > 1) {
                result += - (nWhitePawns - 1 ) * PENALTY;
            }
            if(nBlackPawns > 1) {
                result += + (nBlackPawns - 1) * PENALTY;
            }
        }


        return result;
    }
}
