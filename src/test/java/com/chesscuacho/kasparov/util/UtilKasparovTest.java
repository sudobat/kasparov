package com.chesscuacho.kasparov.util;

import com.chesscuacho.kasparov.evaluator.impl.BishopHeuristicEvaluator;
import com.chesscuacho.kasparov.evaluator.util.UtilKasparov;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilKasparovTest {

    @Test
    void initFenIsInitMatrix() {

        String[][] initMatrixTable = {
                {"r", "n", "b", "q", "k", "b", "n", "r"},
                {"p", "p", "p", "p", "p", "p", "p", "p"},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {"P", "P", "P", "P", "P", "P", "P", "P"},
                {"R", "N", "B", "Q", "K", "B", "N", "R"}
        };
        String initFen = UtilKasparov.INIT_BOARD;
        assertThat(UtilKasparov.FEN2Matrix(initFen)).isEqualTo(initMatrixTable);

    }

    @Test
    void initFenIsValid() {


        String initFen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR";
        assertThat(UtilKasparov.isValidFen(initFen));

    }

    @Test
    void invalidFenIsNotValid() {

        String initFen = "rnbqkbnr/pApppppp/8/8/8/8/PPPPPPPP/RNBQKBNR";
        assertThat(UtilKasparov.isValidFen(initFen)).isEqualTo(false);

    }

    @Test
    void inValidPomVersion() {
        String version = "";
        assertThat(UtilKasparov.getVersion()).isNotEqualTo(version);
    }


}