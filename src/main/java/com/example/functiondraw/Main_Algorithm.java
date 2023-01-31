package com.example.functiondraw;

public class Main_Algorithm {
    public static String Calculator(String Expression )throws Exception {
        try {
            String str = " " + Expression; // start with identation to check case of negative number
            String strSendedToclasses = ""; //this what i send
            float[] numbersStored = new float[10];
            int ind = 0;
            String fristOperand = "";
            for (int i = 1; i < str.length(); i++) {

                if (str.charAt(i) == '√') {
                    String underRoot = "";
                    i++;
                    while (i < str.length() && ((str.charAt(i) >= '0' && str.charAt(i) <= '9') || str.charAt(i) == '.')) {
                        underRoot += str.charAt(i);
                        i++;

                    }
                    i--;
                    float temp = (float) Math.sqrt((double) Float.parseFloat(underRoot));

                    if (!fristOperand.isEmpty()) {

                        fristOperand = String.valueOf(temp * Float.parseFloat(fristOperand));
                    } else {
                        fristOperand += String.valueOf(temp);
                    }

                } else if ((str.charAt(i) >= '0' && str.charAt(i) <= '9') || str.charAt(i) == '.') {

                    fristOperand += str.charAt(i);
                } else if (str.charAt(i) == '-' && !(str.charAt(i - 1) >= '0' && str.charAt(i - 1) <= '9'))// if negative number
                {
                    fristOperand += str.charAt(i);
                } else {
                    numbersStored[ind] = Float.parseFloat(fristOperand);
                    strSendedToclasses += (char) ('a' + ind);
                    if (str.charAt(i) == ' ') {
                        strSendedToclasses += '+';
                    } else {
                        strSendedToclasses += str.charAt(i);
                    }
                    fristOperand = "";
                    ind++;
                }
            }

            numbersStored[ind] = Float.parseFloat(fristOperand);
            strSendedToclasses += (char) ('a' + ind);
            fristOperand = "";
            ind++;

            String out = InfixToPostfix.infixToPostfix(strSendedToclasses);
            float result = Evaluator.evaluate(out, numbersStored);
            if (Math.abs(result) > (int) Math.abs(result)) {
                return  String.valueOf(result);
            } else {
                return  String.valueOf((int) result);
            }
        } catch (Exception e) {
            return "Error";
        }
    }
}
