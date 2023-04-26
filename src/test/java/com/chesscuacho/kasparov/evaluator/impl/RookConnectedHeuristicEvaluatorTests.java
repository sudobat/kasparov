package com.chesscuacho.kasparov.evaluator.impl;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RookConnectedHeuristicEvaluatorTests {

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
    void ConnectedInRowWhiteRooksReturnPlusBonus() {

        String[][] initTable = {
                {"r", "n", "b", "q", "k", "b", "n", "r"},
                {"P", "p", "p", "p", "p", "p", "p", "p"},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {"R", " ", " ", " ", " ", " ", " ", "R"},
                {"P", "P", "P", "P", "P", "P", "P", "P"},
                {" ", "N", "B", "Q", "K", "B", "N", " "}
        };

        RookConnectedHeuristicEvaluator oM = new RookConnectedHeuristicEvaluator();
        int evaluation = oM.evaluate(initTable);
        assertThat(evaluation).isEqualTo(+RookConnectedHeuristicEvaluator.BONUS);

    }

    @Test
    void NotConnectedInRowWhiteRooksReturnZero() {

        String[][] initTable = {
                {"r", "n", "b", "q", "k", "b", "n", "r"},
                {"P", "p", "p", "p", "p", "p", "p", "p"},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {"R", " ", " ", " ", "P", " ", " ", "R"},
                {"P", "P", "P", "P", " ", "P", "P", "P"},
                {" ", "N", "B", "Q", "K", "B", "N", " "}
        };

        RookConnectedHeuristicEvaluator oM = new RookConnectedHeuristicEvaluator();
        int evaluation = oM.evaluate(initTable);
        assertThat(evaluation).isEqualTo(0);

    }

    @Test
    void ConnectedInRowBlackRooksReturnMinusBonus() {

        String[][] initTable = {
                {" ", "n", "b", "q", "k", "b", "n", " "},
                {"P", "p", "p", "p", "p", "p", "p", "p"},
                {"r", " ", " ", " ", " ", " ", " ", "r"},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {"P", "P", "P", "P", "P", "P", "P", "P"},
                {"R", "N", "B", "Q", "K", "B", "N", "R"}
        };

        RookConnectedHeuristicEvaluator oM = new RookConnectedHeuristicEvaluator();
        int evaluation = oM.evaluate(initTable);
        assertThat(evaluation).isEqualTo(-RookConnectedHeuristicEvaluator.BONUS);

    }

    @Test
    void NotConnectedInRowBlackRooksReturnZero() {

        String[][] initTable = {
                {" ", "n", "b", "q", "k", "b", "n", " "},
                {"P", "p", "p", "p", " ", "p", "p", "p"},
                {"r", " ", " ", " ", "P", " ", " ", "r"},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {"P", "P", "P", "P", "P", "P", "P", "P"},
                {"R", "N", "B", "Q", "K", "B", "N", "R"}
        };

        RookConnectedHeuristicEvaluator oM = new RookConnectedHeuristicEvaluator();
        int evaluation = oM.evaluate(initTable);
        assertThat(evaluation).isEqualTo(0);

    }

    @Test
    void ConnectedInRowBlackAndWhiteRooksReturnZero() {

        String[][] initTable = {
                {" ", "n", "b", "q", "k", "b", "n", " "},
                {"P", "p", "p", "p", "p", "p", "p", "p"},
                {"r", " ", " ", " ", " ", " ", " ", "r"},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {"R", " ", " ", " ", " ", " ", " ", "R"},
                {"P", "P", "P", "P", "P", "P", "P", "P"},
                {" ", "N", "B", "Q", "K", "B", "N", " "}
        };

        RookConnectedHeuristicEvaluator oM = new RookConnectedHeuristicEvaluator();
        int evaluation = oM.evaluate(initTable);
        assertThat(evaluation).isEqualTo(0);

    }



    @Test
    void ConnectedInColumnWhiteRooksReturnPlusBonus() {

        String[][] initTable = {
                {"r", "n", "b", "q", "k", "b", "n", "r"},
                {"P", "p", "p", "p", "p", "p", "p", "p"},
                {"R", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {"R", " ", " ", " ", " ", " ", " ", " "},
                {"P", "P", "P", "P", "P", "P", "P", "P"},
                {" ", "N", "B", "Q", "K", "B", "N", " "}
        };

        RookConnectedHeuristicEvaluator oM = new RookConnectedHeuristicEvaluator();
        int evaluation = oM.evaluate(initTable);
        assertThat(evaluation).isEqualTo(+RookConnectedHeuristicEvaluator.BONUS);
    }


    @Test
    void ConnectedInColumnBlackRooksReturnMinusBonus() {

        String[][] initTable = {
                {" ", "n", "b", "q", "k", "b", "n", " "},
                {"P", "p", "p", "p", "p", "p", "p", "p"},
                {"r", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {"r", " ", " ", " ", " ", " ", " ", " "},
                {"P", "P", "P", "P", "P", "P", "P", "P"},
                {"R", "N", "B", "Q", "K", "B", "N", "R"}
        };

        RookConnectedHeuristicEvaluator oM = new RookConnectedHeuristicEvaluator();
        int evaluation = oM.evaluate(initTable);
        assertThat(evaluation).isEqualTo(-RookConnectedHeuristicEvaluator.BONUS);
    }

    @Test
    void NotConnectedInColumnWhiteRooksReturnZero() {

        String[][] initTable = {
                {"r", "n", "b", "q", "k", "b", "n", "r"},
                {"P", "p", " ", "p", "p", "p", "p", "p"},
                {"R", " ", " ", " ", " ", " ", " ", " "},
                {"p", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {"R", " ", " ", " ", " ", " ", " ", " "},
                {"P", "P", "P", "P", "P", "P", "P", "P"},
                {" ", "N", "B", "Q", "K", "B", "N", " "}
        };

        RookConnectedHeuristicEvaluator oM = new RookConnectedHeuristicEvaluator();
        int evaluation = oM.evaluate(initTable);
        assertThat(evaluation).isEqualTo(0);
    }


    @Test
    void NotConnectedInColumnBlackRooksReturnZero() {

        String[][] initTable = {
                {"r", "n", "b", "q", "k", "b", "n", "r"},
                {"P", "p", "p", " ", "p", "p", "p", "p"},
                {"R", " ", " ", " ", " ", " ", " ", " "},
                {"p", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {"R", " ", " ", " ", " ", " ", " ", " "},
                {"P", "P", "P", "P", "P", "P", "P", "P"},
                {" ", "N", "B", "Q", "K", "B", "N", " "}
        };

        RookConnectedHeuristicEvaluator oM = new RookConnectedHeuristicEvaluator();
        int evaluation = oM.evaluate(initTable);
        assertThat(evaluation).isEqualTo(0);
    }

    @Test
    void ConnectedInColumnBlackAndWhiteRooksReturnZero() {

        String[][] initTable = {
                {" ", "n", "b", "q", "k", "b", "n", " "},
                {"P", "p", "p", "p", "p", "p", "p", "p"},
                {"r", " ", " ", " ", " ", " ", " ", "R"},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {"r", " ", " ", " ", " ", " ", " ", "R"},
                {"P", "P", "P", "P", "P", "P", "P", "P"},
                {" ", "N", "B", "Q", "K", "B", "N", " "}
        };

        RookConnectedHeuristicEvaluator oM = new RookConnectedHeuristicEvaluator();
        int evaluation = oM.evaluate(initTable);
        assertThat(evaluation).isEqualTo(0);

    }

    @Test
    void ConnectedInRowAndColumnBlackAndWhiteRooksReturnZero() {

        String[][] initTable = {
                {" ", "n", "b", "q", "k", "b", "n", " "},
                {"P", "p", "p", "p", "p", "p", "p", "p"},
                {"r", " ", " ", " ", " ", " ", " ", "r"},
                {" ", " ", " ", " ", " ", " ", "R", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", "R", " "},
                {"P", "P", "P", "P", "P", "P", "P", "P"},
                {" ", "N", "B", "Q", "K", "B", "N", " "}
        };

        RookConnectedHeuristicEvaluator oM = new RookConnectedHeuristicEvaluator();
        int evaluation = oM.evaluate(initTable);
        assertThat(evaluation).isEqualTo(0);

    }
}
