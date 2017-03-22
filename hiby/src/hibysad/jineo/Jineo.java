/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibysad.jineo;

import hibysad.MakeClass.ClassCreator;

/**
 *
 * @author ajay
 */
public class Jineo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        StringReader s = new StringReader();
        String s1="";
        while (!s1.equalsIgnoreCase("finish")) {
            s1 = s.readString();
            if (s1.equalsIgnoreCase("classify")) {
                ClassCreator classCreator = new ClassCreator(s1);
                classCreator.createClass();
                break;
            }
        }
    }
}
