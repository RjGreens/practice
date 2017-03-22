/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibysad.askName;

import javax.lang.model.SourceVersion;

import hibysad.PrintOrHearValue.PrintHearValue;
import hibysad.jineo.StringReader;

/**
 *
 * @author ajay
 */
public class AskNameClass implements AskNameInterface {

    PrintHearValue print;

    public AskNameClass() {
        print = new PrintHearValue();
    }

    @Override
    public String AskName(String context) {
        print.print("(@) Name the " + context);
        String s = new StringReader().readString();
        String s12;
        if (SourceVersion.isIdentifier(s) && !SourceVersion.isKeyword(s)) {
            s12 = s;
        } else {
            print.print("(@) Sorry name of the " + context + " is not right.");
            s12 = AskName("class");
        }
        return s12;
    }

    @Override
    public int AskNumber(String context) {
        print.print("(@) Name the number of " + context);
        int no = new StringReader().readInteger();
        return no;
    }

    @Override
    public String AskKeywordString(String context) {
        print.print("(@) Name the keyword for the " + context);
        String keyString = new StringReader().readString();
        String res;
        if (SourceVersion.isKeyword(keyString)) {
            res = keyString;
        } else {
            print.print("(@) Sorry name of the " + context + " is not right.");
            res = AskKeywordString(context);
        }
        return res;
    }

    @Override
    public String AskValues(String context, String keyword) {
        String s = null;
        print.print("(@) Enter value Corresponding to " + keyword);
        if (keyword.equalsIgnoreCase("int")) {
            s = String.valueOf(new StringReader().readInteger());
        } else if (keyword.equalsIgnoreCase("long")) {
            s = String.valueOf(new StringReader().readLong());
        } else if (keyword.equalsIgnoreCase("float")) {
            s = String.valueOf(new StringReader().readFloat());
        } else if (keyword.equalsIgnoreCase("double")) {
            s = String.valueOf(new StringReader().readDouble());
        } else if (keyword.equalsIgnoreCase("boolean")) {
            s = String.valueOf(new StringReader().readBoolean());
        } else if (keyword.equalsIgnoreCase("String")) {
            s = String.valueOf(new StringReader().readString());
        }
        return s;
    }

    @Override
    public String AskYesOrNo(String ques) {
        String s1 = null;
        print.print(ques);
        String s = String.valueOf(new StringReader().readString());
        if (s.equalsIgnoreCase("Yes")) {
            s1 = "Yes";
        } else if (s.equalsIgnoreCase("No")) {
            s1 = "No";
        } else{
            AskYesOrNo(ques);
        }
        return s1;
    }
}
