package com.chesscuacho.kasparov.evaluator.impl;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BishopHeuristicEvaluatorTests {

    @Test
    void InitialPositionShouldReturnZero() {

        String[][] initTable = {
                {"r", "n", "b", "q", "k", "b", "n", "r"},
                {"p", "p", "p", "p", "p", "p", "p", "p"},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {"P", "P", "P", "P", "P", "P", "P", "P"},
                {"R", "N", "B", "Q", "K", "B", "N", "R"}
        };

        BishopHeuristicEvaluator oM = new BishopHeuristicEvaluator();
        int evaluation = oM.evaluate(initTable);
        assertThat(evaluation).isEqualTo(0);

    }

    @Test
    void MinorBishopBlackReturnPlus50() {

        String[][] initTable = {
                {"r", "n", " ", "q", "k", "b", "n", "r"},
                {"p", "p", "p", "p", "p", "p", "p", "p"},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {"P", "P", "P", "P", "P", "P", "P", "P"},
                {"R", "N", "B", "Q", "K", "B", "N", "R"}
        };

        BishopHeuristicEvaluator oM = new BishopHeuristicEvaluator();
        int evaluation = oM.evaluate(initTable);
        assertThat(evaluation).isEqualTo(+BishopHeuristicEvaluator.BISHOP);

    }

    @Test
    void MinorBishopWhiteReturnMinus50() {

        String[][] initTable = {
                {"r", "n", "b", "q", "k", "b", "n", "r"},
                {"p", "p", "p", "p", "p", "p", "p", "p"},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {"P", "P", "P", "P", "P", "P", "P", "P"},
                {"R", "N", " ", "Q", "K", "B", "N", "R"}
        };

        BishopHeuristicEvaluator oM = new BishopHeuristicEvaluator();
        int evaluation = oM.evaluate(initTable);
        assertThat(evaluation).isEqualTo(-BishopHeuristicEvaluator.BISHOP);

    }

    @Test
    void MinorBishopWhiteAndBlackReturnZero() {

        String[][] initTable = {
                {"r", "n", " ", "q", "k", "b", "n", "r"},
                {"p", "p", "p", "p", "p", "p", "p", "p"},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {"P", "P", "P", "P", "P", "P", "P", "P"},
                {"R", "N", " ", "Q", "K", "B", "N", "R"}
        };

        BishopHeuristicEvaluator oM = new BishopHeuristicEvaluator();
        int evaluation = oM.evaluate(initTable);
        assertThat(evaluation).isEqualTo(0);

    }

}
