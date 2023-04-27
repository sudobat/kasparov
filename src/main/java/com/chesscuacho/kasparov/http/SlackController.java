package com.chesscuacho.kasparov.http;

import com.chesscuacho.kasparov.evaluator.HeuristicEvaluator;
import com.chesscuacho.kasparov.evaluator.util.UtilKasparov;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileReader;
import java.util.List;

@Controller
public class SlackController {
    @RequestMapping("/api/v1/slack-evaluate")
    public @ResponseBody SlackResponse greeting(@RequestParam (defaultValue = "") String entrada) {
        return new SlackResponse(entrada+UtilKasparov.getVersion());
    }
}
