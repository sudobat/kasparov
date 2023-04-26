package com.chesscuacho.kasparov.evaluator.impl;

import com.chesscuacho.kasparov.evaluator.HeuristicEvaluator;
import org.springframework.stereotype.Service;

@Service
public class BishopHeuristicEvaluator implements HeuristicEvaluator {

    public static final int BISHOP = 50;

    @Override
    public int evaluate(String[][] board) {
        int result = 0;

        int nWhite = 0;
        int nBlack = 0;

        for (String[] fila: board){
            for (String pos: fila) {
                switch(pos){
                    case "B":
                        nWhite++;
                        break;
                    case "b":
                        nBlack++;
                        break;
                }
            }
        }

        if(nWhite == 2) {
            result += BISHOP;
        }

        if(nBlack == 2) {
            result -= BISHOP;
        }

        return result;
    }
}
