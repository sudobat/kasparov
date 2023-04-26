package com.chesscuacho.kasparov.evaluator.impl;

import com.chesscuacho.kasparov.evaluator.HeuristicEvaluator;

public class RookConnectedHeuristicEvaluator implements HeuristicEvaluator {

    public static final int BONUS = 120;

    @Override
    public int evaluate(String[][] board) {
        int result = 0;

        boolean lConnectedWhite = connectedRooks("R", board);
        boolean lConnectedBlack = connectedRooks("r", board);

        result += (lConnectedWhite) ? BONUS : 0;
        result += (lConnectedBlack) ? -BONUS : 0;

        return result;
    }

    boolean connectedRooks(String _rook, String[][] board) {
        boolean lConnected = false;

        //Procesar filas
        for (String[] fila : board) {
            lConnected = (lConnected || connectedInLineRooks(_rook, fila));
            if(lConnected) {
                break;
            }
        }

        //Procesar columnas
        if(!lConnected) {
            for (int col = 0; col < 8; col++) {
                lConnected = (lConnected || connectedInLineRooks(_rook, getColumn(col, board)));
                if (lConnected) {
                    break;
                }
            }
        }

        return lConnected;
    }

    private String[] getColumn(int _col, String[][] _board) {
        String [] resul = new String[8];
        int i = 0;
        for (String[] fila : _board) {
            resul[i] = fila[_col];
            i++;
        }

        return  resul;
    }

    boolean connectedInLineRooks(String _rook, String[] _line) {
        boolean lConnected = false;
        boolean lProcess = false;

        for (String pos : _line) {
            if (_rook.equals(pos)) {
                if (lProcess) {
                    lConnected = true;
                }
                lProcess = true;
            } else {
                if (lProcess) {
                    if (!"".equals(pos.trim())) {
                        break;
                    }
                }
            }
        }

        return  lConnected;
    }
}
