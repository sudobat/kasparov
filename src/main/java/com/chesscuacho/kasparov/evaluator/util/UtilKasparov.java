package com.chesscuacho.kasparov.evaluator.util;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.springframework.beans.factory.annotation.Value;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilKasparov {

    public static final String INIT_BOARD = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR";

        public static String[][] FEN2Matrix(String inStr) {

            if ((inStr == null) || "".equals(inStr)) {
                return new String[8][8];
            }

            String strg[] = inStr.split(" ");
            String temp = strg[0];
            String temp2[] = temp.split("/");

            String board[][] = new String[8][8];
            for(int i=0;i<8;i++){
                String str = temp2[i];
                int k = 0;
                for(int j=0;j<str.length();j++){
                    char code = str.charAt(j);
                    if (Character.isDigit(code)){
                        int num = Integer.parseInt(""+code);
                        for(int ii=0;ii<num;ii++) {
                            board[i][k] = " ";
                            k++;
                        }
                    }
                    else{
                        board[i][k] = "" + code;
                        k++;
                    }
                }
            }
            return board;
        }

    public static boolean isValidFen(String fen) {
        Pattern pattern = Pattern.compile("((([prnbqkPRNBQK12345678]*/){7})([prnbqkPRNBQK12345678]*))");
        Matcher matcher = pattern.matcher(fen);
        if (!matcher.matches()) {
            return false;
        }

        // Check each rank.
        String[] ranks = matcher.group(2).split("/");
        for (String rank : ranks) {
            if (!verifyRank(rank)) {
                return false;
            }
        }
        if (!verifyRank(matcher.group(4))) {
            return false;
        }

        // Check two kings.
        if (!matcher.group(1).contains("k") || !matcher.group(1).contains("K")) {
            return false;
        }

        return true;
    }

    private static boolean verifyRank(String rank) {
        int count = 0;
        for (int i = 0; i < rank.length(); i++) {
            if (rank.charAt(i) >= '1' && rank.charAt(i) <= '8') {
                count += (rank.charAt(i) - '0');
            } else {
                count++;
            }
        }
        return count == 8;
    }
    @Value("${app.version:unknown}")
    String version;
    public  String getVersion()  {
       /* MavenXpp3Reader reader = new MavenXpp3Reader();
        try{
            Model model = reader.read(new FileReader("pom.xml"));
            return model.getVersion();
        } catch(IOException  |XmlPullParserException e) {}*/
        return version;
        //return "Sin versión";
    }
}