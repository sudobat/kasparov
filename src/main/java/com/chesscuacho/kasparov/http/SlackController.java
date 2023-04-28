package com.chesscuacho.kasparov.http;

import com.chesscuacho.kasparov.evaluator.HeuristicEvaluator;
import com.chesscuacho.kasparov.evaluator.util.UtilKasparov;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileReader;
import java.util.List;

@Controller
public class SlackController {

    @Autowired
    private List<HeuristicEvaluator> heuristicEvaluatorList;
    @Value("${app.version:unknown}")
    String version;
    @RequestMapping("/api/v1/slack-evaluate")
   /* public @ResponseBody String greeting(@RequestParam (defaultValue = "") String fen) {

        return new EvaluatorController().greeting(fen).dameSlackResponseString();
    }*/






    public @ResponseBody String greeting(@RequestParam (defaultValue = "") String fen) {
        int resultScore = 0;
        if (!UtilKasparov.isValidFen(fen)) return "fen not valid" + version;

        String[][] matrixFen = UtilKasparov.FEN2Matrix(fen);
        for (HeuristicEvaluator miHeuristic : heuristicEvaluatorList) {
            resultScore += miHeuristic.evaluate(matrixFen);
        }

        //UtilKasparov oUtil = new UtilKasparov();
        return String.valueOf(resultScore) + " [" + version + "]";
    }
}
