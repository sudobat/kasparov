package com.chesscuacho.kasparov.http;

import com.chesscuacho.kasparov.evaluator.HeuristicEvaluator;
import com.chesscuacho.kasparov.evaluator.impl.MaterialHeuristicEvaluator;
import com.chesscuacho.kasparov.evaluator.util.UtilKasparov;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EvaluatorController {
    @Autowired
    private List<HeuristicEvaluator> heuristicEvaluatorList;
    @RequestMapping("/api/v1/evaluate")
    public @ResponseBody EvaluatorResponse greeting(@RequestParam (defaultValue = UtilKasparov.INIT_BOARD) String fen) {

        int resultScore = 0;
        if (!UtilKasparov.isValidFen(fen)) return new EvaluatorResponse(99999);

        String[][] matrixFen = UtilKasparov.FEN2Matrix(fen);
        for (HeuristicEvaluator miHeuristic : heuristicEvaluatorList) {
            resultScore += miHeuristic.evaluate(matrixFen);
        }

        return new EvaluatorResponse(resultScore);
    }
}
