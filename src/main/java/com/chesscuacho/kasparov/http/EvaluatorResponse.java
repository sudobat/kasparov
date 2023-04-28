package com.chesscuacho.kasparov.http;

public class EvaluatorResponse {

    public int score;
    public String version;

    public EvaluatorResponse(int score, String version) {
        this.score = score;this.version = version;
    }
    public String dameSlackResponseString(){
        return score + " [" + version + "]";
    }
}
