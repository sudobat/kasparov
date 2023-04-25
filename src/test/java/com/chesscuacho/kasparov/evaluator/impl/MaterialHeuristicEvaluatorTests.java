package com.chesscuacho.kasparov.evaluator.impl;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

public class MaterialHeuristicEvaluatorTests {

    @Test
    void InitialPositionShouldReturnZero(){

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

}
