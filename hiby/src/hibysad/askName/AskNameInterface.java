/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibysad.askName;

/**
 *
 * @author ajay
 */
public interface AskNameInterface {

    public String AskName(String context);

    public int AskNumber(String context);

    public String AskValues(String context, String keyword);

    public String AskKeywordString(String context);
    
    public String AskYesOrNo(String q);

}
