package com.chesscuacho.kasparov.evaluator.impl;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MaterialHeuristicEvaluatorTests {

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

        MaterialHeuristicEvaluator oM = new MaterialHeuristicEvaluator();
        int evaluation = oM.evaluate(initTable);
        assertThat(evaluation).isEqualTo(0);

    }

    @Test
    void InitialPositionShouldMinorPawnReturnNegative() {

        String[][] initTable = {
                {"r", "n", "b", "q", "k", "b", "n", "r"},
                {"p", "p", "p", "p", "p", "p", "p", "p"},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {"P", " ", "P", "P", "P", "P", "P", "P"},
                {"R", "N", "B", "Q", "K", "B", "N", "R"}
        };

        MaterialHeuristicEvaluator oM = new MaterialHeuristicEvaluator();
        int evaluation = oM.evaluate(initTable);
        assertThat(evaluation).isEqualTo(-MaterialHeuristicEvaluator.PAWN);

    }

    @Test
    void InitialPositionShouldMinorBishopReturnPositive() {

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

        MaterialHeuristicEvaluator oM = new MaterialHeuristicEvaluator();
        int evaluation = oM.evaluate(initTable);
        assertThat(evaluation).isEqualTo(+MaterialHeuristicEvaluator.BISHOP);

    }

    @Test
    void InitialPositionShouldMinorKnightReturnNegative() {

        String[][] initTable = {
                {"r", "n", "b", "q", "k", "b", "n", "r"},
                {"p", "p", "p", "p", "p", "p", "p", "p"},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {"P", "P", "P", "P", "P", "P", "P", "P"},
                {"R", "N", "B", "Q", "K", "B", " ", "R"}
        };

        MaterialHeuristicEvaluator oM = new MaterialHeuristicEvaluator();
        int evaluation = oM.evaluate(initTable);
        assertThat(evaluation).isEqualTo(-MaterialHeuristicEvaluator.KNIGHT);

    }

    @Test
    void InitialPositionShouldMinorQueenReturnPositive() {

        String[][] initTable = {
                {"r", "n", "b", " ", "k", "b", "n", "r"},
                {"p", "p", "p", "p", "p", "p", "p", "p"},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {"P", "P", "P", "P", "P", "P", "P", "P"},
                {"R", "N", "B", "Q", "K", "B", "N", "R"}
        };

        MaterialHeuristicEvaluator oM = new MaterialHeuristicEvaluator();
        int evaluation = oM.evaluate(initTable);
        assertThat(evaluation).isEqualTo(+MaterialHeuristicEvaluator.QUEEN);

    }

    @Test
    void InitialPositionShouldMinorRoot() {

        String[][] initTable = {
                {"r", "n", "b", "q", "k", "b", "n", " "},
                {"p", "p", "p", "p", "p", "p", "p", "p"},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {"P", "P", "P", "P", "P", "P", "P", "P"},
                {"R", "N", "B", "Q", "K", "B", "N", "R"}
        };

        MaterialHeuristicEvaluator oM = new MaterialHeuristicEvaluator();
        int evaluation = oM.evaluate(initTable);
        assertThat(evaluation).isEqualTo(+MaterialHeuristicEvaluator.ROOK);

    }

    @Test
    void WithoutWhiteShouldReturn3900() {

        String[][] initTable = {
                {" ", " ", " ", " ", "k", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {"P", "P", "P", "P", "P", "P", "P", "P"},
                {"R", "N", "B", "Q", "K", "B", "N", "R"}
        };

        MaterialHeuristicEvaluator oM = new MaterialHeuristicEvaluator();
        int evaluation = oM.evaluate(initTable);
        assertThat(evaluation).isEqualTo(+3900);

    }
}
