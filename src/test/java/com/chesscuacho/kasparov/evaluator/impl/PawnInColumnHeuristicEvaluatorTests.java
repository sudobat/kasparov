package com.chesscuacho.kasparov.evaluator.impl;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PawnInColumnHeuristicEvaluatorTests {

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

        PawnInColumnHeuristicEvaluator oM = new PawnInColumnHeuristicEvaluator();
        int evaluation = oM.evaluate(initTable);
        assertThat(evaluation).isEqualTo(0);

    }
    @Test
    void InColumnTwoWhitePawnsReturnMinusPenalty() {

        String[][] initTable = {
                {"r", "n", "b", "q", "k", "b", "n", "r"},
                {" ", "p", "p", "p", "p", "p", "p", "p"},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {"P", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {"P", " ", "P", "P", "P", "P", "P", "P"},
                {"R", "N", "B", "Q", "K", "B", "N", "R"}
        };

        PawnInColumnHeuristicEvaluator oM = new PawnInColumnHeuristicEvaluator();
        int evaluation = oM.evaluate(initTable);
        assertThat(evaluation).isEqualTo(-PawnInColumnHeuristicEvaluator.PENALTY);

    }
    @Test
    void InColumnTwoBlackPawnsReturnPlusPenalty() {

        String[][] initTable = {
                {"r", "n", "b", "q", "k", "b", "n", "r"},
                {"p", " ", "p", "p", "p", "p", "p", "p"},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {"p", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {"P", " ", "P", "P", "P", "P", "P", "P"},
                {"R", "N", "B", "Q", "K", "B", "N", "R"}
        };

        PawnInColumnHeuristicEvaluator oM = new PawnInColumnHeuristicEvaluator();
        int evaluation = oM.evaluate(initTable);
        assertThat(evaluation).isEqualTo(+PawnInColumnHeuristicEvaluator.PENALTY);

    }

    @Test
    void InColumnThreeWhitePawnsReturnMinusDoublePenalty() {

        String[][] initTable = {
                {"r", "n", "b", "q", "k", "b", "n", "r"},
                {" ", "p", "p", "p", "p", "p", "p", "p"},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {"P", " ", " ", " ", " ", " ", " ", " "},
                {"P", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {"P", " ", " ", "P", "P", "P", "P", "P"},
                {"R", "N", "B", "Q", "K", "B", "N", "R"}
        };

        PawnInColumnHeuristicEvaluator oM = new PawnInColumnHeuristicEvaluator();
        int evaluation = oM.evaluate(initTable);
        assertThat(evaluation).isEqualTo(- 2 * PawnInColumnHeuristicEvaluator.PENALTY);

    }
    @Test
    void InColumnThreeBlackPawnsReturnPlusDoublePenalty() {

        String[][] initTable = {
                {"r", "n", "b", "q", "k", "b", "n", "r"},
                {"p", " ", " ", "p", "p", "p", "p", "p"},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {"p", " ", " ", " ", " ", " ", " ", " "},
                {"p", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {"P", " ", "P", "P", "P", "P", "P", "P"},
                {"R", "N", "B", "Q", "K", "B", "N", "R"}
        };

        PawnInColumnHeuristicEvaluator oM = new PawnInColumnHeuristicEvaluator();
        int evaluation = oM.evaluate(initTable);
        assertThat(evaluation).isEqualTo(+ 2 * PawnInColumnHeuristicEvaluator.PENALTY);

    }

    @Test
    void InColumnTwoWhiteAndBlackPawnsReturnZero() {

        String[][] initTable = {
                {"r", "n", "b", "q", "k", "b", "n", "r"},
                {" ", "p", "p", "p", "p", " ", "p", "p"},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {"P", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", "p"},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {"P", " ", "P", "P", "P", "P", "P", "P"},
                {"R", "N", "B", "Q", "K", "B", "N", "R"}
        };

        PawnInColumnHeuristicEvaluator oM = new PawnInColumnHeuristicEvaluator();
        int evaluation = oM.evaluate(initTable);
        assertThat(evaluation).isEqualTo(0);

    }


    @Test
    void InSameColumnTwoWhiteAndBlackPawnsReturnZero() {

        String[][] initTable = {
                {"r", "n", "b", "q", "k", "b", "n", "r"},
                {"p", "p", " ", "p", "p", "p", "p", "p"},
                {" ", " ", " ", "p", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", "P", " ", " ", " ", " "},
                {"P", "P", " ", "P", "P", "P", "P", "P"},
                {"R", "N", "B", "Q", "K", "B", "N", "R"}
        };

        PawnInColumnHeuristicEvaluator oM = new PawnInColumnHeuristicEvaluator();
        int evaluation = oM.evaluate(initTable);
        assertThat(evaluation).isEqualTo(0);

    }
}
