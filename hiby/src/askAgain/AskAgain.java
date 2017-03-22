/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package askAgain;

import hibysad.PrintOrHearValue.PrintHearValue;
import hibysad.askAgain.AskAgainInterface;
import hibysad.jineo.StringReader;

/**
 *
 * @author ajay
 */
public class AskAgain implements AskAgainInterface {

    PrintHearValue print;

    public AskAgain() {
        print = new PrintHearValue();
    }

    @Override
    public String AskAgainQues(boolean iAsk, String context) {
        String s = "";
        s = new StringReader().readString();
        if (!iAsk) {
        } else {
            print.print("(@) Didn't get the " + context + " name.");
        }
        return s;
    }
}
