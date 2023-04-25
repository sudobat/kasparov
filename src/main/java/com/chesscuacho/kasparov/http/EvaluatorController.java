package com.chesscuacho.kasparov.http;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EvaluatorController {

    @RequestMapping("/api/v1/evaluate")
    public @ResponseBody EvaluatorResponse greeting() {
        return new EvaluatorResponse(0);
    }
}
