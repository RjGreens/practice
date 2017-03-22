/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibysad.askForAccessModifier;

import askAgain.AskAgain;
import hibysad.PrintOrHearValue.PrintHearValue;
import hibysad.askAgain.AskAgainInterface;
import hibysad.jineo.StringReader;

/**
 *
 * @author ajay
 */
public class AccessModifierClass implements AccessModifierInterface {

    PrintHearValue print;

    public AccessModifierClass() {
        print = new PrintHearValue();
    }

    @Override
    public String askForAccessModiFier() {
        print.print("(@) Enter the Access Modifier for the class.");
        StringReader s = new StringReader();
        String s1 = s.readString();
        String res = "";
        if (s1.equalsIgnoreCase("public")) {
            res = "public";
        } else if (s1.equalsIgnoreCase("none")) {
            res = "";
        } else {
            AskAgainInterface a = new AskAgain();
            a.AskAgainQues(true, "Access Modifier");
            askForAccessModiFier();
        }
        return res;
    }

    @Override
    public String askForAccessModiFireconstrutor(String context) {
        print.print("(@) Enter the Access Modifier for the " + context);
        StringReader s = new StringReader();
        String s1 = s.readString();
        String res = "";
        if (s1.equalsIgnoreCase("public")) {
            res = "public";
        } else if (s1.equalsIgnoreCase("private")) {
            res = "private";
        } else if (s1.equalsIgnoreCase("protected")) {
            res = "protected";
        } else if (s1.equalsIgnoreCase("default")) {
            res = "default";
        } else {
            AskAgainInterface a = new AskAgain();
            a.AskAgainQues(true, "Access Modifier");
            askForAccessModiFier();
        }
        return res;
    }

}
