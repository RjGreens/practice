/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibysad.variablesCreation;

import hibysad.PrintOrHearValue.PrintHearValue;
import hibysad.askName.AskNameClass;

/**
 *
 * @author ajay
 */
public class VariableCreationClass implements varaibleCreationInterface {

    PrintHearValue print;

    public VariableCreationClass() {
        print = new PrintHearValue();
    }

    @Override
    public String createVariables(int no) {
        AskNameClass ask = new AskNameClass();
        String s = "";
        for (int i = 0; i < no; i++) {
            print.print("Creating Variable " + (i + 1));
            String keyWord = ask.AskKeywordString("Instance Variable");
            String var = ask.AskName("Variables");
            String varValue = ask.AskValues("Values", keyWord);
            print.print(keyWord + " " + var + " = " + varValue + ";");
            s += ((keyWord + " " + var + " = " + varValue + ";") + "\n");
        }
        return s;
    }

    @Override
    public String createParamsRandom(int no) {
        AskNameClass ask = new AskNameClass();
        String s = "";
        for (int i = 0; i < no; i++) {
            print.print("Creating Instance Variable " + (i + 1));
            String keyWord = ask.AskKeywordString("Keyword");
            String var = ask.AskName("Variables");
            print.print(keyWord + " " + var + ";");
            if (i == no - 1) {
                s += (keyWord + " " + var);
            } else {
                s += (keyWord + " " + var + ",");
            }
        }
        return s;
    }
}