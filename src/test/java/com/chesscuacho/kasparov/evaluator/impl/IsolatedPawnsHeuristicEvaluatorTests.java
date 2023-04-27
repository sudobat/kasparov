package com.chesscuacho.kasparov.evaluator.impl;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IsolatedPawnsHeuristicEvaluatorTests {

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

        IsolatedPawnsHeuristicEvaluator oM = new IsolatedPawnsHeuristicEvaluator();
        int evaluation = oM.evaluate(initTable);
        assertThat(evaluation).isEqualTo(0);

    }

    @Test
    void IsolatedWhitePawnShouldReturnMinusPenalty() {

        String[][] initTable = {
                {"r", "n", "b", "q", "k", "b", "n", "r"},
                {"p", "p", "p", "p", "p", "p", "p", "p"},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", "P", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {"P", "P", "P", "P", " ", "P", "P", "P"},
                {"R", "N", "B", "Q", "K", "B", "N", "R"}
        };

        IsolatedPawnsHeuristicEvaluator oM = new IsolatedPawnsHeuristicEvaluator();
        int evaluation = oM.evaluate(initTable);
        assertThat(evaluation).isEqualTo(-IsolatedPawnsHeuristicEvaluator.PENALTY);
    }

    @Test
    void TwoIsolatedWhitePawnShouldReturnDoubleMinusPenalty() {

        String[][] initTable = {
                {"r", "n", "b", "q", "k", "b", "n", "r"},
                {"p", "p", "p", "p", "p", "p", "p", "p"},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", "P", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", "P"},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {"P", " ", "P", "P", " ", "P", "P", " "},
                {"R", "N", "B", "Q", "K", "B", "N", "R"}
        };

        IsolatedPawnsHeuristicEvaluator oM = new IsolatedPawnsHeuristicEvaluator();
        int evaluation = oM.evaluate(initTable);
        assertThat(evaluation).isEqualTo(- 2 * IsolatedPawnsHeuristicEvaluator.PENALTY);
    }

    @Test
    void AdvancedNonIsolatedWhitePawnsShouldReturnZero() {

        String[][] initTable = {
                {"r", "n", "b", "q", "k", "b", "n", "r"},
                {"p", "p", "p", "p", "p", "p", "p", "p"},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", "P", " ", " ", " ", " ", " ", "P"},
                {" ", " ", "P", " ", " ", " ", "P", " "},
                {"P", " ", " ", "P", " ", "P", " ", " "},
                {"R", "N", "B", "Q", "K", "B", "N", "R"}
        };

        IsolatedPawnsHeuristicEvaluator oM = new IsolatedPawnsHeuristicEvaluator();
        int evaluation = oM.evaluate(initTable);
        assertThat(evaluation).isEqualTo(0);
    }


    @Test
    void IsolatedBlackPawnShouldReturnPlusPenalty() {

        String[][] initTable = {
                {"r", "n", "b", "q", "k", "b", "n", "r"},
                {"p", "p", "p", "p", " ", "p", "p", "p"},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", "p", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {"P", "P", "P", "P", "P", "P", "P", "P"},
                {"R", "N", "B", "Q", "K", "B", "N", "R"}
        };

        IsolatedPawnsHeuristicEvaluator oM = new IsolatedPawnsHeuristicEvaluator();
        int evaluation = oM.evaluate(initTable);
        assertThat(evaluation).isEqualTo(+IsolatedPawnsHeuristicEvaluator.PENALTY);
    }

    @Test
    void TwoIsolatedBlackPawnShouldReturnDoublePlusPenalty() {

        String[][] initTable = {
                {"r", "n", "b", "q", "k", "b", "n", "r"},
                {"p", " ", "p", "p", "p", "p", "p", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", "p", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", "p"},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {"P", "P", "P", "P", " ", "P", "P", "P"},
                {"R", "N", "B", "Q", "K", "B", "N", "R"}
        };

        IsolatedPawnsHeuristicEvaluator oM = new IsolatedPawnsHeuristicEvaluator();
        int evaluation = oM.evaluate(initTable);
        assertThat(evaluation).isEqualTo(+ 2 * IsolatedPawnsHeuristicEvaluator.PENALTY);
    }

    @Test
    void AdvancedNonIsolatedBlackPawnsShouldReturnZero() {

        String[][] initTable = {
                {"r", "n", "b", "q", "k", "b", "n", "r"},
                {"p", " ", " ", "p", "p", "p", "p", "p"},
                {" ", "p", " ", " ", " ", " ", " ", " "},
                {" ", " ", "p", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {"P", "P", "P", "P", "P", "P", "P", "P"},
                {"R", "N", "B", "Q", "K", "B", "N", "R"}
        };

        IsolatedPawnsHeuristicEvaluator oM = new IsolatedPawnsHeuristicEvaluator();
        int evaluation = oM.evaluate(initTable);
        assertThat(evaluation).isEqualTo(0);
    }
}
